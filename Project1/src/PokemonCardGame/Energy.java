/**
 * This class is one of the card types called Energy that sets the energy type and this class extends card
 * @author Melvin Vazquez
 */
package PokemonCardGame;
public class Energy extends Card{
	/**
	 * This is a string variable called type 
	 */
	private String type;
	/**
	 * This sets the energy type of card 
	 * @param energyType
	 */
	public void setType(String energyType ) {
		type = energyType;
	}
	/**
	 * This method is used to get the name of energy card
	 * @return type - returns the energy type of card like Fire, or Water
	 */
	public String getName() {
		return type;
	}
}
