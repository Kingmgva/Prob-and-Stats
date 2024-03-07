/**
 * Tester class that runs the pokemon Monte Carlo and Charizard Monte Carlo
 * 
 * @Author Melvin Vazquez
 */
package MonteCarlo;

import org.junit.Test;

public class TestMonteCarlo {

	/**
	 * @test runs the monte carlo simulation of the charizard and pokemon deck 
	 */
	public static void main(String[]args) {
		MonteCarlo test = new MonteCarlo();
		test.runPokemonMonteCarlo();
		test.runCharizardMonteCarlo();
	}

}
