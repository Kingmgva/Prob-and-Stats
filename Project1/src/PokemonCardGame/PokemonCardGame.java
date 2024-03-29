/**
 * This class is used to initialize the two players, print instructions, and start up the pokemon game
 * 
 * @author Melvin Vazquez
 */
package PokemonCardGame;
import java.util.Scanner;
public class PokemonCardGame {
	/**
	 * THe variables for two players and the scanner created for player to use 
	 */
	Player player1 = new Player();
	Player player2 = new Player();
	Scanner input = new Scanner(System.in);
	/**
	 * Gets the method from player class to set the name of both Players
	 */
	public PokemonCardGame(){
		player1.setName("Player1");
		player2.setName("Player2");
	}
	/**
	 * Prints the instructions of the game, how to win, and how to play
	 */
	public void instructions() {
		System.out.println("Would you like to see the instructions on how to play the game?");
		String userInput = input.next();
		boolean run = false;
		while(!run) {
			switch(userInput) {
			case "yes":
			case "Yes":
				System.out.println("This game is set up using a deck of 60 cards mixed with pokemons, trainer, and energy cards. The way the game is set up is like this: \n 1.Both players will have a deck of 60 cards that has a mixture of pokemon, energy, and trainer cards\n 2.At start of game a coin will be flipped to dictate who goes first\n 3.The deck will be shuffled and players will draw 7 cards\n 4.Both players must draw at least one basic pokemon to continue, otherwise you have to show your hand to your opponent, put back the drawn cards in deck and reshuffle until both players get a basic pokemon\n 5.If only one player has to reshuffle then the other player gets to draw a card for every reshuffle\n 6.Once both players have a basic pokemon they will put one basic pokemon of their choosing face down in the active field\n 7.If you have more pokemon in hand you are allowed to put up to 5 basic pokemons face down on the bench\n 8.After both players finish setting up their bench and active fields they will put the top 6 cards of your deck to the side, which will be your prize cards\n 9.Then both players will flip their active and benched pokemon face up to start the game");
				System.out.println("How to win:\n 1.Take all prize cards by knocking out opponents pokemons\n 2.Knock out all of your opponents in-play Pokemon\n 3.If your opponent has no cards in their deck at the beginning of their turn");
				System.out.println("How to play:\n 1.At start of player turn draw a card\n 2.Next thing the player can do is either use abilities, put basic pokemon in bench, attach energy card to pokemon, play trainer card, or retreat active pokemon\n 3.Attack opponent, then end turn");
				run = true;
				break;
			case "No":
			case "no":
			case "NO":
				System.out.println("Understood!");
				run = true;
				break;
			default:
				System.out.println("Please make sure you input the word yes or the word no.");
				userInput = input.next();
			}
		}
	}
	/**
	 * This checks whether the user is ready to start game and if they are it will run the set up game method
	 */
	public void startUp() {
		instructions();
		System.out.println("Are you ready to start game? (yes or no)");
		String userInput = input.next();
		boolean run = true;
		while(run){
			if (userInput.equals("yes")) {
				setUpGame();
				run = false;
			}
			else if(userInput.equals("no")) {
				System.out.println("Okay");
				run = false;
			}
			else {
				System.out.println("invalid input, Are you ready to start? (yes or no)");
				userInput = input.next();
			}
		}
	}
	/**
	 * This sets up the board for each player and then calls the run game method
	 */
	public void setUpGame() {
		int player1ReshuffleCount;
		int player2ReshuffleCount;
		System.out.println("Each player will be set up with a deck that has 20 pokemon, 20 trainer, and 20 energy cards that correspond with the pokemon \n");
		player1ReshuffleCount = player1.player1SetUp();
		player2ReshuffleCount = player2.player2SetUp();
		for(int i =0; i<player1ReshuffleCount-player2ReshuffleCount; i++) {
			player2.drawExtraCard();
		}
		for(int i =0; i<player2ReshuffleCount-player1ReshuffleCount; i++) {
			player1.drawExtraCard();
		}
		player1.setBoard();
		player2.setBoard();
		runGame();
	}
	/**
	 * This runs the game and loops between each player turn until a winner is found 
	 */
	public void runGame() {
		boolean winner = false;
		System.out.println(player1.getName() + " your board consists of: " );
		player1.startOfGame();
		System.out.println("\n\n");
		System.out.println(player2.getName() + " your board consists of: " );
		player2.startOfGame();
		System.out.println("\n\n");
		while(winner == false) {
			player1.playerTurn(player2);
			player1.checkWinner(player2);
			player2.playerTurn(player1);
			player2.checkWinner(player1);
			if(player1.checkWinner(player2) == true || player2.checkWinner(player1) == true) {
				winner = true;
			}
		}

	}
}