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
        ProperTrie trie = new ProperTrie();
        trie.insert("apple");
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("apull"));

    }
}
