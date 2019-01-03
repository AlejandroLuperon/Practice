package WordSearch;

/**
 */

public class Solution {
    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        char[][] board2 = {
            {'A','C','A','R','E'},
            {'S','F','C','S','S'},
            {'A','D','E','E','Z'}
        };

        WordSearchJustWorks theWordSearch = new WordSearchJustWorks();

        theWordSearch.buildGraph(board2);
        System.out.println("result: " + theWordSearch.hasHorizontalWord("CAR"));
    }
}
