import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearch {
    public String[][] letters;

    public int i = 0;
    public int j = 0;


    public WordSearch(String[][] letters) {
        this.letters = letters;
    }

    public static void main(String[] args) {
        ask();


    }


    public void guess(String word) {
        int tempI = 0;
        int tempJ = 0;

        for (i = 0; i < letters.length; i++) {
            for (j = 0; j < letters[i].length; j++) {
                int k = 0;
                if (letters[i][j].equals(String.valueOf(word.charAt(0)))) {
                    System.out.println("Found '" + word.charAt(0) + "' At: " + i + ", " + j);
                    tempI = i;
                    tempJ = j;
                    k++;
                }
                }
            }
        System.out.println("Guessed word " + "'" + word + "'" + " not found");
        ask();


    }

    public void directionCheck(String word) {
        for (int x = 1; x < word.length(); x++) {
            // loop through the characters?
            // then mess with i and j in order to do horizontal/diagonal search
            // if letter is a match then add it to a temp character bank to create the whole word and then check it against the original word
        }

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
