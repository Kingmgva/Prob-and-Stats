/**
 * This class calls the set operations used in stats and returns the union, intersection, and complement of a list
@author - Melvin Vazquez
 */

package StatsLibrary;

/*
 * pick a data type to work with: Integer/String
 * can use days of week for a concrete sample
 * Write a method that unions two arrayList
 * Write a method that intersects two arrayList
 * Write a method that returns the complement of an arrayList
 * write a method that accepts two parameters: an arrayList of all values in your sample and one that accepts
 * A, Your Subset use that to solve for complement
 * complement is whatever is not inside subset
 * DON'T USE THE CLASS CALLED SET
 */
import java.util.ArrayList;

public class setOperations {
	public setOperations() {
	}

	public setOperations(ArrayList<String> userInput) {
	}
	/**
	 * Gets the users ArrayList and adds all to one list, then it goes through the list and checks if there are duplicates and removes them. After they are removed it will print out the combined list for user
	 * @param userList1 - the first list inputed, we used days of the week in the creation of all lists 
	 * @param userList2 - second list inputed, used days of the week in the creation of all lists
	 */
	public void setUnion(ArrayList<String> userList1, ArrayList<String> userList2) {
		ArrayList<String> unionList = new ArrayList<String>();
		unionList.addAll(userList1);
		unionList.addAll(userList2);
		for (int i = 0; i < unionList.size(); i++) {
			for(int j = i+1; j < unionList.size(); j++){
				if(unionList.get(i) == unionList.get(j)) {
					unionList.remove(j);
				}
			}
		}
		System.out.println(unionList);
	}
	/**
	 * This method checks both lists to see which values are in both list 1 and list 2, then adds it to one list and returns that list
	 * @param userList1 - days of the week, with some matching the days of the week of list 2
	 * @param userList2 - days of the week, with some matching the days of the week of list 1
	 * @return intersectionList - the list of same values present in list 1 and 2
	 */
	public ArrayList<String> setIntersection(ArrayList<String> userList1, ArrayList<String> userList2){
		ArrayList<String> intersectionList = new ArrayList<String>();
		for (int i = 0; i < userList1.size(); i++) {
			for(int j = 0; j < userList2.size(); j++){
				if(userList1.get(i) == userList2.get(j)) {
					intersectionList.add(userList2.get(j));
				}
			}
		}
		return intersectionList;
	}
	/**
	 * This method grabs the list with all elements and the subset of that list and compares them with each other. It checks whether a value from userlist is in subset and if not then it is added into the complement list.
	 * @param userList - all days of the week 
	 * @param subSet - some days of the week
	 * @return complementList - the values in userList that are not present in subSet
	 */
	public ArrayList <String> complement(ArrayList<String> userList, ArrayList<String> subSet) {
		ArrayList<String> complementList = new ArrayList<String>();
		for (String element: userList) {
		     if (!subSet.contains(element)){
		         complementList.add(element);
		        }
		}
		return complementList;
	}
}