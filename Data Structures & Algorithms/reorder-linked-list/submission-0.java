/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversedNode = reverseNode(slow.next, null);
        slow.next = null;

        ListNode curr = head;
        while(head != null && reversedNode != null){
            ListNode next = head.next;
            head.next = reversedNode;
            reversedNode = reversedNode.next;
            head = head.next;
            head.next = next;
            head = head.next;
        }

    }

    private ListNode reverseNode(ListNode curr, ListNode prev){
        if(curr == null)
            return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return reverseNode(next, curr);
    }
}
