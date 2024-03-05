package PokemonCardGame;
import java.util.ArrayList;
import java.util.Random;

public class ProfessorsResearch extends Trainer implements TrainerAction{
	public ProfessorsResearch() {
		setName("Professors Research");
	}
	public void playable(Player gameState)
	{
		ArrayList<Card> deck = gameState.getDeck();
		ArrayList<Card> hand = gameState.getHand();
		deck.addAll(hand);
		hand.clear();
		while(hand.size() < 7){
			Random rng = new Random();
			int cardIndex = rng.nextInt(deck.size());
			Card drawnCard = deck.get(cardIndex);
			deck.remove(cardIndex);
			for (int i = 0; i < 7; i++) {
				hand.add(drawnCard);
			}
		}
	}
}
	
	
	
	
