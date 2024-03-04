package PokemonCardGame;

public class TestPikachu {

	public static void main(String[] args) {
		Pikachu pikaMain = new Pikachu();
		Pikachu pikaTarget = new Pikachu();
		Bulbasaur newBulb = new Bulbasaur();
		
		System.out.println("Bulbasaur USE leechseed!");
		newBulb.leechSeed(pikaMain);
		System.out.println("Pika Main Hp: " + pikaTarget.getHp() + " Bulbasaur Hp: " + newBulb.getHp());
		
		while(pikaTarget.getHp() > 0) {
			System.out.println("Pikachu USE QUICK ATTACK!");
			pikaMain.quickAttack(pikaTarget);
			System.out.println("Pika Target Hp: " + pikaTarget.getHp());
		}
		
	}

}
