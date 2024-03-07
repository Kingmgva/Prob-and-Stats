/**
 * This class is used to test the stats library class and all the methods used inside.
 * 
 * @author Melvin Vazquez
 */
package StatsLibrary;
import static org.junit.Assert.*;

import org.junit.Test;

public class TeststatsLibrary {
	/**
	 * This method creates the test variable and calls the testCases method that was made inside stats library
	 * @param args
	 */
	public static void main(String[]args) {
		statsLibrary test = new statsLibrary();
		test.testCases();
	}
}

