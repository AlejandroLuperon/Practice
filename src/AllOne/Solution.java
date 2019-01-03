package AllOne;

/**
 */

public class Solution {
    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        //["AllOne","inc","inc","inc","inc","getMaxKey","inc","inc","inc","dec","inc","inc","inc","getMaxKey"]
        //[[],["hello"],["goodbye"],["hello"],["hello"],[],["leet"],["code"],["leet"],["hello"],["leet"],["code"],["code"],[]]        allOne.inc("hello");
        //["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
        //[[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMinKey());
        System.out.println("Alpha");
        allOne.dec("a");
        System.out.println(allOne.getMaxKey());
        System.out.println("Beta");
        System.out.println(allOne.getMinKey());
        System.out.println("Gamma");
    }
}
