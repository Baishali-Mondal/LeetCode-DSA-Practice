/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// OPTIMAL - TORTOISE & HARE
// TC - O(n)
// SC - O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                ListNode ptr = head;

                while(ptr != slow){
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }
}

// BRUTE - USING HASHSET
// TC - O(n)
// SC - O(n)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while(head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}