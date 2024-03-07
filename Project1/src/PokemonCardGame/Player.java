package PokemonCardGame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player{
	private String playerName;
	private ArrayList<Card> deck; 
	private ArrayList<Card> hand;
	private ArrayList<Card> prizePool;
	private ArrayList<Card> discard; 
	private ArrayList<Card> bench;
	private ArrayList<Card> active;
	Scanner input = new Scanner(System.in);
	
	public Player(){
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		prizePool = new ArrayList<Card>();
		discard = new ArrayList<Card>();
		bench = new ArrayList<Card>();
		active = new ArrayList<Card>();
	}
	public void setName(String name) {
		playerName = name;
	}
	public String getName() {
		return playerName;
	}
	public void constructDeck1(){
		for(int i = 0; i < 10; i++ ) {
			deck.add(new Squirtle());
		}
		for(int i = 0; i < 10; i++ ) {
			deck.add(new Bulbasaur());
		}
		for(int j = 0; j < 10; j++ ){
			deck.add(new Water());
		}
		for(int j = 0; j < 10; j++ ){
			deck.add(new Grass());
		}
		for(int k = 0; k < 7; k++) {
			deck.add(new NestBall());
		}
		for(int k = 0; k < 7; k++) {
			deck.add(new ProfessorsResearch());
		}
		for(int k = 0; k < 6; k++) {
			deck.add(new MistyDetermination());
		}
	}
	public void constructDeck2(){
		for(int i = 0; i < 10; i++ ) {
			deck.add(new Charmander());
		}
		for(int i = 0; i < 10; i++ ) {
			deck.add(new Pikachu());
		}
		for(int j = 0; j < 10; j++ ){
			deck.add(new Fire());
		}
		for(int j = 0; j < 10; j++ ){
			deck.add(new Lightning());
		}
		for(int k = 0; k < 7; k++) {
			deck.add(new NestBall());
		}
		for(int k = 0; k < 7; k++) {
			deck.add(new ProfessorsResearch());
		}
		for(int k = 0; k < 6; k++) {
			deck.add(new MistyDetermination());
		}
	}
	
	public Card drawCard() {
		Random rng = new Random();
		int cardIndex = rng.nextInt(deck.size()); // Find Random card
		Card drawnCard = deck.get(cardIndex);
		deck.remove(cardIndex);
		return drawnCard;
	}
	public void drawHand() {
		for (int i = 0; i < 7; i++) {// We're counting to 7
			hand.add(drawCard());
		}
	}
	public void reshuffle(){
		for(int i = 0; i<7; i++) {
			deck.add(hand.get(i));
		}
		hand.clear();
		drawHand();
	}
	public void drawExtraCard() {
		hand.add(drawCard());
	}
	public void prize() {
		for (int i=0; i<6; i++) {
			prizePool.add(drawCard());
		}
	}
	public void drawPrizeCard() {
		Random rng = new Random();
		int cardIndex = rng.nextInt(prizePool.size()); // Find Random card
		Card drawnCard = prizePool.get(cardIndex);
		prizePool.remove(cardIndex);
		hand.add(drawnCard);
	}
	
	
	
	public boolean evaluateOpeningHand(){
		boolean havePokemon = false;
		for (int i = 0; i < hand.size(); i++) {
			Card currentCard = hand.get(i);
			if (currentCard instanceof Pokemon) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public void startOfGame() {
		System.out.printf("Hand: '%s'\nDeck: '%d'\nPrize cards: '%d'\nActive Pokemon: '%s'\nBench:  '%s'", printHand(), printDeck(), prizePool.size(), printActive(), printBench());
	}
	public ArrayList<String> printHand() {
		ArrayList<String> handNames = new ArrayList<String>();
		for(int i=0; i < hand.size(); i++){
			handNames.add(hand.get(i).getName());	
		}
		return handNames;
	}
	public ArrayList<String> printActive() {
		ArrayList<String> activePoke = new ArrayList<String>();
		activePoke.add(active.get(0).getName());	
		return activePoke;
	} 
	public int printDeck(){
		return deck.size();
	}
	public ArrayList<String> printBench(){
		ArrayList<String> benchNames = new ArrayList<String>();
		for(int i=0; i < bench.size(); i++){
			benchNames.add(bench.get(i).getName());	
		}
		return benchNames;
	}
	
	
	public ArrayList<Card> getDeck(){
		return deck;
	}
	public ArrayList<Card> getBench(){
		return bench;
	}
	public ArrayList<Card> getHand(){
		return hand;
	}
	public ArrayList<Card> getDiscard(){
		return discard;
	}
	public ArrayList<Card> getPrizePool(){
		return prizePool;
	}
	public ArrayList<Card> getActive(){
		return active;
	}
	
	
	
	
	
	
	
	public int getPrize() {
		return prizePool.size();
	}
	public int player1SetUp() {
		int count =0;
		constructDeck1();
		drawHand();
		while(!evaluateOpeningHand()){
			reshuffle();
			count++;
		}
		return count;
	}
	public int player2SetUp() {
		int count =0;
		constructDeck2();
		drawHand();
		while(!evaluateOpeningHand()){
			reshuffle();
			count++;
		}
		return count;
	}
	public void attack(Player target) {
		String attackInput;
		System.out.println("Would you like to attack? (yes or no)");
		attackInput = input.next();
		switch(attackInput) {
		case "yes":
			int userNumAttack;
			Pokemon attacker = (Pokemon) active.get(0);
			Pokemon opponent = (Pokemon) target.active.get(0);
			
			System.out.println("Pick an attack through the number:\n 1: " + attacker.getAttack1() +"\n 2: " + attacker.getAttack2() + "\n 3: No attack");
			userNumAttack = input.nextInt();
			switch(userNumAttack) {
			case 1:
				if(attacker.attackOne(opponent) == true) {
					System.out.println(attacker.getName() + " has used " + attacker.getAttack1() + " to attack " + opponent.getName());
					System.out.println(target.getName() + "'s " +  opponent.getName() +" was attacked and now has " + opponent.getHp() + " hp");
					checkActiveField(target);
				}
				break;
			case 2:
				if(attacker.attackTwo(opponent) == true) {
					System.out.println(attacker.getName() + " has used " + attacker.getAttack2() + " to attack " + opponent.getName());
					System.out.println(target.getName() + "'s " +  opponent.getName() + " pokemon was attacked and now has " + opponent.getHp() + " hp");
					checkActiveField(target);
				}
				break;
			case 3:
				System.out.println("No attack");
				break;
			default:
				System.out.println("Invalid Input");
				userNumAttack = input.nextInt();
			}
			break;
		case "no":
			System.out.println("Okay, your turn ends here");
			break;
		}
	}
	public void checkActiveField(Player target) {
		Pokemon opponent = (Pokemon) target.active.get(0);
		if(opponent.getHp()<=0) {
			this.drawPrizeCard();
			target.discardField(opponent);
		}
		if(target.bench.size()>0){
			target.addToActive();
		}	
	}
	public void discardField(Pokemon target){
		active.remove(target);
	}
	public void addToActive(){
		int userPick;
		Card currentCard = new Card();
		Pokemon chosenPoke = new Pokemon();
		System.out.println(this.getName() + ": Add an active from your bench:\n " + printBench());
		userPick = input.nextInt();
		currentCard = bench.get(userPick-1);
		if(currentCard instanceof Pokemon) {
			chosenPoke = (Pokemon) currentCard;
			active.add(chosenPoke);
			bench.remove(userPick-1);
		}
		else {
			System.out.println("No pokemon was selected, please select a Pokemon: ");
			userPick = input.nextInt();
		}
		
		
		
	}
	public void activeField(Pokemon chosen) {
		active.add(chosen);
		hand.remove(chosen);
	}
	public void benchField(Pokemon chosen) {
		bench.add(chosen);
		hand.remove(chosen);
	}
	public void setActive() {
		System.out.println("Pick a pokemon to put as your active: " + printHand());
	}
	public void addBench() {
		int userInput;
		int addedPoke = 0;
		Card currentCard = new Card();
		for(int i=0; i<hand.size();i++) {
			currentCard = hand.get(i);
			if(currentCard instanceof Pokemon) {
				System.out.println("Select which pokemon to add: " + printHand());
				userInput = input.nextInt();
				currentCard = hand.get(userInput -1);
				Pokemon chosenPokemon = (Pokemon)currentCard;
				benchField(chosenPokemon);
				addedPoke++;
				i = hand.size();
			}
		}
		if(addedPoke ==0) {
			System.out.println("Don't have any pokemon in hand to add to bench");
		}
	}
	public void attachEnergy() {
		int userInput;
		boolean hasEnergy = false;
		Card currentCard = new Card();
		int attachedEnergy = 0;
		Pokemon activePoke = (Pokemon) active.get(0);
		for(int i=0; i<hand.size(); i++) {
			currentCard = hand.get(i);
			if(currentCard instanceof Energy) {
				hasEnergy = true;
			}
		}
		while(hasEnergy == true) {
			System.out.println("Which energy card would you like to attach to " + active.get(0).getName() +"? Input number of energy location: (Pikachu = Lightning, Squirtle = Water, Charmander = Fire, Bulbasaur = Grass)\n" + printHand());
			userInput = input.nextInt();
			currentCard = hand.get(userInput-1);
			if(userInput > hand.size()) {
				System.out.println("invalid input, pick another card: \n");
			}
			else if (currentCard instanceof Energy) {
				hand.remove(userInput-1);
				Energy chosenEnergy = (Energy)currentCard;
				activePoke.attachEnergy(chosenEnergy.getName());
				attachedEnergy++;
				hasEnergy = false;
			}
			else {
				System.out.println("Not an energy card");
			}
		}
		if(attachedEnergy == 0) {
			System.out.println("No energy card to attach to Pokemon");
		}
	}
	public void retreat() {
		String userInput;
		int userPick;
		boolean wantRetreat = false;
		Card currentCard = new Card();
		Pokemon chosenPoke = new Pokemon();
		if(bench.size()>0 && bench.size()<5) {
			System.out.println("Are you sure you want to retreat your pokemon? (yes or no)");
			userInput = input.next();
			if(userInput.equals("yes")) {
				wantRetreat = true;
				while(wantRetreat) {
					System.out.println("pick a card to put as active pokemon: "+ printBench());
					bench.add(active.get(0));
					userPick = input.nextInt();
					currentCard = bench.get(userPick -1);
					if(currentCard instanceof Pokemon) {
						chosenPoke = (Pokemon) currentCard;
						active.add(chosenPoke);
						bench.remove(userPick-1);
						wantRetreat = false;
					}
					else {
						System.out.println("invalid input");
					}
				}
			}
			else {
				System.out.println("Understood, we go back to your options.");
			}
		}
		else {
			System.out.println("Can't retreat since your bench is full or has no pokemon");
		}
	}
	/**
	 * 
	 */
	public void playTrainer(){
		Trainer currentTrainer = new Trainer();
		Card currentCard = new Card();
		int userPick;
		int trainersPlayed = 0;
		for(int i = 0; i<hand.size(); i++) {
			currentCard = hand.get(i);
			if(currentCard instanceof Trainer) {
				System.out.println("Which trainer would you like to play:\n " + printHand());
				userPick = input.nextInt();
				currentCard = hand.get(userPick-1);
				discard.add(hand.get(userPick-1));
				hand.remove(userPick-1);
				if(currentCard instanceof Trainer) {
					currentTrainer = (Trainer) currentCard;
					currentTrainer.playable(this);
					System.out.println(printHand());
					i = hand.size();
					trainersPlayed++;
				}
				else {
					System.out.println("not a trainer card, pick a trainer card");
					userPick = input.nextInt();
				}
			}
		}
		if(trainersPlayed == 0) {
			System.out.println("no trainer cards in hand");
		}
	}
	public boolean checkWinner(Player target){
		boolean winner = false;
		if(prizePool.size() == 0) {
			System.out.println(this.getName() + " has won the game");
			return winner = true;
		}
		else if(target.active.size() == 0 && target.bench.size()==0) {
			System.out.println(this.getName() + " has won the game");
			return winner = true;
		}
		else if(target.deck.size()==0) {
			System.out.println(this.getName() + " has won the game");
			return winner = true;
		}
		else {
			System.out.println("No winner yet, next player turn\n");
			return winner;
		}
	}
	
	
	
	
	
	
	
	public void setBoard() {
		int chosenPoke;
		String userInput;
		boolean hasPokemon = false;
		Card currentCard = new Card();
		prize();
		while(active.size() == 0) {
			System.out.println(this.getName() + ": What pokemon from your hand do you want to put as your active? (Please input the number location of the pokemon. Ex:hand = [Charizard, Pikachu, Bulbasaur] want to choose pikachu, which is at location 2. \n\n" + printHand());
			chosenPoke = input.nextInt();
			currentCard = hand.get(chosenPoke - 1);
			if (currentCard instanceof Pokemon) {
				Pokemon chosenPokemon = (Pokemon)currentCard;
				activeField(chosenPokemon);
			}
			else {
				System.out.println("Invalid choice, choose a pokemon to put on active field, (Use corresponding number please)");
			}
		}		
		for (int i = 0; i < hand.size(); i++) {
			currentCard = hand.get(i);
			if (currentCard instanceof Pokemon) {
				hasPokemon = true;
			}
		}
		while(hasPokemon) {
			System.out.println("Would you like to add a pokemon to bench? (yes or no)");
			userInput = input.next();
			if(userInput.equals("yes")) {
				System.out.println("Which Pokemon would you like to add to bench: " + printHand()); 
				chosenPoke = input.nextInt();
				currentCard = hand.get(chosenPoke-1);
				if(currentCard instanceof Pokemon) {
					Pokemon chosenPokemon = (Pokemon)currentCard;
					benchField(chosenPokemon);
					hasPokemon = false;
				}
				else {
					System.out.println("Invalid input, not a pokemon");
				}
			}
			else if(userInput.equals("no")) {
				System.out.println("No problem, you can add to bench later");
				hasPokemon = false;
			}
			else {
				System.out.println("Invalid Input");

			}
		}
		System.out.println("Your board is fully set up");
	}
	public void playerTurn(Player opponent){
		int userInput;
		boolean turnOver = false;
		hand.add(drawCard());
		while(turnOver == false){
			System.out.println(this.getName() + "\nYour hand: " + printHand() + "\n" + "Your active: " + active.get(0).getName() + "\n" + "your bench: " + printBench() + "\nDeck: " + deck.size() + "\nPrize cards: " + prizePool.size());
			System.out.println("\nBefore you attack, you can:\n 1:Attach energy to pokemon \n 2:Add to bench \n 3.play trainer card \n 4:retreat active pokemon \n 5:Go to attack");
			userInput = input.nextInt();
			switch(userInput){
				case 1:
					attachEnergy();
					break;
				case 2:
					addBench();
					break;
				case 3:
					playTrainer();
					break;
				case 4:
					retreat();
					break;
				case 5:
					attack(opponent);
					turnOver = true;
					break;
				default:
					System.out.println("Invalid choice");
			}
		}
	}
}
