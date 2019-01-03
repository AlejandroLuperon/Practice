package ValidPalindrome;

class Solution {
    public static void main(String[] args) {
        String thePalindrome1 = "abba";
        System.out.println(isPalindrome(thePalindrome1));

        String thePalindrome2 = "abcba";
        System.out.println(isPalindrome(thePalindrome2));

        String thePalindrome3 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(thePalindrome3));

        String theNotPalindrome3 = "alejandro";
        System.out.println(isPalindrome(theNotPalindrome3));
    }

    public static boolean isPalindrome(String s) {
        String theNormalizedString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for (int i = 0, j = theNormalizedString.length()-1; i < theNormalizedString.length()/2; i++, j--) {
            if (theNormalizedString.charAt(i) != theNormalizedString.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}