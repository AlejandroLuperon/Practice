package ValidPalindromeII;

import java.util.HashSet;


public class Solution {
    public static void main(String[] args) {
        String theIsAlmostPalindrome1 = "eedede";
        System.out.println(isAlmostPalindrome(theIsAlmostPalindrome1));
    }

    public static boolean isPalindrome(String s) {
        String theNormalizedString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for (int i = 0, j = theNormalizedString.length() - 1; i < theNormalizedString.length()/2; i++, j--) {
            if (theNormalizedString.charAt(i) != theNormalizedString.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlmostPalindrome(String s) {
        if (isPalindrome(s)) {
            return true;
        }

        StringBuilder theNormalizedString = new StringBuilder(s.replaceAll("[^A-Za-z0-9]", "").toLowerCase());
        for (int i = 0, j = theNormalizedString.length()-1; i < theNormalizedString.length()/2; i++, j--) {

            if (theNormalizedString.charAt(i) == theNormalizedString.charAt(j)) {
                continue;
            } else {
                HashSet<Boolean> isValidPalindromeSet = new HashSet<Boolean>();
                StringBuilder theIString = new StringBuilder(theNormalizedString);
                StringBuilder theJString = new StringBuilder(theNormalizedString);

                isValidPalindromeSet.add(isPalindrome(theIString.replace(i, i+1,"").toString()));
                isValidPalindromeSet.add(isPalindrome(theJString.replace(j, j+1,"").toString()));
                return isValidPalindromeSet.contains(true);
            }
        }
        return true;
    }
}
