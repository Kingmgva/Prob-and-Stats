package PokemonCardGame;
import java.util.ArrayList;
import java.util.Random;

public class ProfessorsResearch extends Trainer implements TrainerAction{
	public ProfessorsResearch() {
		setName("Professors Research");
	}
	public void playable(Player gameState)
	{
		ArrayList<String> newHand = new ArrayList<String>();
		ArrayList<Card> deck = gameState.getDeck();
		ArrayList<Card> hand = gameState.getHand();
		deck.addAll(hand);
		hand.clear();
		while(hand.size() < 7){
			Random rng = new Random();
			int cardIndex = rng.nextInt(deck.size());
			Card drawnCard = deck.get(cardIndex);
			deck.remove(cardIndex);
			hand.add(drawnCard);
		}
		for(int j = 0; j < 7; j++) {
			newHand.add(hand.get(j).getName());
		}
		System.out.println(newHand);
	}
}
	
	
	
	
