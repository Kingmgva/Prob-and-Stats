package PokemonCardGame;
public class Charmander extends Pokemon implements Attackable{
	public Charmander(){
		setHp(50);
	}
	public void attackOne(Pokemon target) {
		String attackNameOne = "Scratch";
		int currentHp = target.getHp();
		int resultingHp = currentHp - 10;
		target.setHp(resultingHp);
	}
	public void attackTwo(Pokemon target) {
		String attackNameTwo = "Ember";
		int currentHp = target.getHp();
		int resultingHp = currentHp - 30;
		target.setHp(resultingHp);
	}

}
