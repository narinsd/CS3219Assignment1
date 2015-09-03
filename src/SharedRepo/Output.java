package SharedRepo;


import java.util.ArrayList;

public class Output {
	
	public Output() {
		
	}
	
	/*
	 * Print the result
	 */
	public String print(ArrayList<String> sortedResult) {
		
		
		String outputString = new String();
		while (!sortedResult.isEmpty()){
			outputString = outputString + sortedResult.remove(0)+ "\n";
			//System.out.printf(output.removeFirst()+ "\n" );
		}
		return outputString;
	}

}
