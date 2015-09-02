package shared;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MasterControl {
	
	private Input input;
	private CircularShifter circularShifter;
	private Alphabetizer alphabetizer;
	private Output output;
	
	public MasterControl() throws FileNotFoundException {
		input = new Input();
		circularShifter = new CircularShifter();
		alphabetizer = new Alphabetizer();
		output = new Output();
	}
	
	public void start() throws IOException {
		input.readData();
		ArrayList<String> splittedContext = input.getSplittedContext();
		ArrayList<String> ignoredWordList = input.getIgnoredWordList();
		
		ArrayList<String> result = new ArrayList<String>();
		
		for (String title : splittedContext) {
			result.addAll(circularShifter.getUnsortedResult(title, ignoredWordList));
		}
		
		alphabetizer.sort(result);
		output.print(result);
	}
	
	public static void main(String[] args) throws IOException {
		MasterControl mc = new MasterControl();
		mc.start();
	}
	
}
