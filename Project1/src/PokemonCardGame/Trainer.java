package PokemonCardGame;

public class Trainer extends Card implements TrainerAction{
	private String name;
	public void setName(String cardName) {
		name = cardName;
	}
	public String getName() {
		return name;
	}
	public void playable(Player gameState) {
			return;
	}
}
