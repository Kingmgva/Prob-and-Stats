import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/*
 * This class is built up of methods that implement formulas found in statistics like mean, median, and mode.
 * It also finds probability cases and uses many theorems like Bayes rule, binomial, geometric distribution, and
 * other formulas.
 * 
 * @author Melvin Vazquez
 */

public class statsLibrary {
	private int [] sampleNum = {1,2,3,4,5,6,7,8,8,8,9,9,8};
	private double [] sampleNum2 = {2,5,4,1,7,0,8,9,5,2};
	public statsLibrary() {

	}

	public statsLibrary(int[] sampleArr) {

	}
	/*
	 * This method finds the mean of an array by adding up all the numbers inside the array and then dividing 
	 * by the length of the array
	 * 
	 * 
	 * @param: userInput, which is the array of numbers the user himself input
	 * @return: result of the sum divided by the length of array
	 */
	public double findMean(int[] sampleArray) {// 2 options, use an array or array list.
		double sum = 0;
		for (int i = 0; i < sampleArray.length; i++) {
			sum = sampleArray[i] + sum;
		}
		double result = sum / sampleArray.length;
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
	public double findMedian(double[] sampleArr) {
		Arrays.sort(sampleArr);
		double midNum = 0;
		if (sampleArr.length % 2 == 0) {
			midNum = (sampleArr[sampleArr.length / 2] + sampleArr[sampleArr.length / 2 - 1]) / 2;
			return midNum;
		} else {
			return midNum = sampleArr[(sampleArr.length / 2)];
		}
	}

	/*
	 * This method finds the mode of an array by checking each number with each other and finding which number has the
	 * most occurrences inside the array. The number with the most occurrences is returned, otherwise null is returned
	 * 
	 * @param: userInput, which is the array of numbers the user himself input
	 * @return: uniqueNum, the number that has the most occurrences in the array or null if there is no unique number	 * @return: null, if there is no unique number or more than one, it will return null
	 */
	public Integer findMode(int[] sampleArr) {
		int count = 0;
		int maxCount = 0;
		Integer uniqueNum = 0;
		for (int i = 0; i < sampleArr.length; i++) {
			count = 0;
			for (int j = i+1; j < sampleArr.length; j++) {
				if (sampleArr[i] == sampleArr[j]) {
					count++;
				}
			}
			if (count > maxCount){
				maxCount = count;
				uniqueNum = sampleArr[i];
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

	public double standardDeviation(int[] sampleArr) {
		//array list to store the data found after completing the first iteration
		ArrayList<Double> data = new ArrayList<Double>();
		//setting variables to find num result, what I will return at the end, and the mean results
		double numResult = 0;
		double standardDeviation = 0;
		double meanResult = findMean(sampleArr);
		//This for loop goes through the length of the array and it subtracts each integer in array by mean result
		for (int i = 0; i < sampleArr.length; i++) {
			numResult = sampleArr[i] - meanResult;
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
	public double conditionalProb(double probA, double probB, double probAB){
		if(probB != 0) {
			double probAgivenB = probAB / probB;
			return probAgivenB;
		}
		else{
			throw new ArithmeticException();
		}
	}
	public String independent(double probA, double probB, double probAB) {
		if(conditionalProb(probA,probB,probAB)==probA) {
			return "independent";
		}
		if(conditionalProb(probB,probA,probAB)==probB){
			return "independent";
		}
		if(probAB == probB*probA) {
			return "independent";
		}
		else {
			return "dependent";
		}
	}
	public double multiplicativeLaw(double probA, double probB, double probAB, boolean dependency) {
		double probAinterB
		if(dependency) {
			probAinterB = probA*conditionalProb(probB,probA,probAB);
			return probAinterB;
		}
		else{
			probAinterB = probA * probB;
			return probAinterB;
		}
	}
	public double additiveLaw(double probA, double probB, double probAB, boolean exclusive){
		double probAunionB;
		if(!exclusive) {
			probAunionB = probA + probB - probAB;
			return probAunionB;
		}
		else {
			probAunionB = probA + probB;
			return probAunionB;
		}
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
		statsLibrary test = new statsLibrary(); 
		System.out.println("The average is: " + test.findMean(sampleNum));
		System.out.println("The median is: " + test.findMedian(sampleNum2));
		System.out.println("The mode is: " + test.findMode(sampleNum));
		System.out.println("The standard Deviation is: " + test.standardDeviation(sampleNum));
		System.out.println("The combination using double is: " + test.findCombinations(12,2));
		System.out.println("The combination using long is: " + test.longCombinations(12,2));
		System.out.println("The combination using big integer is: " + test.bigCombinations(12,2));
		System.out.println("The permutation is: " + test.findPermutations(6,2));
		System.out.println("The permutation using long is: " + test.longPermutations(6,2));
		System.out.println("The permutation using big integer is: " + test.bigPermutations(6,2));
		System.out.println("The factorial is: " + test.factorial(8));
		System.out.println("The factorial using long is: " + test.longFactorial(8));
		System.out.println("The factorial using big integer is: " + test.bigFactorial(8));
	}
}
