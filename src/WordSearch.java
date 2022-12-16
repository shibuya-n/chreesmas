import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearch {
    public String[][] letters;

    public WordSearch(String[][] letters) {
        this.letters = letters;
    }

    public void guess(String word) {


        System.out.println("Guessed word " + "'" + word + "'" + " not found");
    }

    public static void main(String[] args) {
        ask();


    }

    public static void ask() {
        Scanner wordScanner = new Scanner(System.in);
        System.out.println("Insert word for word search: ");

        String wordInput = wordScanner.nextLine().trim();
        Pattern sortNum = Pattern.compile("[A-Za-z]");
        Matcher matcher = sortNum.matcher(wordInput);
        boolean inputFound = matcher.find();

        if (inputFound) {
            System.out.println(wordInput);
            WordSearch crossword = new WordSearch(ChristmasWordSearch.letters);
            crossword.guess(wordInput);
        }

    }
}
