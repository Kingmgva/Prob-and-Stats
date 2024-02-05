//60, there's a catch, in order to take a turn you needed to have a basic pokemon in your hand.
//Let's write a monte carlo simulation. That means, using raw brute force, try to figure out
//something interesting

//what if your deck had exactly 1 pokemon. How many times would you expect to have to 
//"Mulligan" in order to have your only pokemon in your hand.

//What if your deck had 2? Etc.

//Write a simulation that shows the expected mulligans at 1-60 pokemons in your deck.
//result should be 59 or 60 data points that you can plot into excel to determine the
//ideal pokemon count so that you can consistently draw into a pokemon in your first hand

import java.util.ArrayList;
import java.util.Random;

public class PokemonCardGame {
	// A deck of cards.
	private ArrayList<Card> deck; // This is the constructors job. = new Card[];
	private ArrayList<Card> hand;
	private ArrayList<PokemonCardGame>player1;
	private ArrayList<PokemonCardGame>player2;
	private int deckSize = 60;
	
	public PokemonCardGame(){
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
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
		ArrayList<> deck = new ArrayList<>();
	}
	public void player2() {
		
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
		for(int i = 0; i < 21; i++ ) {
			deck.add(new Pokemon());
		}
		for(int j = 0; j < 21; j++ ){
			deck.add(new Energy());
		}
		for(int k = 0; k < 21; k++) {
			deck.add(new Trainer());
		}
	}
	
	//Make engine for program
	public void run(){
		constructDeck();
		drawHand();
		while(evaluateOpeningHand() == false){
				constructDeck();
				drawHand();
	        }
		System.out.println("Got a Pokemon");
		System.out.println(deck);
		System.out.println(hand);
	}
	public void setUpGame() {
		
	}
	public void runGame() {
		
	}
}

