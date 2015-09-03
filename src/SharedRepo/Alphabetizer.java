package SharedRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetizer {
	private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
	    public int compare(String str1, String str2) {
	        int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
	        if (res == 0) {
	            res = str1.compareTo(str2);
	        }
	        return res;
	    }
	};

	public Alphabetizer() {
		
	}

	/*
	 * Sort the results in an alphabetical order
	 */
	public void sort(ArrayList<String> unsortedResult) {
		Collections.sort(unsortedResult, ALPHABETICAL_ORDER );
	}
	
}
