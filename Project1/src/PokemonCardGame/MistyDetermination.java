package PokemonCardGame;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class MistyDetermination extends Trainer implements TrainerAction {
	Scanner input = new Scanner(System.in);
	public MistyDetermination() {
		setName("Misty's Determination");
	}
	
	public void playable(Player gameState) {
		Player player = new Player();
		int userPick;
		ArrayList<Card> deck = gameState.getDeck();
		ArrayList<Card> top8Cards = new ArrayList<Card>();
		ArrayList<Card> hand = gameState.getHand();
		ArrayList<Card> discard = gameState.getDiscard();
		
		Card currentCard = new Card();
		System.out.println("Pick a card to get rid of (pick number location): \n" + hand);
		userPick = input.nextInt();
		currentCard = hand.get(userPick -1);
		discard.add(currentCard);
		System.out.println("Now you'll draw the top 8 cards from your deck.\n");
		for(int i = 0; i<8; i++) {
			Random rng = new Random();
			int cardIndex = rng.nextInt(deck.size());
			Card drawnCard = deck.get(cardIndex);
			deck.remove(cardIndex);
			top8Cards.add(drawnCard);
		}
		ArrayList<String> handNames = new ArrayList<String>();
		for(int i=0; i < top8Cards.size(); i++){
			handNames.add(top8Cards.get(i).getName());
		}
		System.out.println("Pick a card to add to your hand (Input a number that matches location of where card is): \n" + handNames);
		userPick = input.nextInt();
		currentCard = top8Cards.get(userPick-1);
		hand.add(currentCard);
		deck.addAll(top8Cards);
		top8Cards.clear();
		player.printHand();
	}
}
