package PokemonCardGame;
public class Pikachu extends Pokemon implements Attackable{
	
	public Pikachu(){
		setHp(70);
		setName("Pikachu");
		pokemonType("Lightning");
		setAttack1("Quick Attack");
		setAttack2("Electro Ball");
	}
	public void attackOne(Pokemon target) {
		int currentHp = target.getHp();
		int resultingHp = currentHp - 10;
		target.setHp(resultingHp);
	}
	public void attackTwo(Pokemon target) {
		int currentHp = target.getHp();
		int resultingHp = currentHp - 60;
		target.setHp(resultingHp);
	}
}