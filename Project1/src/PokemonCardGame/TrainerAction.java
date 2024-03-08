/**
 * This is the interface that implements the method used by trainer cards to play their card effects
 * 
 * @author Melvin Vazquez
 */
package PokemonCardGame;

public interface TrainerAction {
	/**
	 * Method that plays trainer card
	 * @param gameState - this is getting the class of Player where this method will be called so that we are also able to use methods from that class
	 */
	void playable(Player gameState);
	
}
