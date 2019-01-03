package WordBreakII;

import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) {

       WordBreakIIAgain wordBreakII1 = new WordBreakIIAgain();
        String s1 = "pineapplepenapple";
        ArrayList<String> wordDict1 = new ArrayList<String>() {{
           add("apple");
           add("pen");
           add("applepen");
           add("pine");
           add("pineapple");
        }};

        System.out.println(wordBreakII1.wordBreak(s1, wordDict1));

       WordBreakIIAgain wordBreakII2 = new WordBreakIIAgain();
        String s2 = "catsandog";
        ArrayList<String> wordDict2 = new ArrayList<String>() {{
           add("cats");
           add("dog");
           add("sand");
           add("and");
           add("cat");
        }};

        System.out.println(wordBreakII2.wordBreak(s2, wordDict2));


       WordBreakIIAgain wordBreakII3 = new WordBreakIIAgain();
        String s3 = "catsanddog";
        ArrayList<String> wordDict3 = new ArrayList<String>() {{
           add("cat");
           add("cats");
           add("and");
           add("sand");
           add("dog");
        }};

        System.out.println(wordBreakII3.wordBreak(s3, wordDict3));


        //Sub
       WordBreakIIAgain wordBreakII4 = new WordBreakIIAgain();
        String s4 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        ArrayList<String> wordDict4 = new ArrayList<String>() {{
           add("a");
           add("aa");
           add("aaa");
           add("aaaa");
           add("aaaaa");
           add("aaaaaa");
           add("aaaaaaa");
           add("aaaaaaaa");
           add("aaaaaaaaa");
           add("aaaaaaaaaa");
           add("aaaaaaaaaaa");
        }};

        System.out.println(wordBreakII4.wordBreak(s4, wordDict4));

       WordBreakIIAgain wordBreakII5 = new WordBreakIIAgain();
        String s5 = "a";
        ArrayList<String> wordDict5 = new ArrayList<String>() {{
           add("a");
        }};

        System.out.println(wordBreakII5.wordBreak(s5, wordDict5));
    }
}
