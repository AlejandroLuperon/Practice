package ListCycle;

import java.util.ArrayList;
import java.util.List;


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class InefficientSolution {
    public List<ListNode> seen = new ArrayList<ListNode>();
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
