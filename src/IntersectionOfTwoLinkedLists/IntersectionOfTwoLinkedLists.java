package IntersectionOfTwoLinkedLists;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        if (headA == headB) {
            return headA;
        }

        HashSet<ListNode> theSeenNodes = new HashSet<ListNode>();
        ListNode theAListNode = headA;
        ListNode theBListNode = headB;

        while(true) {

            if (theSeenNodes.contains(theBListNode)) {
                return theBListNode;
            }

            theSeenNodes.add(theBListNode);
            if (theBListNode.next == null) {
                break;
            }
            theBListNode = theBListNode.next;
        }

        while(true) {
            if (theSeenNodes.contains(theAListNode)) {
                return theAListNode;
            }

            theSeenNodes.add(theAListNode);
            if (theAListNode.next == null) {
                break;
            }
            theAListNode = theAListNode.next;
        }


        return null;
    }

    /*
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> theSeenNodes = new HashSet<ListNode>();

        if (headA == null || headB == null) {
            return null;
        }

        if (headA == headB) {
            return headA;
        }

        ListNode theAListNode = headA;
        ListNode theBListNode = headB;

        boolean aEnded = false;
        boolean bEnded = false;

        while(true) {
            if (theSeenNodes.contains(theAListNode)) {
                return theAListNode;
            }

            theSeenNodes.add(theAListNode);
            theAListNode = theAListNode.next;

            if (theSeenNodes.contains(theBListNode)) {
                return theBListNode;
            }
            theSeenNodes.add(theBListNode);
            theBListNode = theBListNode.next;
        }

        return null;
    }
     */

}
