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
		int pokeAdded=0;
		int i = 0;
		while (i < deck.size()) {
			if (deck.get(i) instanceof Pokemon && bench.size() < 5) {
				bench.add(deck.get(i));
				deck.remove(i);
				pokeAdded++;
				i = deck.size();
			} 
			else {
				i++;
			}
		}
		if(pokeAdded == 0) {
			System.out.println("no pokemon found or bench is full");
		}
	}
}
