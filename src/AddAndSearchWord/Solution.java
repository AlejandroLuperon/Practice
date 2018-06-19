package AddAndSearchWord;

/**
 */

public class Solution {
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));// -> false
        System.out.println(obj.search("bad"));// -> true
        //obj.search(".ad") -> true
        //obj.search("b..") -> true
    }
}
