/**
 * This class extends Trainer and implements the interface TrainerAction. This class is creating the card Professors Research. This class discards your hand and draws seven new cards to add to hand
 * 
 * @author Melvin Vazquez
 */
package PokemonCardGame;
import java.util.ArrayList;
import java.util.Random;

public class ProfessorsResearch extends Trainer implements TrainerAction{
	public ProfessorsResearch() {
		/**
		 * This uses the method in trainer to set the name of this card 
		 */
		setName("Professors Research");
	}
	/**
	 * This method is called from trainerAction so that just like attack there is no need to make repeated code and multiple if elseif statements. This creates the card effect and plays it in game. 
	 * Gets rid of hand and draws 7 new cards 
	 * 
	 * @param gameState - this is getting the class of Player where this method will be called so that we are also able to use methods from that class
	 */
	public void playable(Player gameState)
	{
		/**
		 * creates variables that gets the deck, hand, and discard from player class
		 */
		ArrayList<String> newHand = new ArrayList<String>();
		ArrayList<Card> deck = gameState.getDeck();
		ArrayList<Card> hand = gameState.getHand();
		ArrayList<Card> discard = gameState.getDiscard();
		discard.addAll(hand);
		hand.clear();
		/**
		 * Loops until 7 cards are drawn
		 */
		while(hand.size() < 7){
			Random rng = new Random();
			int cardIndex = rng.nextInt(deck.size());
			Card drawnCard = deck.get(cardIndex);
			deck.remove(cardIndex);
			hand.add(drawnCard);
		}
		for(int j = 0; j < 7; j++) {
			newHand.add(hand.get(j).getName());
		}
		System.out.println(newHand);
	}
}
	
	
	
	
