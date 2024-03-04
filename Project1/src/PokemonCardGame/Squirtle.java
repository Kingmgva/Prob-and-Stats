package PokemonCardGame;
import java.util.Random;
public class Squirtle extends Pokemon implements Attackable{
	public Squirtle() {
		setHp(50);
	}
	public void attackOne(Pokemon target) {
		String [] coin = {"head", "tail"};
		String attackNameOne = "Bubble";
		Random rng = new Random();
		String coinResult = coin[rng.nextInt(coin.length)];
		if (coinResult == "head") {
			System.out.println("Coin laned on heads so " + target + " is afflicted with the status ailment paralyze");
		}
		else {
			System.out.println("Coin landed on tails, so " + target + " is not paralyzed");
		}
	}
	@Override
	public void attackTwo(Pokemon target) {
		String attackNameTwo = "Water Gun";
		int currentHp = target.getHp();
		int resultingHp = currentHp - 20;
		target.setHp(resultingHp);
		
	}

}
