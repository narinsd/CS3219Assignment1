package SharedRepo;

import java.util.ArrayList;

public class CircularShifter {
	
	public CircularShifter() {
		
	}
	
	/*
	 * Shift one word in the front to the end
	 */
	private void shift(ArrayList<String> titleList) {
		String head = titleList.get(0);
		titleList.remove(0);
		titleList.add(head);
	}
	
	/*
	 * Check the first word if it is an ignored word
	 */
	private boolean checkHead(ArrayList<String> titleList, ArrayList<String> ignoredWordList) {
		String head = titleList.get(0);
		return ignoredWordList.contains(head);
	}
	
	/*
	 * Split the whole title into a list of words
	 */
	private ArrayList<String> splitTitle(String title) {
		String[] words = title.split(" ");
		
		ArrayList<String> wordList = new ArrayList<String>();
		for (String word : words) {
			wordList.add(word);
		}
		
		return wordList;
	}
	
	/*
	 * Transfer an ArrayList to String
	 */
	private String arrayListToString(ArrayList<String> list) {
		String title = "";
		
		for (String s : list) {
			title += s;
			title += " ";
		}
		
		return title.substring(0, title.length()-1);
	}
	
	/*
	 * Capitalize the key word
	 */
	private String capitalizeKeyWord(String s) {
		return s.toUpperCase().substring(0);
		//return s.toUpperCase().substring(0, 1) + s.toLowerCase().substring(1);
	}
	
	/*
	 * Adjust the case of the original data
	 */
	private void adjustCaseForTitleList(ArrayList<String> titleList, ArrayList<String> ignoredWordList) {
		for (int i=0; i<titleList.size(); i++) {
			String word = titleList.get(i).toLowerCase();
			
			if (!ignoredWordList.contains(word)) {
				titleList.set(i, capitalizeKeyWord(word));
			} else {
				titleList.set(i, word);
			}
		}
	}
	
	/*
	 * Get the result from the data
	 * Called by Master Control
	 */
	public ArrayList<String> getUnsortedResult(String title, ArrayList<String> ignoredWordList) {
		ArrayList<String> titleList = splitTitle(title);
		adjustCaseForTitleList(titleList, ignoredWordList);
		
		ArrayList<String> unsortedResult = new ArrayList<String>();
		
		for (int i=0; i<titleList.size(); i++) {
			if (!checkHead(titleList, ignoredWordList)) {
				unsortedResult.add(arrayListToString(titleList));
			}
			
			shift(titleList);
		}
		
		return unsortedResult;
	}
	
}
