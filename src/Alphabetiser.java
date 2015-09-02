import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class Alphabetiser {

	LinkedList<String> output;
	
	//Alphabetical Comparator
	private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
	    public int compare(String str1, String str2) {
	        int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
	        if (res == 0) {
	            res = str1.compareTo(str2);
	        }
	        return res;
	    }
	};

	
	public Alphabetiser() {
		output =  ShifterAlphPipe.output;
		alphabetise();
		output();
	}
	
	private void alphabetise () {
		Collections.sort(output, ALPHABETICAL_ORDER);
	}
	
	private void output() {
		String outputString = new String();
		while (output.size() != 0){
			outputString = outputString + output.removeFirst()+ "\n";
			//System.out.printf(output.removeFirst()+ "\n" );
		}
		MainWindow.getOutputView().setText(outputString);
	}
}
