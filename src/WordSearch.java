public class WordSearch {
    public String[][] letters;

    public WordSearch(String[][] letters) {
        this.letters = letters;
    }

    public void guess(String word) {
        System.out.println("Guessed word " + "'" + word + "'" + " not found");
    }

    public static void main(String[] args) {
        WordSearch crossword = new WordSearch(ChristmasWordSearch.letters);
    }
}
