/**
 * This class makes two different decks, a pokemon deck and a charizard deck. The point of this code is to create a monte carlo and to get the results through the eyes of a stats person. The pokemon deck is created by starting with just 1 pokemon inside the deck and the rest of the cards are trainer cards. It checks the probability of the person drawing that 1 pokemon out of 60 cards and runs it in nth amount of trials. After we get the probability from 1 pokemon we add a second pokemon, and then a third, and so on until we get to a number where the probability doesn't change.
 * 
 * The charizard deck is similar to the pokemon deck but instead it is checking the probability of the deck being bricked, which means you can' win, by checking the win condition. The win condition is that there has to be a rare candy inside your deck or in hand for the player to have a chance of winning. If there is no rare candy, but instead it is in the prize pool, then the chances of winnning is zero and the deck is bricked. We check with 1 rare candy in deck, then 2,3, and 4.
 * 
 * @author Melvin Vazquez
 */
package MonteCarlo;
//We import different utilites that we use throughout the code like ArrayList and random generator
import java.util.ArrayList;
import java.util.Random;

import PokemonCardGame.Card;
import PokemonCardGame.Energy;
import PokemonCardGame.Pokemon;
import PokemonCardGame.Trainer;
/**
 * This creates the local variables that will be used throughout the code for each method
 */
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
	//This method initializes the variables 
	public MonteCarlo() {
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		prizePool = new ArrayList<Card>();
	}
	/**
	 * The method drawCard uses a random generator to draw a card from the deck that will be added to hand
	 * @return drawnCard - the card that was found from deck
	 */
	
	public Card drawCard() {
		Random rng = new Random();
		int cardIndex = rng.nextInt(deck.size());
		Card drawnCard = deck.get(cardIndex);
		deck.remove(cardIndex);
		return drawnCard;
	}
	/**
	 * This method uses the drawCard method to add 6 cards to the prize pool
	 */
	public void prizePool(){
		for(int i = 0; i < 6; i++) {
			prizePool.add(drawCard());
		}
	}
	/**
	 * This method draws hand for the user by using the drawCard method to draw 7 cards from deck and add to hand
	 */
	public void drawHand() {
		for (int i = 0; i < 7; i++) {// We're counting to 7
			hand.add(drawCard());
		}
	}
	/**
	 * This method is the main one used for the monte carlo because it creates the deck of 60 cards that the user will use and the amount of pokemon that will be put into the deck.
	 * @param numOfPokemon - gets the number of pokemon to be inserted into the deck
	 */
	public void constructDeck(int numOfPokemon){
		deck.clear(); //clears the arraylist
		hand.clear(); //clears hand of pokemon
		pokemonCount = 0;
		for(int i = 0; i < numOfPokemon; i++ ) {
			deck.add(new Pokemon());
			pokemonCount++; //counts the number of pokemon inside deck
		}
		for(int j = numOfPokemon; j < deckSize; j++ ){
			deck.add(new Energy());
		}
	}
	/**
	 * This method returns a boolean value by checking the opening hand after the user finishes drawing 7 cards. It will check whether the user drew a pokemon.
	 * @return true/false - If pokemon is present in opening hand then a value of true is returned otherwise it will be false
	 */
	public boolean evaluateOpeningHand(){
		boolean havePokemon = false;
		for (int i = 0; i < hand.size(); i++) {
			Card currentCard = hand.get(i);
			if (currentCard instanceof Pokemon) {
				trueCount++; //counts the number of times a pokemon is drawn
				return true;
			}
		}
		falseCount++; //counts the number of times a pokemon is not drawn
		return false;
	}
	/**
	 * This method is used as the engine of the program to run an nth amount of times and will keep looping until 59 pokemon are added into the deck. The results will be printed for the user to see after each loop is done.
	 */
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
	
	
	/**
	 * This method creates the charizard deck and takes an input of the number of candy to be put into deck 
	 * 
	 * @param numOfRareCandy - number of rare candy to be put into deck 
	 */
	public void constructCharDeck(int numOfRareCandy){
		hand.clear();
		deck.clear();
		candyCount = 0;
		for(int i = 0; i < numOfRareCandy; i++ ) {
			deck.add(new RareCandy());
			candyCount++; //counts number of candy in deck
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
	/**
	 * This method puts all the cards in hand back into the deck and then draws hand again
	 */
	public void reshuffle(){
		deck.addAll(hand);
		hand.clear();
		drawHand();
	}
	/**
	 * This method checks whether your hand has a rare candy or not
	 * 
	 * @return - true/false - if rare candy in hand then a value of true is returned otherwise false
	 */
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
	/**
	 * This method checks whether the deck has a rare candy inside and returns a value of true or not
	 * 
	 * @return true/false - if deck has rare candy then a value of true is given otherwise false 
	 */
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
	/**
	 * This method checks whether the prize pool has a rare candy inside and returns a value of true or not
	 * 
	 * @return true/false - if prize pool has rare candy then a value of true is given otherwise false 
	 */
	public boolean checkPrize(){
		boolean haveRareCandy = false;
		for (int i = 0; i < prizePool.size(); i++) {
			Card currentCard = prizePool.get(i);
			if (currentCard instanceof RareCandy){
				insidePrize++; //returns a count of the amount of rare candies in prize pool
			}
		}
		return false;
	}
	/**
	 * This method clears the prizePool of cards 
	 */
	public void resetPrize() {
		prizePool.clear();
	}
	/**
	 * This method draws 6 cards into deck and adds a pokemon card purposefully so that the loop runs everytime without worrying about drawing a pokemon
	 */
	public void drawHand2() {
		for (int i = 0; i < 6; i++) {// We're counting to 7
			hand.add(drawCard());
		}
		hand.add(new Pokemon());
	}
	/**
	 * This method is the engine that runs the charizard Monte Carlo and gets the results of the probability of the deck being bricked after nth amount of trials. Calls all methods created for the charizard monte carlo 
	 */
	public void runCharizardMonteCarlo(){
		double probabilityResult;
		for(int i = 1; i < 5; i++) {
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
			probabilityResult = (bricked/(double)(notBricked+bricked)); //calculates the results 
			System.out.println("You have " + insidePrize + " rare candies inside your prize pool");
			System.out.println("Your deck is bricked " + bricked + " times when there are " + candyCount + " rare candies in deck");
			System.out.println("Your deck is not bricked " + notBricked + " times when there are " + candyCount + " rare candies in deck");
			System.out.println("Probability of deck being bricked with " + candyCount + " rare candies is: " + probabilityResult + "\n");
		}
	}
}
