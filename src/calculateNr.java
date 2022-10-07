import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class calculateNr {
	
	static int stringToKey(String s) {
		int c = 0;
		String s2 = "";
		char[] cA = s.toCharArray();
		
		while (c < cA.length) {
			int asC = (int) cA[c];
			s2 += asC;
		}
		return Integer.parseInt(s2);
	}

	public static void main(String[] args) throws FileNotFoundException {
	    File file = new File("words.txt");
	    Scanner input = new Scanner(file); 
	    AVLTree tree = new AVLTree();
	    ArrayList<DictEntry> entries = null;
	    
	    int count = 0;
	    while (input.hasNext()) {
	      String word  = input.next().replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
	      int value = stringToKey(word);
	      if(tree.search(value)) {
	    	  DictEntry d = entries.get(value);
	    	  d.changeValue(((int) d.value() + 1));
	      }
	      else {
	    	  tree.insert(value);
	    	  entries.set(value, new DictEntry(word,1));
	      }
	      AVLNode node = new AVLNode(value);
	      count++;
	    }
	    
	    int n = 0;
	    while(n < entries.size() && count > 0) {
	    	System.out.println(entries.get(n));
	    	count--;
	    	n++;
	    }
	}
}
