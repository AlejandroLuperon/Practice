package AddAndSearchWord;

/**
 * Input:
 ["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
 [[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]
 Output:
 [null,null,null,true,true,false,true,false,true]
 Expected:
 [null,null,null,true,true,false,true,false,false]
 */

public class Solution {
    public static void main(String[] args) {
        WordDictionaryBugFixes obj = new WordDictionaryBugFixes();
        obj.addWord("bat");
        System.out.println(obj.search("b."));
        /*obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));// -> false
        System.out.println(obj.search("bad"));// -> true
        System.out.println(obj.search(".ad"));// -> true
        System.out.println(obj.search("b.."));// -> true*/
    }
}
