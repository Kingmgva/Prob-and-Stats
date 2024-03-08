/**
 * This class is one of the parent classes for the pokemon game because all other classes extend card since this is a pokemon card game
 * @author Melvin Vazquez
 */
package PokemonCardGame;
public class Card{
	/**
	 * initializes a string name that handles each card
	 */
	private String name;
	/**
	 * After name is set it will get the name of card
	 * @return name - returns the name of card 
	 */
	public String getName() {
		return name;
	}
}
