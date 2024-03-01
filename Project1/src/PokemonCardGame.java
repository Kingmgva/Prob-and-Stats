/*
 * This class is where the bulk of the pokemon card game is created and is the main engine that sets up the game and runs the game.
 * 
 * @author Melvin Vazquez
 */

import java.util.ArrayList;
import java.util.Random;

public class PokemonCardGame {
	//initializes a private array list deck which is used in constructing a deck filled with energy, trainer, and pokemon cards
	private ArrayList<Card> deck;
	//initializes a private array list hand, which is used to draw from deck and add to hand for the user to use in game
	private ArrayList<Card> hand;
	//initializes a private array list bench, which is for the user to pick up to 5 basic pokemons to put face down
	private ArrayList<Card> bench;
	private ArrayList<PokemonCardGame>player1;
	private ArrayList<PokemonCardGame>player2;
	private int deckSize = 60;
	
	public PokemonCardGame(){
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		bench = new ArrayList<>();
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
	public void player1() {
		constructDeck();
	}
	public void player2() {
		constructDeck();
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
	public void constructDeck(){
		deck.clear();
		hand.clear();
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
	public void reDrawHand() {
		hand.clear();
		drawHand();
	}
	
	//Make engine for program
	public void run(){
		constructDeck();
		drawHand();
		while(evaluateOpeningHand() == false){
				constructDeck();
				reDrawHand();
	        }
		System.out.println("Got a Pokemon");
		System.out.println(deck);
		System.out.println(hand);
	}
	public void playNestBall() {
		//find pokemon
		ArrayList<Card> tempPokemon = new ArrayList<>();
		boolean done =false;
		int i = 0;
		while(i < deck.size()) {
			if(deck.get(i) instanceof Pokemon) {
				tempPokemon.add(deck.get(i));
				deck.remove(i);
			}
			else {
				i++;
			}
		}
		System.out.println("Pokemon found so far: " + tempPokemon);
		System.out.println("Count: " + tempPokemon.size());
		
		Random ranPokemon = new Random();
		int saveRanPokemon = ranPokemon.nextInt(tempPokemon.size());
		bench.add(tempPokemon.get(saveRanPokemon));
		tempPokemon.remove(saveRanPokemon);
		
		for(int j = 0; j < tempPokemon.size(); j++) {
			deck.add(tempPokemon.get(i));
		}
	}
	public void playProfessorsResearch(){
		
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
	public void setUpGame() {
		constructDeck();
		playNestBall();
		//look at hand
		//get card from hand
		//card.playable();
	}
	public void runGame() {
		//System.out.printf("'%s','%s', '%f', '%s'", hand, field, prize, cardStats);
	}
}

