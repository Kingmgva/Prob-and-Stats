package PokemonCardGame;
public class Bulbasaur extends Pokemon implements Attackable{
	private boolean attackSuccess = false;
	public Bulbasaur() {
		setHp(70);
		setName("Bulbasaur");
		pokemonType("Grass");
		setAttack1("Leech Seed");
		setAttack2("Razor Leaf");
	}
	@Override
	public boolean attackOne(Pokemon target) {
		if(this.matchingEnergy >= 2) {
			int currentHp = target.getHp();
			int resultingHp = currentHp - 20;
			int thisCurrentHp = this.getHp();
			if(thisCurrentHp == 70){
				System.out.println("Pokemone at max hp already");
			}
			else {
				int lifeGiven = 70 - thisCurrentHp;
				this.setHp(thisCurrentHp + lifeGiven);
			}
			target.setHp(resultingHp);
			return attackSuccess = true;
		}
		else {
			System.out.println("Can't attack since you don't have energy required, need 2 grass energy type");
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
			System.out.println("Can't attack since you don't have energy required, need 1 grass energy type and any other energy type. You have attached: " + this.attachEnergy + " energy types of which " + this.matchingEnergy + " are the same energy type");
			return attackSuccess = false;
		}
		
	}
}
