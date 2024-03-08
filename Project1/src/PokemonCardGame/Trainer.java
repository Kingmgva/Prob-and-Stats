/**
 * This class is one of the card types called Trainer and this class extends Card and implements the interface TrainerAction. This class implements the method found in interface and sets trainer card name
 */
package PokemonCardGame;

public class Trainer extends Card implements TrainerAction{
	/**
	 * Variable string that holds the name of trainer card
	 */
	private String name;
	/**
	 * Gets inputed name and sets it equal to variable
	 * @param cardName - inputed name of trainer card 
	 */
	public void setName(String cardName) {
		name = cardName;
	}
	/**
	 * gets the name of trainer card
	 * @return name - returns name of trainer
	 */
	public String getName() {
		return name;
	}
	/**
	 * method from trainerAction to be used by trainers and in player method
	 * @param gameState - this is getting the class of Player where this method will be called so that we are also able to use methods from that class
	 */
	public void playable(Player gameState) {
			return;
	}
}
