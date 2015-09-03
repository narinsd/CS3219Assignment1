package SharedRepo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Main class that maintain the access to the data of sub components
 */
public class MasterControl {
	
	private Input input;
	private CircularShifter circularShifter;
	private Alphabetizer alphabetizer;
	private Output output;
	
	public MasterControl(String inputString) throws FileNotFoundException {
		input = new Input(inputString);
		circularShifter = new CircularShifter();
		alphabetizer = new Alphabetizer();
		output = new Output();
	}
	
	/*
	 * run Master Control
	 */
	public String start(ArrayList<String> list) throws IOException {
		input.readData();
		ArrayList<String> splittedContext = input.getSplittedContext();
		ArrayList<String> ignoredWordList = list;
		
		ArrayList<String> result = new ArrayList<String>();
		
		for (String title : splittedContext) {
			result.addAll(circularShifter.getUnsortedResult(title, ignoredWordList));
		}
		
		alphabetizer.sort(result);
		return output.print(result);
	}
	
	//public static void main(String[] args) throws IOException {
	//	MasterControl mc = new MasterControl();
		//mc.start();
	//}
	
}
