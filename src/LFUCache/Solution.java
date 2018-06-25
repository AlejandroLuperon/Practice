package LFUCache;


public class Solution {
    public static void main(String[] args) {
        /*LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4*/


       /* LFUCache cache = new LFUCache( 0);

        cache.put(0, 0);
        System.out.println(cache.get(0));       // returns 1*/
        /*["LFUCache","put","get","put","get","get"]
        [[1],[2,1],[2],[3,2],[2],[3]]*/
         LFUCache cache = new LFUCache(1);

         cache.put(2, 1);
         System.out.println(cache.get(2));
         cache.put(3,2);
         System.out.println(cache.get(2));
         System.out.println(cache.get(3));

        /*LFUCache cache = new LFUCache(2);

        cache.put(3,1);
        cache.put(2,1);
        cache.put(2,2);
        cache.put(4,4);
        System.out.println(cache.get(2));*/
        /*["LFUCache","put","put","get","get","put","get","get","get"]
        [[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]*/
        /*LFUCache cache = new LFUCache(2);

        cache.put(2,1);
        cache.put(3,2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));*/

    }
}
