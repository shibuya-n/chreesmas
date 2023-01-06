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


    public void guess(String word) {

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[i].length; j++) {
                if (letters[i][j].equals(String.valueOf(word.charAt(0)))) {
                    rightCheck(word, i, j);
                }
            }
        }
        System.out.println();
        System.out.println("Guessed word " + "'" + word + "'" + " not found");
        ask();
    }

    public void rightCheck(String word, int i, int j) {
        StringBuilder checkBank = new StringBuilder();
        try {
            for (int y = 0; y < word.length(); y++) {
                checkBank.append(letters[i][j + y]);
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException) {
        }

        if (word.equals(checkBank.toString())) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Word found! First Letter Coordinates: [" + i + "] " + "[" + j + "]");
            System.out.println("Direction: Right");
            System.out.println("------------------------------------------------------------------");
            System.out.println();

            checkBank = new StringBuilder();
            ask();
        }
        else {
            checkBank = new StringBuilder();
            leftCheck(word, i, j);
        }
    }


    public void leftCheck(String word, int i, int j) {
        StringBuilder checkBank = new StringBuilder();
        try {
            for (int y = 0; y < word.length(); y++) {
                checkBank.append(letters[i][j - y]);
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException) {
        }

        if (word.equals(checkBank.toString())) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Word found! First Letter Coordinates: [" + i + "] " + "[" + j + "]");
            System.out.println("Direction: Left");
            System.out.println("------------------------------------------------------------------");
            System.out.println();

            checkBank = new StringBuilder();
            ask();
        }
        else {
            checkBank = new StringBuilder();
            upCheck(word, i, j);
        }
    }
    public void upCheck(String word, int i, int j) {
        StringBuilder checkBank = new StringBuilder();
        try {
            for (int x = 0; x < word.length(); x++) {
                checkBank.append(letters[i - x][j]);
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException) {
        }

        if (word.equals(checkBank.toString())) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Word found! First Letter Coordinates: [" + i + "] " + "[" + j + "]");
            System.out.println("Direction: Up");
            System.out.println("------------------------------------------------------------------");
            System.out.println();

            checkBank = new StringBuilder();
            ask();
        }
        else {
            checkBank = new StringBuilder();
            downCheck(word, i, j);
        }
    }
    public void downCheck(String word, int i, int j) {
        StringBuilder checkBank = new StringBuilder();
        try {
            for (int x = 0; x < word.length(); x++) {
                checkBank.append(letters[i + x][j]);
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException  ) {
        }

        if (word.equals(checkBank.toString())) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Word found! First Letter Coordinates: [" + i + "] " + "[" + j + "]");
            System.out.println("Direction: Down");
            System.out.println("------------------------------------------------------------------");
            System.out.println();

            checkBank = new StringBuilder();

            ask();
        }
        else {
            checkBank = new StringBuilder();
            rightDiagCheck(word, i, j);
        }
    }
    public void rightDiagCheck(String word, int i, int j) {
        StringBuilder upBank = new StringBuilder();
        StringBuilder downBank = new StringBuilder();

        try {
            for (int x = 0; x < word.length(); x++) {
                upBank.append(letters[i - x][j + x]);
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException) {
        }
        try {
            for (int x = 0; x < word.length(); x++) {
                downBank.append(letters[i + x][j - x]);
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException) {
        }

        if (word.equals(upBank.toString())) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Word found! First Letter Coordinates: [" + i + "] " + "[" + j + "]");
            System.out.println("Direction: Right Diagonal (Up) ");
            System.out.println("------------------------------------------------------------------");
            System.out.println();

            upBank = new StringBuilder();
            downBank = new StringBuilder();

            ask();
        }
        else if (word.equals(downBank.toString())){
            System.out.println("------------------------------------------------------------------");
            System.out.println("Word found! First Letter Coordinates: [" + i + "] " + "[" + j + "]");
            System.out.println("Direction: Right Diagonal (Down)");
            System.out.println("------------------------------------------------------------------");
            System.out.println();

            upBank = new StringBuilder();
            downBank = new StringBuilder();

            ask();
        }
        else {
            upBank = new StringBuilder();
            downBank = new StringBuilder();

            leftDiagCheck(word, i, j);
        }
    }
    public void leftDiagCheck(String word, int i, int j) {
        StringBuilder upBank = new StringBuilder();
        StringBuilder downBank = new StringBuilder();
        String result = "";

        // diagonal going up
        try {
            for (int x = 0; x < word.length(); x++) {
                upBank.append(letters[i - x][j - x]);
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException) {
        }
        //diagonal going down
        try {
            for (int x = 0; x < word.length(); x++) {
                downBank.append(letters[i + x][j + x]);
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException) {
        }

        if (word.equals(upBank.toString())) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Word found! First Letter Coordinates: [" + i + "] " + "[" + j + "]");
            System.out.println("Direction: Left Diagonal (Up)");
            System.out.println("------------------------------------------------------------------");
            System.out.println();

            upBank = new StringBuilder();
            downBank = new StringBuilder();

            ask();
        }
        else if (word.equals(downBank.toString())) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Word found! First Letter Coordinates: [" + i + "] " + "[" + j + "]");
            System.out.println("Direction: Left Diagonal (Down)");
            System.out.println("------------------------------------------------------------------");
            System.out.println();

            upBank = new StringBuilder();
            downBank = new StringBuilder();

            ask();
        }
        else {
            upBank = new StringBuilder();
            downBank = new StringBuilder();
        }
    }
}
