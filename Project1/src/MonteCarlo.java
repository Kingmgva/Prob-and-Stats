
public class MonteCarlo {
	
	public void constructDeck(int numOfPokemon){
		deck.clear();
		hand.clear();
		pokemonCount = 0;
		for(int i = 0; i < numOfPokemon; i++ ) {
			deck.add(new Pokemon());
			pokemonCount++;
		}
		for(int j = numOfPokemon; j < deckSize; j++ ){
			deck.add(new Energy());
		}
	}
	
	//Make engine for program
	public void run(){
		constructDeck();
		while(evaluateOpeningHand() == false)
		for(int i = 0; i < deckSize; i++){
			trueCount = 0;
			falseCount = 0;
	        for(int j = 0; j < 1000; j++) {
	        	constructDeck(i);
	            drawHand();
	            evaluateOpeningHand();
	        }
			System.out.println("True Count for " + pokemonCount + " pokemon in deck is: " + trueCount +  "\nFalse Count for " + pokemonCount + " pokemon in deck is: " + falseCount );
		}
	}
}
