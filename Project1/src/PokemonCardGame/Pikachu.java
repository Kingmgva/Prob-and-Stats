package PokemonCardGame;
public class Pikachu extends Pokemon implements Attackable{
	private boolean attackSuccess = false;
	public Pikachu(){
		setHp(70);
		setName("Pikachu");
		pokemonType("Lightning");
		setAttack1("Quick Attack");
		setAttack2("Electro Ball");
	}
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