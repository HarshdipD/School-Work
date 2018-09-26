import java.io.File;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;


public class Lab1Improved {
	public static Entry<String, Integer> count_ARRAY(String[] tokens) {
		int CAPACITY = 10000;
		String[] words = new String[CAPACITY];
		int[] counts = new int[CAPACITY];
		for (int j = 0; j < tokens.length; j++) {
			String token = tokens[j];
			for (int i = 0; i < CAPACITY; i++) {
				if (words[i] == null) {
					words[i] = token;
					counts[i] = 1;
					break;
				} else if (words[i].equals(token))
					counts[i] = counts[i] + 1;
			}
		}

		int maxCount = 0;
		String maxWord = "";
		for (int i = 0; i < CAPACITY & words[i] != null; i++) {
			if (counts[i] > maxCount) {
				maxWord = words[i];
				maxCount = counts[i];
			}
		}
		return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);
	}

	public static Entry<String, Integer> count_LINKED_LIST(String[] tokens) {
		LinkedList<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>();
		for (int j = 0; j < tokens.length; j++) {
			String word = tokens[j];
                        //Iterating the words
                        Iterator<Entry<String, Integer>> it = list.iterator();
			boolean found = false;
			for (int i = 0; i < list.size(); i++) {
				Entry<String, Integer> e = it.next();

				if (word.equals(e.getKey())) {
					e.setValue(e.getValue() + 1);
					list.set(i, e);
					found = true;
					break;
				}
			}
			if (!found)
				list.add(new AbstractMap.SimpleEntry<String, Integer>(word, 1));
		}

		int maxCount = 0;
		String maxWord = "";
		for (int i = 0; i < list.size(); i++) {
			int count = list.get(i).getValue();
			if (count > maxCount) {
				maxWord = list.get(i).getKey();
				maxCount = count;
			}
		}
		return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);
	}

	static String[] readText(String PATH) throws Exception {
		Scanner doc = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
		int length = 0;
		while (doc.hasNext()) {
			doc.next();
			length++;
		}

		String[] tokens = new String[length];
		Scanner s = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
		length = 0;
		while (s.hasNext()) {
			tokens[length] = s.next().toLowerCase();
			length++;
		}
		doc.close();

		return tokens;
	}
        
        
        public static void Hashing(){
            //Creating wordCountMap which holds words as keys and their occurences as values
            HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
            BufferedReader reader = null;
            
            try{
                //Create BufferReader object
                reader = new BufferedReader(new FileReader("C:\\Users\\harsh\\Documents\\Java 60-212\\JavaApplication1\\src\\javaapplication1\\1.txt"));
                
                String currentLine = reader.readLine();
                while(currentLine != null){
                    //splitting the currentLine into words
                    String[] words = currentLine.toLowerCase().split(" ");
                    
                    //Iterating each word
                    for(String word : words){
                        //if word is already present in wordCountMap, update its count
                        if(wordCountMap.containsKey(word)){
                            wordCountMap.put(word, wordCountMap.get(word)+1);
                        }
                        else{
                            wordCountMap.put(word, 1);
                        }
                    }
                    //Reading next line into currentLine
                    currentLine = reader.readLine();
                }
            
            
            //Getting the most repeated word and its occurence
            String mostRepeatedWord = null;
            int count = 0;
            
            Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
            for(Entry<String, Integer> entry : entrySet){
                if(entry.getValue() > count){
                    mostRepeatedWord = entry.getKey();
                    count = entry.getValue();
                }
            }
            System.out.println("The most repeated word is " + mostRepeatedWord);
            System.out.println("Number of occurences: " + count);            
        }
            
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
                try{
                    reader.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
    }

	public static void main(String[] args) throws Exception {

		String PATH = "C:\\Users\\harsh\\Documents\\Java 60-212\\JavaApplication1\\src\\javaapplication1\\1.txt";
		String[] tokens = readText(PATH);
		long startTime = System.currentTimeMillis();
		Entry<String, Integer> entry = count_LINKED_LIST(tokens);
		long endTime = System.currentTimeMillis();
		String time = String.format("%12d", endTime - startTime);
		System.out.println("Linked List Algorithm:\ntime\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());

		tokens = readText(PATH);
		startTime = System.currentTimeMillis();
		entry = count_ARRAY(tokens);
		endTime = System.currentTimeMillis();
		time = String.format("%12d", endTime - startTime);
		System.out.println("Array Algorithm:\ntime\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());
	}

}
