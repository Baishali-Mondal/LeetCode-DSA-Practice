
//ITERATIVE
// TC - O(n)
// SC - O(1)
class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

//RECURSIVE
// TC - O(n)
// SC - O(n) [Stack Space]
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
}
