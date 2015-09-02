import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class Input {
	LinkedList<ArrayList<String>> inputData;
	//ArrayList<String> ignoreWords;
	HashMap<Integer, String> ignoreWords;
	int numOfLines = 0;
	
	public Input (String input, HashMap<Integer, String> ignoreWords) {
		
		inputData = new LinkedList<ArrayList<String>>();
		this.ignoreWords = ignoreWords;
		
		scanInputData(input);
		
		InputShifterPipe pipe = new InputShifterPipe(inputData, ignoreWords, numOfLines);
	}

	private void scanInputData(String input) {
		Scanner sc = new Scanner(input);
		boolean end = true;
		
		while (sc.hasNextLine() && end){
			
			ArrayList<String> temp =  new ArrayList<String>();
			
			while(sc.hasNext()){
				String next = sc.next();
				if(next.equals(",")){
					break;
				}else{
				temp.add(next);
				
				}
				
			}
			
			if (!sc.hasNext()){
				
				end = false;
			}
			inputData.add(temp);
			numOfLines++;
			
			
		}
		
		sc.close();
	}
	
	

}
