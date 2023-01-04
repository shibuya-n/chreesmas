import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearch {
    public String[][] letters;

    public int tempI = 0;
    public int tempJ = 0;





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


                    rightCheck(word, i, j);
                }
                }
            }
        System.out.println("Guessed word " + "'" + word + "'" + " not found");
        ask();


    }

    public void rightCheck(String word, int i, int j) {
        String checkBank = "";
        try {
            for (int y = 0; y < word.length(); y++) {
                checkBank += letters[i][j + y];
            }
        }
        catch (Exception e) {
            System.out.println("Word not found; Goes past array");
            System.out.println("");
        }

        System.out.println("RIGHT CHECK: " + checkBank);

        if (checkBank.equals(word)) {
            System.out.println("Word found!");
            System.out.println("");

            checkBank = "";
        }
        else {
            System.out.println("Word not found!");
            System.out.println("");

            checkBank = "";
            leftCheck(word, i, j);
        }
        }


    public void leftCheck(String word, int i, int j) {
        String checkBank = "";
        try {
            for (int y = 0; y < word.length(); y++) {
                checkBank += letters[i][j - y];
            }
        }
        catch (Exception e) {
            System.out.println("Word not found; Goes past array");
            System.out.println("");
        }

        System.out.println("LEFT CHECK: " + checkBank);

        if (checkBank.equals(word)) {
            System.out.println("Word found!");
            System.out.println("");

            checkBank = "";
        }
        else {
            System.out.println("Word not found!");
            System.out.println("");

            checkBank = "";
            upCheck(word, i, j);
        }
        }
    public void upCheck(String word, int i, int j) {
        String checkBank = "";
        try {
            for (int x = 0; x < word.length(); x++) {
                checkBank += letters[i + x][j];
            }
        }
        catch (Exception e) {
            System.out.println("Word not found; Goes past array");
            System.out.println("");
        }

        System.out.println("UP CHECK: " + checkBank);

        if (checkBank.equals(word)) {
            System.out.println("Word found!");
            System.out.println("");

            checkBank = "";
        }
        else {
            System.out.println("Word not found!");
            System.out.println("");

            checkBank = "";
            downCheck(word, i, j);
        }
    }
    public void downCheck(String word, int i, int j) {
        String checkBank = "";
        try {
            for (int x = 0; x < word.length(); x++) {
                checkBank += letters[i - x][j];
            }
        }
        catch (Exception e) {
            System.out.println("Word not found; Goes past array");
            System.out.println("");
        }

        System.out.println("UP CHECK: " + checkBank);

        if (checkBank.equals(word)) {
            System.out.println("Word found!");
            System.out.println("");

            checkBank = "";
        }
        else {
            System.out.println("Word not found!");
            System.out.println("");

            checkBank = "";
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
