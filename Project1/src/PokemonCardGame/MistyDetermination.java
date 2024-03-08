/**
 * This class extends Trainer and implements the interface TrainerAction. This class is creating the card Misty's Determination which discards one card from hand, draws the top 8 cards from deck, and choose one from those 8 cards to add to hand, and then put back in deck and reshuffle deck.
 * 
 * @author Melvin Vazquez
 */
package PokemonCardGame;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class MistyDetermination extends Trainer implements TrainerAction {
	/**
	 * Creates a scanner so player has the ability to input and interact
	 */
	Scanner input = new Scanner(System.in);
	public MistyDetermination() {
		/**
		 * This uses the method in trainer to set the name of this card 
		 */
		setName("Misty's Determination");
	}
	/**
	 * This method is called from trainerAction so that just like attack there is no need to make repeated code and multiple if elseif statements. This creates the card effect and plays it in game. 
	 * discards one card from hand, looks at top 8 cards from deck, adds one to deck, and then puts back cards in deck and reshuffle
	 * 
	 * @param gameState - this is getting the class of Player where this method will be called so that we are also able to use methods from that class
	 */
	public void playable(Player gameState) {
		/**
		 * Variables used for this method that gets the deck, hand, and discard from player class and gets player input for when they pick card
		 */
		int userPick;
		ArrayList<Card> deck = gameState.getDeck();
		ArrayList<Card> top8Cards = new ArrayList<Card>();
		ArrayList<Card> hand = gameState.getHand();
		ArrayList<Card> discard = gameState.getDiscard();
		/**
		 * This part of the code gets rid of one card from hand and adds to discard pile
		 */
		Card currentCard = new Card();
		System.out.println("Pick a card to get rid of (pick number location): \n" + hand);
		userPick = input.nextInt();
		currentCard = hand.get(userPick -1);
		discard.add(currentCard);
		System.out.println("Now you'll draw the top 8 cards from your deck.\n");
		/**
		 * This for loop uses a randomizer to draw the top 8 cards 
		 */
		for(int i = 0; i<8; i++) {
			Random rng = new Random();
			int cardIndex = rng.nextInt(deck.size());
			Card drawnCard = deck.get(cardIndex);
			deck.remove(cardIndex);
			top8Cards.add(drawnCard);
		}
		/**
		 * This creates another array that adds the top8 cards to and gets their name from their class so that it prints out the accurate name and not Pokemongame.water
		 */
		ArrayList<String> handNames = new ArrayList<String>();
		for(int i=0; i < top8Cards.size(); i++){
			handNames.add(top8Cards.get(i).getName());
		}
		/**
		 * This part asks user for which card they want to add and gets that input and adds to deck
		 */
		System.out.println("Pick a card to add to your hand (Input a number that matches location of where card is): \n" + handNames);
		userPick = input.nextInt();
		currentCard = top8Cards.get(userPick-1);
		hand.add(currentCard);
		deck.addAll(top8Cards);
		top8Cards.clear();
		System.out.println(hand);
	}
}
