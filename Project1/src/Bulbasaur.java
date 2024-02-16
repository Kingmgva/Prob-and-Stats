
public class Bulbasaur extends Pokemon implements Attackable{
	
	public Bulbasaur() {
		setHp(70);
	}
	public void leechSeed(Pokemon target) {
		int currentHp = target.getHp();
		int resultingHp = currentHp - 20;
		
		//We're missing a line of code to make sure that this pokemon has missing life to heal. can't go over 70
		int thisCurrentHp = this.getHp();
		this.setHp(thisCurrentHp + 20);
		
		target.setHp(resultingHp);
	}
	@Override
	public void attackOne(Pokemon target) {
		String attackNameOne = "leech seed ";
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
		String attackNameTwo = "electro Ball";
		int currentHp = target.getHp();
		int resultingHp = currentHp - 60;
		target.setHp(resultingHp);
		
	}
}
