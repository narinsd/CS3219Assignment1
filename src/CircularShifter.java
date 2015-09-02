import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class CircularShifter {
	LinkedList<ArrayList<String>> inputData;
	HashMap<Integer, String> ignoreWords;
	int numOfLines;
	
	LinkedList<String> shifterOutput;
	
	public CircularShifter () {
		this.inputData = InputShifterPipe.inputData;
		this.ignoreWords = InputShifterPipe.ignoreWords;
		this.numOfLines = InputShifterPipe.numOfLines;
		shifterOutput = new LinkedList<String>();
		shiftWords();
		ShifterAlphPipe pipe = new ShifterAlphPipe(shifterOutput);
	}
	
	private void shiftWords() {
		int count = 0;
		
		while (count < numOfLines){
			ArrayList<String> temp = inputData.get(count);
			int count2 = 0;
			while (count2 < temp.size()){
				if ( !ignoreWords.containsKey(temp.get(0).toLowerCase().hashCode())){
					int count3 = 0;
					String output = new String();
					while (count3 < temp.size()){
						//capitalise first word
						if(count3 == 0){
							output = output + temp.get(count3).toUpperCase()+" ";
						}else{
							output = output + temp.get(count3)+ " ";
						}
						count3++;
					}
					shifterOutput.add(output);
				}
				// remove first word and append to the back
				String firstWord = temp.get(0);
				temp.add(firstWord);
				temp.remove(0);
				count2++;
			}
			count++;
		}
	}

}
