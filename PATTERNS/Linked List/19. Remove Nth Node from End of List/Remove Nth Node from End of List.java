
// OPTIMAL
// TC - O(n)
// SC - O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        //Moving the fast pointer to n+1 steps
        for(int i=0; i<=n; i++){
            fast = fast.next;
        }

        //Move both a pointer so the slow reaches the node just befor thenode to be removed
        while( fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        //Delete the node
        slow.next = slow.next.next;

        return dummy.next;
    }
}

//  // BRUTE
//  // TC - O(n)
//  // SC - O(1) - two traversal
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        //total no nodes present
        while(temp != null){
            length++;
            temp = temp.next;
        }
        
        // Delete head in case of [1] where n=1 or [1,2]  where n=2
        if(length == n){
            return head.next;
        }

        //Finding the node whose next to be deleted 
        temp = head;
        for( int i=1; i<length-n; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}
