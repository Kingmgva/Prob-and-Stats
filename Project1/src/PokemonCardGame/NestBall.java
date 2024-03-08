/**
 * This class extends Trainer and implements the interface TrainerAction. This class is creating the card Nest Ball which checks your deck for a basic pokemon that then adds to your bench.
 * 
 * @author Melvin Vazquez
 */
package PokemonCardGame;
import java.util.ArrayList;


public class NestBall extends Trainer implements TrainerAction{
	public NestBall() {
		/**
		 * This uses the method in trainer to set the name of this card 
		 */
		setName("Nest Ball");
	}
	/**
	 * This method is called from trainerAction so that just like attack there is no need to make repeated code and multiple if elseif statements. This creates the card effect and plays it in game. 
	 * checks deck for pokemon and adds the first found basic pokemon to bench
	 * 
	 * @param gameState - this is getting the class of Player where this method will be called so that we are also able to use methods from that class
	 */
	public void playable(Player gameState){
		/**
		 * Creates variables to get deck and bench
		 */
		ArrayList<Card> deck = gameState.getDeck();
		ArrayList<Card> bench = gameState.getBench();
		int pokeAdded=0;
		int i = 0;
		/**
		 * loops until first pokemon is found and added to bench
		 */
		while (i < deck.size()) {
			if (deck.get(i) instanceof Pokemon && bench.size() < 5) {
				bench.add(deck.get(i));
				deck.remove(i);
				pokeAdded++;
				i = deck.size();
			} 
			else {
				i++;
			}
		}
		if(pokeAdded == 0) {
			System.out.println("no pokemon found or bench is full");
		}
	}
}
