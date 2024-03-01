import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/*
 * This class is built up of methods that implement formulas found in statistics like mean, median, and mode.
 * It also finds probability cases and uses 
 * 
 * @author Melvin Vazquez
 */

public class statsLibrary {
	public statsLibrary() {

	}

	public statsLibrary(int[] userInput) {

	}
	/*
	 * This method finds the mean of an array by adding up all the numbers inside the array and then dividing 
	 * by the length of the array
	 * 
	 * 
	 * @param: userInput, which is the array of numbers the user himself input
	 * @return: result of the sum divided by the length of array
	 */
	public double findMean(int[] userInput) {// 2 options, use an array or array list.
		double sum = 0;
		for (int i = 0; i < userInput.length; i++) {
			sum = userInput[i] + sum;
		}
		double result = sum / userInput.length;
		return result;
	}

	/*
	 * This method finds the median of an array by sorting the array first, and then depending on whether length is 
	 * even or odd, it will take different actions. If odd the length will divide by 2 and use that number to get the
	 * midNum, otherwise it will take the two middle numbers, add them up, and divide by 2 to find the middle number.
	 * 
	 * 
	 * @param: userInput, which is the array of numbers the user himself input
	 * @return: midNum, which is the number found after completing the formula
	 */
	public double findMedian(double[] userInput) {
		Arrays.sort(userInput);
		double midNum = 0;
		if (userInput.length % 2 == 0) {
			midNum = (userInput[userInput.length / 2] + userInput[userInput.length / 2 - 1]) / 2;
			return midNum;
		} else {
			return midNum = userInput[(userInput.length / 2)];
		}
	}

	/*
	 * This method finds the mode of an array by checking each number with each other and finding which number has the
	 * most occurrences inside the array. The number with the most occurrences is returned, otherwise null is returned
	 * 
	 * @param: userInput, which is the array of numbers the user himself input
	 * @return: uniqueNum, the number that has the most occurrences in the array or null if there is no unique number	 * @return: null, if there is no unique number or more than one, it will return null
	 */
	public Integer findMode(int[] userInput) {
		int count = 0;
		int maxCount = 0;
		Integer uniqueNum = 0;
		for (int i = 0; i < userInput.length; i++) {
			count = 0;
			for (int j = i+1; j < userInput.length; j++) {
				if (userInput[i] == userInput[j]) {
					count++;
				}
			}
			if (count > maxCount){
				maxCount = count;
				uniqueNum = userInput[i];
			}
			else if (count == maxCount) {
				uniqueNum = null;
			}
		}
		return uniqueNum;
	}

	/*
	 * This method finds the standard deviation of the array through calling the mean method and using the formula
	 * provided in the stats textbook
	 * 
	 * @param: userInput, which is the array of numbers the user himself input
	 * @return: standardDeviation, which is the number found after completing the formula
	 */

	public double standardDeviation(int[] userInput) {
		//array list to store the data found after completing the first iteration
		ArrayList<Double> data = new ArrayList<Double>();
		//setting variables to find num result, what I will return at the end, and the mean results
		double numResult = 0;
		double standardDeviation = 0;
		double meanResult = findMean(userInput);
		//This for loop goes through the length of the array and it subtracts each integer in array by mean result
		for (int i = 0; i < userInput.length; i++) {
			numResult = userInput[i] - meanResult;
			//after finding the first result, it will square the result, this results in the variance
			numResult = numResult * numResult;
			//First iteration is done and will add the final result to the data list
			data.add(numResult);
		}
		//This for loop adds up all the numbers inside the data array list
		for (int j = 0; j < data.size(); j++) {
			numResult = numResult + data.get(j);
		}
		//This is the final iteration in which the number result will divide by the total indexes of size and sets it
		//equal to standardDeviation
		standardDeviation = numResult / (data.size() - 1);
		//We usestandardDeviation and square root that to find the final answer
		standardDeviation = Math.sqrt(standardDeviation);
		//this line just returns the answer we get, which is the standardDeviation
		return standardDeviation;
	}
	
