import static org.junit.Assert.*;

import org.junit.Test;

public class TeststatsLibrary {
	@Test
	public static void main(String[]args) {
		statsLibrary test = new statsLibrary();
		int[] mySampleNumbers = {1,2,3,4,5,6,7,8,9};
		double[] scrambledNumbers = {5,3,8,2,4,9,7,6};
		int[] uniqueNumber = {3,6,6,5,6,5,0,0,0};
		int[] standardNum = {3,6,8,4,2,4,6,8,5};
		double storeResults = test.findMean(mySampleNumbers);
		double medianResults = test.findMedian(scrambledNumbers);
		Integer modeResults = test.findMode(uniqueNumber);
		double standardDeviationResults = test.standardDeviation(standardNum);
		System.out.println("The average is: " + storeResults + "\nThe median is: " + medianResults + "\nThe mode is: " + modeResults + "\nThe standard Deviation is: " + standardDeviationResults);
	}
}

