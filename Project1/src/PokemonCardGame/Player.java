/**
 * This class is what makes the game run and play how it is, It creates the board for both players, controls players actions, and has methods for each action player wants to take.
 */
package PokemonCardGame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player{
	/**
	 * Creates variables that will be used throughout the program by user and will store cards, and creates a scanner for player to have input
	 */
	private String playerName;
	private ArrayList<Card> deck; 
	private ArrayList<Card> hand;
	private ArrayList<Card> prizePool;
	private ArrayList<Card> discard; 
	private ArrayList<Card> bench;
	private ArrayList<Card> active;
	Scanner input = new Scanner(System.in);
	/**
	 * This method initializes all the variables and makes them arrayList of class Card
	 */
	public Player(){
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		prizePool = new ArrayList<Card>();
		discard = new ArrayList<Card>();
		bench = new ArrayList<Card>();
		active = new ArrayList<Card>();
	}
	/**
	 * This takes input and sets the name for player
	 * @param name = player name
	 */
	public void setName(String name) {
		playerName = name;
	}
	/**
	 * Method gets the name of player
	 * @return playerName - returns player name
	 */
	public String getName() {
		return playerName;
	}
	/**
	 * Constructs the deck for player 1 that has 2 pokemons, 2 energy types that correspond with both, and the three trainer cards that were made. 60 cards in total
	 */
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
	/**
	 * Constructs the deck for player 1 that has 2 pokemons, 2 energy types that correspond with both, and the three trainer cards that were made. 60 cards in total
	 */
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
	/**
	 * This method uses random generator to draw one random card from the deck of 60 cards
	 * @return drawnCarc - the card that was drawn from deck
	 */
	public Card drawCard() {
		Random rng = new Random();
		int cardIndex = rng.nextInt(deck.size()); // Find Random card
		Card drawnCard = deck.get(cardIndex);
		deck.remove(cardIndex);
		return drawnCard;
	}
	/**
	 * This method draws 7 cards and adds to hand
	 */
	public void drawHand() {
		for (int i = 0; i < 7; i++) {
			hand.add(drawCard());
		}
	}
	/**
	 * This method puts back all the cards in hand back to deck and reshuffles and draws hand again because no pokemon was in starting hand
	 */
	public void reshuffle(){
		for(int i = 0; i<7; i++) {
			deck.add(hand.get(i));
		}
		hand.clear();
		drawHand();
	}
	/**
	 * For every reshuffle by player a card will be drawn by opponent 
	 */
	public void drawExtraCard() {
		hand.add(drawCard());
	}
	/**
	 * Sets the top 6 cards to the prizepool after board is set up
	 */
	public void prize() {
		for (int i=0; i<6; i++) {
			prizePool.add(drawCard());
		}
	}
	/**
	 * This method draws a prize card to hand after a pokemon is knocked out by player
	 */
	public void drawPrizeCard() {
		Random rng = new Random();
		int cardIndex = rng.nextInt(prizePool.size());
		Card drawnCard = prizePool.get(cardIndex);
		prizePool.remove(cardIndex);
		hand.add(drawnCard);
	}
	/**
	 * This method checks opening hand to see if a pokemon is found
	 * @return true/false - depending if pokemon in opening hand
	 */
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
	/**
	 * This method prints out the players full board after it is fully set up, so hand, deck, prizepool, active, and bench
	 */
	public void startOfGame() {
		System.out.printf("Hand: '%s'\nDeck: '%d'\nPrize cards: '%d'\nActive Pokemon: '%s'\nBench:  '%s'", printHand(), printDeck(), prizePool.size(), printActive(), printBench());
	}
	/**
	 * This arrayList prints the hand with names that make sense for the reader to understand what card it is and not pokemongame.water
	 * @return handNames - the names of each card in hand
	 */
	public ArrayList<String> printHand() {
		ArrayList<String> handNames = new ArrayList<String>();
		for(int i=0; i < hand.size(); i++){
			handNames.add(hand.get(i).getName());	
		}
		return handNames;
	}
	/**
	 * This arrayList prints the active pokemons name for the user to see
	 * @return activePoke - the name of the active pokemon
	 */
	public ArrayList<String> printActive() {
		ArrayList<String> activePoke = new ArrayList<String>();
		activePoke.add(active.get(0).getName());	
		return activePoke;
	} 
	/**
	 * Gets the size of deck
	 * @return the size of deck
	 */
	public int printDeck(){
		return deck.size();
	}
	/**
	 * This arrayList prints the bench with names that make sense for the reader to understand what card it is and not pokemongame.water
	 * @return benchNames - the names of each card in bench
	 */
	public ArrayList<String> printBench(){
		ArrayList<String> benchNames = new ArrayList<String>();
		for(int i=0; i < bench.size(); i++){
			benchNames.add(bench.get(i).getName());	
		}
		return benchNames;
	}
	
	/**
	 * gets the deck
	 * @return deck - the arraylist of values in deck
	 */
	public ArrayList<Card> getDeck(){
		return deck;
	}
	/**
	 * gets the bench
	 * @return bench - the arraylist of values in bench
	 */
	public ArrayList<Card> getBench(){
		return bench;
	}
	/**
	 * gets the hand
	 * @return deck - the arraylist of values in hand
	 */
	public ArrayList<Card> getHand(){
		return hand;
	}
	/**
	 * gets the discard
	 * @return discard - the arraylist of values in discard
	 */
	public ArrayList<Card> getDiscard(){
		return discard;
	}
	/**
	 * gets the prizePool
	 * @return prizePool - the arraylist of values in prizePool
	 */
	public ArrayList<Card> getPrizePool(){
		return prizePool;
	}
	/**
	 * gets the active
	 * @return active - the arraylist of values in active
	 */
	public ArrayList<Card> getActive(){
		return active;
	}
	/**
	 * gets the prizePool size
	 * @return the size of current prizePool arrayList
	 */
	public int getPrize() {
		return prizePool.size();
	}
	/**
	 * This method is setting up player1 with deck, and hand and checking whether a pokemon is present or not 
	 * @return count - the amount of times the player had to reshuffle
	 */
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
	/**
	 * This method is setting up player2 with deck, and hand and checking whether a pokemon is present or not 
	 * @return count - the amount of times the player had to reshuffle
	 */
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
	/**
	 * This method is getting the active pokemon and attacking the opponents active pokemon. This uses a while loop to make sure correct input is inserted and will end turn after attack is over and go to the next players turn. This method uses the attackOne and attackTwo methods from active pokemon class and these attacks will only go through as long as the required energy is attached. After attack the field is gonna be checked and winner will be checked before moving to next player turn.
	 * @param target - opponent being attacked
	 */
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
	/**
	 * This method checks the active pokemon after it was attacked and checks whether its hp is 0 or not. If it is then it is discarded, the player who attacked gets to draw a prize card, and opponent has to add a pokemon to active through the method called.
	 * @param target - opponent of current player turn
	 */
	public void checkActiveField(Player target) {
		Pokemon opponent = (Pokemon) target.active.get(0);
		if(opponent.getHp()<=0) {
			this.drawPrizeCard();
			target.discardField(opponent);
			if(target.bench.size()>0){
				target.addToActive();
			}	
		}
	}
	/**
	 * This method removes the knocked out pokemon from the active field and adds to the discard pile
	 * @param target - pokemon that was knocked out
	 */
	public void discardField(Pokemon target){
		discard.add(target);
		active.remove(target);
	}
	/**
	 * This method is called after a pokemon is knocked out, this will ask the player whose pokemon was knocked out to add a pokemon from his bench to the active field.
	 */
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
	/**
	 * This method adds the selected pokemon to your active field
	 * @param chosen - pokemon chosen from hand
	 */
	public void activeField(Pokemon chosen) {
		active.add(chosen);
		hand.remove(chosen);
	}
	/**
	 * This method adds the pokemon to the bench
	 * @param chosen - pokemon chosen from hand
	 */
	public void benchField(Pokemon chosen) {
		bench.add(chosen);
		hand.remove(chosen);
	}
	/**
	 * This method adds to the bench by checking if pokemon is in hand and if so the user will be prompted to pick which he would like to add.
	 */
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
	/**
	 * This method is called from switch case in player turn and it attaches an energy card to the current active pokemon of player. It will call the attach energy method and if the energy being attached is the same type as pokemon it will add one to matching energy otherwise it will add one to attached energy no matter the energy type. This method does check if user has energy card in hand and if not then it will not work and will print a statement letting the player know. Uses a while loop to keep going until a correct energy card is picked and added.
	 */
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
	/**
	 * This method retreats the active pokemon back to the bench as long as it is not full and has at least one pokemon. if not then this code will not run and will print out a statement letting user know that the bench is full or has no pokemon. Otherwise it will retreat to bench and ask the user which pokemon he wants to put as active
	 */
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
					active.remove(0);
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
	 * This method is called from the switch case in player turn and will play a trainer card if player has one in hand and calles the playable method from trainer action
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
	/**
	 * This method checks the winner of the game by checking the players prize pool, the opponents deck size, and opponents bench and active. If any of the three conditions are true then the player wins.
	 * @param target - the opponent of current players turn
	 * @return winner - if a winner is found it will return true otherwise false
	 */
	public boolean checkWinner(Player target){
		boolean winner = false;
		if(prizePool.size() == 0) {
			System.out.println(this.getName() + " has won the game by collecting all prize cards");
			return winner = true;
		}
		else if(target.active.size() == 0 && target.bench.size()==0) {
			System.out.println(this.getName() + " has won the game because " + target.getName() + " has no pokemons on bench");
			return winner = true;
		}
		else if(target.deck.size()==0) {
			System.out.println(this.getName() + " has won the game since opponent ran out of cards");
			return winner = true;
		}
		else {
			System.out.println("No winner yet, next player turn\n");
			return winner;
		}
	}
	/**
	 * This method sets the players board by getting user input of what pokemon they want to put as active, and then it checks hand for pokemon to see if they have one and if not then the board is set up, otherwise it will ask if they want to add pokemon to bench and if so which one. After both boards are set up, Each players turn will start.
	 */
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
	/**
	 * This method controls the players turn, where the person is able to do what he wants until he attacks. This method will print hand, deck, bench, deck size, and prize pool size. Uses a while loop to keep the switch case going until attack is called.
	 * @param opponent - person that the player is going against
	 */
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
