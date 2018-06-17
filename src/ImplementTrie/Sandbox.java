package ImplementTrie;

/**
 Input:
 ["Trie","insert","search","search","startsWith","insert","search"]
 [[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
 Output:
 [null,null,true,true,true,null,true]
 Expected:
 [null,null,true,false,true,null,true]
 */

public class Sandbox {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("a");
        System.out.println(trie.startsWith("a"));
        System.out.println(trie.search("a"));

    }
}
