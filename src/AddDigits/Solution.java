package AddDigits;

import java.util.*;

class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            num = getAmount(num);
        }
        return num;
    }

    public int getAmount(int num) {
        ArrayList<String> theDigits = new ArrayList<String>(Arrays.asList((num+"").split("")));
        int amount = 0;
        for (int i = 0; i < theDigits.size(); i++) {
            amount = amount + Integer.parseInt(theDigits.get(i));
        }
        return amount;
    }
}
