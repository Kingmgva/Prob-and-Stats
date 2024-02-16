
public class Pikachu extends Pokemon implements Attackable{
	
	public Pikachu(){
		setHp(70);
	}
	
	public void quickAttack(Pokemon unfortunatePokemon){
		//deal 10 damage
		int currentHp = unfortunatePokemon.getHp();
		int resultingHp = currentHp - 10;
		unfortunatePokemon.setHp(resultingHp);
	}
	
	public void electroBall(Pokemon unfortunatePokemon){
		//deal 60 damage
		int currentHp = unfortunatePokemon.getHp();
		int resultingHp = currentHp - 10;
		unfortunatePokemon.setHp(resultingHp);
	}
	public void attackOne(Pokemon target) {
		String attackNameOne = "quick attack";
		int currentHp = target.getHp();
		int resultingHp = currentHp - 10;
		target.setHp(resultingHp);
	}
	public void attackTwo(Pokemon target) {
		String attackNameTwo = "electro Ball";
		int currentHp = target.getHp();
		int resultingHp = currentHp - 60;
		target.setHp(resultingHp);
	}
}