	/*
	 * Write program to solve combination and permutations
	 * Test your answers against problems and examples from the text
	 * use your solver to solve a problem from the text
	 * 
	 * you'll need a factorial method to simplify the work
	 * when programming the factorial method you should find the "easy" solve breaks at fairly small factorials
	 * Try using BigInteger from the Java API
	 */
	public double factorial(double num){
		double numFact = num;
		for (double i = numFact - 1; i > 0; i--) {
			numFact = numFact*i;
		}
		return numFact;
	}
	public long longFactorial(long num){
		long numFact = num;
		for (long i = numFact - 1; i > 0; i--) {
			numFact = numFact*i;
		}
		return numFact;
	}
	public BigInteger bigFactorial(int num){
		BigInteger numFact = new BigInteger("1");
		numFact = BigInteger.valueOf(num);
		for (int i = numFact.intValue() - 1; i > 0; i--) {
			int numFactNum = numFact.intValue()* i;
			numFact = BigInteger.valueOf(numFactNum);
		}
		return numFact;
	}
	public double findCombinations(int numOfElements, int subSetSize){
		double combinations;
		combinations = factorial(numOfElements)/(factorial(subSetSize)*(factorial(numOfElements-subSetSize)));
		return combinations;
	}
	public long longCombinations(int numOfElements, int subSetSize){
		long combinations;
		combinations = longFactorial(numOfElements)/(longFactorial(subSetSize)*(longFactorial(numOfElements-subSetSize)));
		return combinations;
	}
	public BigInteger bigCombinations(int numOfElements, int subSetSize){
		BigInteger bigCombinations = new BigInteger("1");
		bigCombinations = bigFactorial(numOfElements).divide(((bigFactorial(subSetSize)).multiply((bigFactorial(numOfElements-subSetSize)))));
		return bigCombinations;
	}
	
	
	public long longPermutations(int numOfElements, int subSetSize) {
		long longPermutations;
		longPermutations = longFactorial(numOfElements)/(longFactorial(numOfElements-subSetSize));
		return longPermutations;
	}
	
	
	public BigInteger bigPermutations(int numOfElements, int subSetSize) {
		BigInteger bigPermutations = new BigInteger("1");
		bigPermutations = bigFactorial(numOfElements).divide(bigFactorial(numOfElements-subSetSize));
		return bigPermutations;
	}
	
	
	public double findPermutations(int numOfElements, int subSetSize){
		double permutations;
		permutations = factorial(numOfElements)/factorial(numOfElements - subSetSize);
		return permutations;
	}
	public double conditionalProb(int intersection, int probability){
		
		return 0;
	}

	
	/*
	 * Write a program that handles our probability axioms
	 * Write a method that handles the following:
	 * 	one to handle independent and dependent intersection
	 * 	one to handle exclusive or not exclusive union
	 * 	a set of methods to determine independence and dependency
	 * 	Bayes theorem
	 * 
	 */
	public double getExpectedHGD(int n, int r, int N) {
		return(n*r)/(double)N;
		
	}
	public void testCases() {
		//The multiple lines of code below sets a tester for the class and assigns variables inside arrays
		statsLibrary test = new statsLibrary();
		int[] mySampleNumbers = {1,2,3,4,5,6,7,8,9};
		double[] scrambledNumbers = {5,3,8,2,4,9,7,6};
		int[] uniqueNumber = {3,6,6,5,6,5,0,0,0};
		int[] standardNum = {3,6,8,4,2,4,6,8,5};
		//The multiple lines of code below are to store the results when calling the methods
		double storeResults = test.findMean(mySampleNumbers);
		double medianResults = test.findMedian(scrambledNumbers);
		Integer modeResults = test.findMode(uniqueNumber);
		double standardDeviationResults = test.standardDeviation(standardNum);
		double combinationResult = test.findCombinations(12,2);
		double permutationsResult = test.findPermutations(6,2);
		double factorialResult = test.factorial(6);
		//The multiple lines of code below print out the results for the user to see 
		System.out.println("The average is: " + storeResults + "\nThe median is: " + medianResults + "\nThe mode is: " + modeResults + "\nThe standard Deviation is: " + standardDeviationResults);
		System.out.println("The combination is: " + combinationResult);
		System.out.println("The permutation is: " + permutationsResult);
		System.out.println("The combination is: " + factorialResult);
		
	}
}
