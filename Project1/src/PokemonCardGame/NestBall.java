package PokemonCardGame;
import java.util.ArrayList;
import java.util.Random;

public class NestBall extends Trainer implements TrainerAction{
	public NestBall() {
		setName("Nest Ball");
	}
	public void playable(Player gameState){
		//find pokemon
		ArrayList<Card> deck = gameState.getDeck();
		ArrayList<Card> bench = gameState.getBench();
		ArrayList<Card> tempPokemon = new ArrayList<>();
		boolean done = false;
		int i = 0;
		while (i < deck.size()) {
			if (deck.get(i) instanceof Pokemon) {
				tempPokemon.add(deck.get(i));
				deck.remove(i);
			} else {
				i++;
			}
		}
		System.out.println("Pokemon found so far: " + tempPokemon);
		System.out.println("Count: " + tempPokemon.size());

		Random ranPokemon = new Random();
		int saveRanPokemon = ranPokemon.nextInt(tempPokemon.size());
		bench.add(tempPokemon.get(saveRanPokemon));
		tempPokemon.remove(saveRanPokemon);

		for (int j = 0; j < tempPokemon.size(); j++) {
			deck.add(tempPokemon.get(i));
		}
	};
}
