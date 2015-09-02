package SharedRepo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
	
	final private String IGNOREWORDS_FILE_PATH = "ignorewords.txt";
	
	private Scanner sc;
	private String inputString;
	
	private ArrayList<String> splittedContext;
	private ArrayList<String> ignoredWordList;
	
	private BufferedReader br;
	
	public Input(String input) throws FileNotFoundException {
		sc = new Scanner(input);
		br = new BufferedReader(new FileReader(IGNOREWORDS_FILE_PATH));
		inputString =input;
		
		splittedContext = new ArrayList<String>();
		ignoredWordList = new ArrayList<String>();
	}
	
	private String readLine() {
		return sc.nextLine();
	}
	
	private ArrayList<String> splitByComma() {
		String[] words = inputString.split(",");
		
		ArrayList<String> wordList = new ArrayList<String>();
		for (String word : words) {
			String wordNoEndCharacter = word.trim();
			
			wordList.add(wordNoEndCharacter);
		}
		
		return wordList;
	}
	
	public void readData() throws IOException {
		splittedContext = splitByComma();
		//br.lines().forEach(word -> ignoredWordList.add(word.trim()));
		br.close();
	}
	
	public ArrayList<String> getSplittedContext() {
		return splittedContext;
	}
	
	public ArrayList<String> getIgnoredWordList() {
		return ignoredWordList;
	}
	
}
