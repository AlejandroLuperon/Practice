package WordBreak;

public class DidntWorkWord {
    public String word;
    public int start;
    public int end;

    public DidntWorkWord(int inStart, int inEnd, String inWord) {
        start = inStart;
        end = inEnd;
        word = inWord;
    }

    public void print() {
        System.out.println("Word: " + word + " Start: " + start + " End: " + end);
    }
}