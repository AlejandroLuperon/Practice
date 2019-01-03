package IntersectionOfTwoLinkedLists;

public class Solution {
    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists theIntersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        ListNode a1 = new ListNode("a1");
        ListNode a2 = new ListNode("a2");
        ListNode b1 = new ListNode("b1");
        ListNode b2 = new ListNode("b2");
        ListNode b3 = new ListNode("b3");
        ListNode c1 = new ListNode("c1");
        ListNode c2 = new ListNode("c2");
        ListNode c3 = new ListNode("c3");

        a1.next = a2;
        a2.next = c1;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        c1.next = c2;
        c2.next = c3;

        System.out.println(theIntersectionOfTwoLinkedLists.getIntersectionNode(a1, b1).val);
    }
}
