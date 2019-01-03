package ListCycle;

import java.util.HashSet;


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class Solution {
    public HashSet<ListNode> seen = new HashSet<ListNode>();
	public ListNode detectCycle(ListNode a) {
	    ListNode current = a;
	    seen.add(current);
	    while (current.next != null) {
	        if (seen.contains(current.next)) {
	            return current.next;
            } else {
	            seen.add(current.next);
	            current = current.next;
            }
        }
        return null;
	}
}
