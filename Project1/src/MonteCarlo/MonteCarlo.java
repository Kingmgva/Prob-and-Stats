package MonteCarlo;

import java.util.ArrayList;
import java.util.Random;

import PokemonCardGame.Card;
import PokemonCardGame.Energy;
import PokemonCardGame.Pokemon;
import PokemonCardGame.RareCandy;
import PokemonCardGame.Trainer;

public class MonteCarlo {
	private ArrayList<Card> deck; 
	private ArrayList<Card> hand;
	private ArrayList<Card> prizePool;
	private int pokemonCount;
	private int candyCount;
	private int trueCount;
	private int falseCount;
	private int bricked;
	private int notBricked;
	private int deckSize = 60;
	private int insidePrize;
	
	public MonteCarlo() {
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		prizePool = new ArrayList<Card>();
	}
	public Card drawCard() {
		Random rng = new Random();
		int cardIndex = rng.nextInt(deck.size()); // Find Random card
		Card drawnCard = deck.get(cardIndex);
		deck.remove(cardIndex);
		return drawnCard;
	}
	public void prizePool(){
		for(int i = 0; i < 6; i++) {
			prizePool.add(drawCard());
		}
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
	public void runPokemonMonteCarlo(){
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
	
	
	
	public void constructCharDeck(int numOfRareCandy){
		hand.clear();
		deck.clear();
		candyCount = 0;
		for(int i = 0; i < numOfRareCandy; i++ ) {
			deck.add(new RareCandy());
			candyCount++;
		}
		for(int j = 0; j < 15; j++ ){
			deck.add(new Energy());
		}
		for(int k = 0; k < 14; k++ ){
			deck.add(new Pokemon());
		}
		for(int h = 0; h < 30-numOfRareCandy; h++) {
			deck.add(new Trainer());
		}
	}
	public void reshuffle(){
		hand.clear();
		drawHand();
	}
	
	public boolean checkHand() {
			boolean haveRareCandy = false;
			for (int i = 0; i < hand.size(); i++) {
				Card currentCard = hand.get(i);
				if (currentCard instanceof RareCandy) {
					return true;
				}
			}
			return false;
		}
	public boolean checkDeck(){
		boolean haveRareCandy = false;
		for (int i = 0; i < deck.size(); i++) {
			Card currentCard = deck.get(i);
			if (currentCard instanceof RareCandy) {
				return true;
			}
		}
		return false;
	}
	public boolean checkPrize(){
		boolean haveRareCandy = false;
		for (int i = 0; i < prizePool.size(); i++) {
			Card currentCard = prizePool.get(i);
			if (currentCard instanceof RareCandy){
				insidePrize++;
			}
		}
		return false;
	}
	public void resetPrize() {
		prizePool.clear();
	}
	public void drawHand2() {
		for (int i = 0; i < 6; i++) {// We're counting to 7
			hand.add(drawCard());
		}
		hand.add(new Pokemon());
	}
	
	public void runCharizardMonteCarlo(){
		for(int i = 1; i < 60; i++) {
			bricked = 0;
			notBricked = 0;
			for(int k = 0; k <100000; k++) {
				constructCharDeck(i);
				drawHand2();
				if(evaluateOpeningHand()){
					prizePool();
					insidePrize = 0;
					if(checkHand() || checkDeck()) {
						notBricked++;
					}
					else {
						bricked++;
					}
					checkPrize();
					resetPrize();
				}
				else {
					reshuffle();
				}
			}
			System.out.println("You have " + insidePrize + " rare candies inside your prize pool");
			System.out.println("Your deck is bricked " + bricked + " times when there are " + candyCount + " rare candies in deck");
			System.out.println("Your deck is not bricked " + notBricked + " times when there are " + candyCount + " rare candies in deck\n");
		}
	}
}
