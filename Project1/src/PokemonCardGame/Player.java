package PokemonCardGame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player{
	private ArrayList<Card> deck; 
	private ArrayList<Card> hand;
	private ArrayList<Card> prizePool;
	private ArrayList<Card> discard; 
	private ArrayList<Card> bench;
	private ArrayList<Card> active;
	Scanner input = new Scanner(System.in);
	
	public Player(){
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		prizePool = new ArrayList<Card>();
		discard = new ArrayList<Card>();
		bench = new ArrayList<Card>();
		active = new ArrayList<Card>();
	}
	public void constructDeck(){
		for(int i = 0; i < 20; i++ ) {
			deck.add(new Pokemon());
		}
		for(int j = 0; j < 20; j++ ){
			deck.add(new Energy());
		}
		for(int k = 0; k < 20; k++) {
			deck.add(new Trainer());
		}
	}
	public Card drawCard() {
		Random rng = new Random();
		int cardIndex = rng.nextInt(deck.size()); // Find Random card
		Card drawnCard = deck.get(cardIndex);
		deck.remove(cardIndex);
		return drawnCard;
	}
	public void drawHand() {
		for (int i = 0; i < 7; i++) {// We're counting to 7
			hand.add(drawCard());
		}
	}
	public void reshuffle(){
		hand.clear();
		drawHand();
	}
	public void prize() {
		for (int i=0; i<6; i++) {
			prizePool.add(drawCard());
		}
	}
	public boolean evaluateOpeningHand(){
		boolean havePokemon = false;
		for (int i = 0; i < hand.size(); i++) {
			Card currentCard = hand.get(i);
			if (currentCard instanceof Pokemon) {
				return true;
			}
		}
		return false;
	}
	public void startOfGame() {
		System.out.printf("Hand: '%s'\nDeck: '%s'\nPrize cards: '%d'\nBench:  '%s'", hand, deck, prizePool.size(), bench);
	}
	public void printDeck() {
		
	}
	public void setBoard() {
		int chosenPoke;
		String userInput;
		prize();
		System.out.println("What pokemon from your hand do you want to put as your active? (Please input the number location of the pokemon. Ex:hand = [Charizard, Pikachu, Bulbasaur] want to choose pikachu, which is at location 2. \n\n" + getHand());
		chosenPoke = input.nextInt();
		Card currentCard = hand.get(chosenPoke - 1);
		if (currentCard instanceof Pokemon) {
			Pokemon chosenPokemon = (Pokemon)currentCard;
			activeField(chosenPokemon);
		}
		else {
			System.out.println("Invalid choice, choose a pokemon to put on active field, (Use corresponding number please)");
			chosenPoke = input.nextInt();
		}
		
		for (int i = 0; i < hand.size(); i++) {
			currentCard = hand.get(i);
			if (currentCard instanceof Pokemon) {
				System.out.println("Would you like to add a pokemon to the bench? (Yes or no)");
				userInput = input.next();
				if(userInput == "yes") {
					System.out.println("Which pokemon would you like to add? (Please indicate number location)" + getHand());
					chosenPoke = input.nextInt();
					for (int k = 0; k < hand.size(); k++) {
						currentCard = hand.get(chosenPoke - 1);
						if (currentCard instanceof Pokemon) {
							Pokemon chosenPokemon = (Pokemon)currentCard;
							benchField(chosenPokemon);
						}
					}
				}
				else if(userInput == "no") {
					System.out.println("Okay");
				}
				else {
					System.out.println("Invalid input, type yes or no please");
					userInput = input.next();
				}
			}
			else {
				System.out.println("Your board is fully set up");
				break;
			}
		}
	}

	public ArrayList<Card> getDeck(){
		return deck;
	}
	public ArrayList<Card> getBench(){
		return bench;
	}
	public ArrayList<Card> getHand(){
		return hand;
	}
	public int getPrize() {
		return prizePool.size();
	}
	public void playerSetUp() {
		constructDeck();
		drawHand();
	}
	public void attack() {
		
	}
	public void activeField(Pokemon chosen) {
		active.add(chosen);
		hand.remove(chosen);
	}
	public void benchField(Pokemon chosen) {
		bench.add(chosen);
		hand.remove(chosen);
	}
	public void prizeCheck() {
		
	}
	

}
