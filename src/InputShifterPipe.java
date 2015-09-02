import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class InputShifterPipe {
	static LinkedList<ArrayList<String>> inputData;
	static HashMap<Integer, String> ignoreWords;
	static int numOfLines;
	
	public InputShifterPipe (LinkedList<ArrayList<String>> inputData, HashMap<Integer, String> ignoreWords, int numOfLines){
		this.inputData = inputData;
		this.ignoreWords = ignoreWords;
		this.numOfLines = numOfLines;
		CircularShifter filter = new CircularShifter();
	}

}
