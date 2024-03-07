package PokemonCardGame;
public class Charmander extends Pokemon implements Attackable{
	private boolean attackSuccess;
	public Charmander(){
		setHp(50);
		setName("Charmander");
		pokemonType("Fire");
		setAttack1("Scratch");
		setAttack2("Ember");
	}
	public boolean attackOne(Pokemon target) {
		if(this.attachEnergy >= 1) {
			String attackNameOne = "Scratch";
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
		if(this.attachEnergy >= 2 && this.matchingEnergy >=1) {
			int currentHp = target.getHp();
			int resultingHp = currentHp - 30;
			target.setHp(resultingHp);
			return attackSuccess = true;
		}
		else {
			System.out.println("Can't attack since you don't have energy required, need 1 fire type and one of any other energy type. You have attached: " + this.attachEnergy + " energy types of which " + this.matchingEnergy + " are the same energy type");
			return attackSuccess = false;
		}
	}

}
