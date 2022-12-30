import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearch {
    public String[][] letters;

    public WordSearch(String[][] letters) {
        this.letters = letters;
    }

    public static void main(String[] args) {
        ask();


    }


    public void guess(String word) {
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[i].length; j++) {
                if (letters[i][j].equals(String.valueOf(word.charAt(0)))) {
                    System.out.println("Found '" + word.charAt(0) + "' At: " + i + ", " + j);
                    for (int k = 1; k < word.length(); k ++) {
                        
                    }
                }



                }
            }
        System.out.println("Guessed word " + "'" + word + "'" + " not found");
        ask();


    }


    public static void ask() {
        Scanner wordScanner = new Scanner(System.in);
        System.out.println("Insert word for word search: ");

        String wordInput = wordScanner.nextLine().trim();
        Pattern sortNum = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = sortNum.matcher(wordInput);
        boolean inputFound = matcher.find();

        if (inputFound) {

            WordSearch crossword = new WordSearch(ChristmasWordSearch.letters);
            crossword.guess(wordInput.toUpperCase());
        }

        else {
            System.out.println("Invalid Syntax | Please input a word.");
            ask();
        }

    }
}
