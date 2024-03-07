package PokemonCardGame;
import java.util.Random;
public class Squirtle extends Pokemon implements Attackable{
	private boolean attackSuccess;
	public Squirtle() {
		setHp(50);
		setName("Squirtle");
		pokemonType("Water");
		setAttack1("Tackle");
		setAttack2("Water Gun");
	}
	public boolean attackOne(Pokemon target) {
		if(this.attachEnergy >= 1) {
			int currentHp = target.getHp();
			int resultingHp = currentHp - 10;
			target.setHp(resultingHp);
			return attackSuccess = true;
		}
		else {
			System.out.println("can't attack since you don't have the energy requirement, need 1 water energy");
			return attackSuccess = false;
		}
	}
	@Override
	public boolean attackTwo(Pokemon target) {
		if(this.matchingEnergy >= 1 && this.attachEnergy >= 2) {
			int currentHp = target.getHp();
			int resultingHp = currentHp - 20;
			target.setHp(resultingHp);
			return attackSuccess = true;
		}
		else {
			System.out.println("can't attack since you don't have the energy requirement, need 1 water energy and any other energy type. You have attached: " + this.attachEnergy + " energy types of which " + this.matchingEnergy + " are the same energy type");
			return attackSuccess = false;
		}
	}

}
