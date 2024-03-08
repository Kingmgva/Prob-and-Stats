/**
 * This class is one of the card types called Pokemon that extends card and this class creates the methods that set the name, attack, and energy required for each pokemon
 * 
 * @author Melvin Vazquez
 */
package PokemonCardGame;

public class Pokemon extends Card{
	/**
	 * These are all the variables that will be used to store all the information for each pokemon created and used in the program: hp, name, type, attack1, attack2, attachEnergy, and matchingEnergy
	 */
	private int hp;
	private String name;
	private String type;
	private String attack1;
	private String attack2;
	protected int attachEnergy;
	protected int matchingEnergy;
	/**
	 * This method gets the name of Pokemon
	 * @return name - returns pokemon name
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method gets the hp of pokemon
	 * @return hp - returns the pokemons hp
	 */
	public int getHp() {
		return hp;
	}
	/**
	 * This method sets the hp of Pokemon from inputed hp
	 * @param userInputHp - the inputed health of pokemon
	 */
	public void setHp(int userInputHp){
		hp = userInputHp;  
	}
	/**
	 * This method takes input and uses that input to set pokemon name
	 * @param userInputName - inputed name of pokemon
	 */
	public void setName(String userInputName) {
		name = userInputName;
	}
	/**
	 * This method uses input to set the energy type of pokemon
	 * @param pokeType - uses input to set the pokemon type
	 */
	public void pokemonType(String pokeType) {
		type = pokeType;
	}
	/**
	 * This method checks the the energy type with pokemon type and if it is the same it will add one to matching energy, otherwise it will just add one to attached energy
	 * @param energyType - the energy type that will be attached to pokemon
	 */
	public void attachEnergy(String energyType) {
		attachEnergy++;
		if(type.equals(energyType)) {
			matchingEnergy++;
		}
	}
	/**
	 * This method is created for pokemon to put attack inside method and so it will be able to be called in other classes
	 * @param target - pokemon that is to be attacked
	 * @return false - sets the attack to false for now until method is called and will change depending on the conditions 
	 */
	public boolean attackOne(Pokemon target) {
		return false;
	}
	/**
	 * This method is created for pokemon to put attack inside method and so it will be able to be called in other classes
	 * @param target - pokemon that is to be attacked
	 * @return false - sets the attack to false for now until method is called and will change depending on the conditions 
	 */
	public boolean attackTwo(Pokemon target) {
		return false;
	}
	/**
	 * This method is used to get the name of pokemon attack and set it equal to attack
	 * @param name - input name of pokemon attack
	 */
	public void setAttack1(String name){
		attack1 = name;
	}
	/**
	 * This method is used to get the name of pokemon attack and set it equal to attack
	 * @param name - input name of pokemon attack
	 */
	public void setAttack2(String name){
		attack2 = name;
	}
	/**
	 * This method is used to return the name of attack1
	 * @return attack1 - returns name of first attack
	 */
	public String getAttack1() {
		return attack1;
	}
	/**
	 * This method is used to return the name of attack2
	 * @return attack1 - returns name of second attack
	 */
	public String getAttack2() {
		return attack2;
	}
	/**
	 * This method returns the counter that gets the amount of matching energy attached to pokemon
	 * @return matchingEnergy - returns the number of matching energy 
	 */
	public int getMatchingEnergy() {
		return matchingEnergy;
	}
	/**
	 * This method returns the counter that gets the total amount of attached energy to pokemon
	 * @return matchingEnergy - returns the number of attached energy to pokemon
	 */
	public int getAttachedEnergy() {
		return matchingEnergy;
	}

}
