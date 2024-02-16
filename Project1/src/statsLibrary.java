import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//Lets start off with a warmup :: Lets write a program that can find mean, median, and mode.
//After that write a tester class to try it out
public class statsLibrary {
	public statsLibrary() {

	}

	public statsLibrary(int[] userInput) {

	}
	// Something that's common in all stats classes that you take, is learning about
	// central tendencies

	// Mean, Median, and Mode

	// Mean -> Its the sum of elements divided by count. Another word for it could
	// be "Expected"
	public double findMean(int[] userInput) {// 2 options, use an array or array list.
		double sum = 0;
		for (int i = 0; i < userInput.length; i++) {
			sum = userInput[i] + sum;
		}
		double result = sum / userInput.length;
		return result;
	}

	// Median -> Either the middle number if odd, or "average" of the two middlest
	// numbers.
	// The list must be ordered, so order the list before finding median. Should be
	// able to call
	// collections sort or arraylist sort of some kind
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

	// Mode -> Is the number that occurs the most, but it must be unique, no 2 or
	// more modes.

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

	// Measures how close to the mean values tend to be
	// Lower means closer to E. Larger Standard Deviation tells you that your
	// distribution is more spread out and
	// unevenly spread out.
	// write a method to find standardDeviation(someList)
	public double standardDeviation(int[] userInput) {
		ArrayList<Double> data = new ArrayList<Double>();
		double numResult = 0;
		double standardDeviation = 0;
		double meanResult = findMean(userInput);
		for (int i = 0; i < userInput.length; i++) {
			numResult = userInput[i] - meanResult;
			numResult = numResult * numResult;
			data.add(numResult);
		}
		for (int j = 0; j < data.size(); j++) {
			numResult = numResult + data.get(j);
		}
		standardDeviation = numResult / (data.size() - 1);
		standardDeviation = Math.sqrt(standardDeviation);
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
	public double findCombinations(int numOfElements, int subSetSize){
		double combinations;
		combinations = factorial(numOfElements)/(factorial(subSetSize)*(factorial(numOfElements-subSetSize)));
		return combinations;
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
}
