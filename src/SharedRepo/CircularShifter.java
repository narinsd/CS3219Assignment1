package SharedRepo;

import java.util.ArrayList;

public class CircularShifter {
	
	public CircularShifter() {
		
	}
	
	private void shift(ArrayList<String> titleList) {
		String head = titleList.get(0);
		titleList.remove(0);
		titleList.add(head);
	}
	
	private boolean checkHead(ArrayList<String> titleList, ArrayList<String> ignoredWordList) {
		String head = titleList.get(0);
		return ignoredWordList.contains(head);
	}
	
	private ArrayList<String> splitTitle(String title) {
		String[] words = title.split(" ");
		
		ArrayList<String> wordList = new ArrayList<String>();
		for (String word : words) {
			wordList.add(word);
		}
		
		return wordList;
	}
	
	private String arrayListToString(ArrayList<String> list) {
		String title = "";
		
		for (String s : list) {
			title += s;
			title += " ";
		}
		
		return title.substring(0, title.length()-1);
	}
	
	private String capitalizeKeyWord(String s) {
		return s.toUpperCase().substring(0);
		//return s.toUpperCase().substring(0, 1) + s.toLowerCase().substring(1);
	}
	
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
