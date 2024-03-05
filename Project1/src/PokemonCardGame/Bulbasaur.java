package PokemonCardGame;
public class Bulbasaur extends Pokemon implements Attackable{
	
	public Bulbasaur() {
		setHp(70);
		setName("Bulbasaur");
		pokemonType("Grass");
		setAttack1("Leech Seed");
		setAttack2("Razor Leaf");
	}
	@Override
	public void attackOne(Pokemon target) {
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
		
	}
	@Override
	public void attackTwo(Pokemon target) {
		int currentHp = target.getHp();
		int resultingHp = currentHp - 20;
		target.setHp(resultingHp);
		
	}
}
