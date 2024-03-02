
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