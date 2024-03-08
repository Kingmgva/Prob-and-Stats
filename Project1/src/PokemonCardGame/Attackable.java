/**
 * This class is the interface for pokemon to create the attack methods and be able to call it without coding attack repeatedly.
 * @author Melvin Vazquez
 *
 */
package PokemonCardGame;
/**
 * This is an interface called Attackable that creates two variables called attackOne and attackTwo
 */
public interface Attackable {
	boolean attackOne(Pokemon target);
	boolean attackTwo(Pokemon target);
}

