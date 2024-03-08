/**
 * This class is for one of the pokemon created called Pikachu and it is connected to the pokemon game because it extends pokemon and also implements the interface Attackable. This class uses the methods from attackable to create the pokemons attack
 * @author Melvin Vazquez
 */
package PokemonCardGame;
public class Pikachu extends Pokemon implements Attackable{
	/**
	 * creates a private boolean to check whether the attack was a success or not
	 */
	private boolean attackSuccess = false;
	/**
	 * This method sets the default variables for the pokemon like hp, name, type, and attack names
	 */
	public Pikachu(){
		setHp(70);
		setName("Pikachu");
		pokemonType("Lightning");
		setAttack1("Quick Attack");
		setAttack2("Electro Ball");
	}
	/**
	 * This method is creating what results after attack is used and how the target pokemon loses health because of the attack
	 * @param target - takes in the pokemon being attacked 
	 * @return attackSuccess - this returns whether the attack went through or not depending on whether the pokemon has the required energy attached to it
	 */
	public boolean attackOne(Pokemon target) {
		if(this.attachEnergy >= 1) {
			int currentHp = target.getHp();
			int resultingHp = currentHp - 10;
			target.setHp(resultingHp);
			return attackSuccess = true;
		}
		else {
			System.out.println("Can't attack since you don't have energy required, need 1 of any energy type");
			return attackSuccess = false;
		}
	}
	/**
	 * This method is creating what results after attack is used and how the target pokemon loses health because of the attack
	 * @param target - takes in the pokemon being attacked 
	 * @return attackSuccess - this returns whether the attack went through or not depending on whether the pokemon has the required energy attached to it
	 */
	public boolean attackTwo(Pokemon target) {
		if(this.matchingEnergy >= 1 && this.attachEnergy >= 3) {
			int currentHp = target.getHp();
			int resultingHp = currentHp - 20;
			target.setHp(resultingHp);
			return attackSuccess = true;
		}
		else {
			System.out.println("Can't attack since you don't have energy required, need 1 lightning energy and 2 of any other energy type. You have attached: " + this.attachEnergy + " energy types of which " + this.matchingEnergy + " are the same energy type");
			return attackSuccess = false;
		}
	}
}