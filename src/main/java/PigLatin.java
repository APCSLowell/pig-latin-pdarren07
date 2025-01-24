import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public int findFirstVowel(String sWord) {
        //precondition: sWord is a valid String of length greater than 0.
        //postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
	    // your code goes here
	String vowels = "aeiou";
        sWord = sWord.toLowerCase();
        for (int i = 0; i < sWord.length(); i++) {
            if (vowels.indexOf(sWord.charAt(i)) != -1) {
                return i;
            }
        }
        return -1;
    }

    public String pigLatin(String sWord) {
        //precondition: sWord is a valid String of length greater than 0
        //postcondition: returns the pig latin equivalent of sWord
        // more code should go here
	if (sWord == null || sWord.isEmpty()) {
            return ""; // Handle null or empty string gracefully
        }

        int firstVowel = findFirstVowel(sWord);
        if (firstVowel == -1) {
            return sWord + "ay"; // No vowels
        } else if (firstVowel == 0) {
            return sWord + "way"; // Starts with a vowel
        } else if (sWord.toLowerCase().startsWith("qu")) {
            return sWord.substring(2) + sWord.substring(0, 2) + "ay"; // Handle "qu"
        } else {
            return sWord.substring(firstVowel) + sWord.substring(0, firstVowel) + "ay"; // General case
        }
    }
}//end PigLatin class
