import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class TestsetOperations {

	@Test
	public static void main(String[]args) {
		setOperations test = new setOperations();
		String [] weekdays = {"Monday", "Tuesday","Wednesday","Thursday","Friday"};
		String [] weekend = {"Friday","Saturday","Sunday"};
		String [] subSetOfWeekdays = {"Tuesday", "Thursday", "Friday"};
		ArrayList<String> List1 = new ArrayList<>(Arrays.asList(weekdays));
		ArrayList<String> List2 = new ArrayList<>(Arrays.asList(weekend));
		ArrayList<String> List3 = new ArrayList<>(Arrays.asList(subSetOfWeekdays));
		test.setUnion(List1, List2);
		test.setIntersection(List1, List2);
		System.out.println(test.complement(List1, List3));
		
	}

}
