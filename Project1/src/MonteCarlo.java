import java.util.ArrayList;
import java.util.Random;

public class MonteCarlo {
	private ArrayList<Card> deck; // This is the constructors job. = new Card[];
	private ArrayList<Card> hand;
	private int pokemonCount;
	private int trueCount;
	private int falseCount;
	private int deckSize = 60;
	
	public MonteCarlo() {
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
	public void constructDeck(int numOfPokemon){
		deck.clear();
		hand.clear();
		pokemonCount = 0;
		for(int i = 0; i < numOfPokemon; i++ ) {
			deck.add(new Pokemon());
			pokemonCount++;
		}
		for(int j = numOfPokemon; j < deckSize; j++ ){
			deck.add(new Energy());
		}
	}
	public boolean evaluateOpeningHand(){
		boolean havePokemon = false;
		for (int i = 0; i < hand.size(); i++) {
			Card currentCard = hand.get(i);
			if (currentCard instanceof Pokemon) {
				trueCount++;
				return true;
				
			}
		}
		falseCount++;
		return false;
	}
	
	//Make engine for program
	public void run(){
		for(int i = 0; i < deckSize; i++){
			trueCount = 0;
			falseCount = 0;
	        for(int j = 0; j < 10000; j++) {
	        	constructDeck(i);
	            drawHand();
	            evaluateOpeningHand();
	        }
			System.out.println("True Count for " + pokemonCount + " pokemon in deck is: " + trueCount +  "\nFalse Count for " + pokemonCount + " pokemon in deck is: " + falseCount );
		}
	}
}
