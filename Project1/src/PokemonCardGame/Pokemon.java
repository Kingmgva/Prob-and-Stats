package PokemonCardGame;

public class Pokemon extends Card{
	
	private int hp;
	private String name;
	private String type;
	private String attack1;
	private String attack2;
	private int attachEnergy;
	private int matchingEnergy;
	
	public String getName() {
		return name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int userInputHp){
		hp = userInputHp;  
	}
	public void setName(String userInputName) {
		name = userInputName;
	}
	public void pokemonType(String pokeType) {
		type = pokeType;
	}
	public void attachEnergy(String energyType) {
		attachEnergy++;
		if(type.equals(energyType)) {
			matchingEnergy++;
		}
	}
	public void attackOne(Pokemon target) {
		
	}
	public void attackTwo(Pokemon target) {
		
	}
	public void setAttack1(String name){
		attack1 = name;
	}
	public void setAttack2(String name){
		attack2 = name;
	}
	public String getAttack1() {
		return attack1;
	}
	public String getAttack2() {
		return attack2;
	}

}
