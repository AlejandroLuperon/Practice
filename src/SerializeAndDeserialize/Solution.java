package SerializeAndDeserialize;

/**
 */

public class Solution {

    public static void main(String[] args) {
        String data = "[1,2,3,null,null,4,5]".substring(1);
        data = data.substring(0, data.length()-1);

        System.out.println(data);
    }
}
