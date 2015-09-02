package shared;

import java.util.ArrayList;

public class Output {
	
	public Output() {
		
	}
	
	public void print(ArrayList<String> sortedResult) {
		for (String title : sortedResult) {
			System.out.println(title);
		}
	}

}
