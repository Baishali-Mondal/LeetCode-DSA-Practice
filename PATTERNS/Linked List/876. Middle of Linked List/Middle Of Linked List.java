 //OPTIMAL - HARE & TORTOISE -> SLOW & FAST POINTER
 // TC - O(N)
 // SC - O(1)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


// BRUTE - 2 TRAVERSAL --> ONE TO FIND THE TOTAL NO OF NODES, SECOND TO REACH TO THE MID NODE
// TC - O(n)
// SC - O(n)
class Solution {
    public ListNode middleNode(ListNode head) {
        int cnt = 0;
        ListNode temp = head;

        //First Traversal to count the total no of nodes
        while(temp != null){ //O(n)
            cnt++;
            temp = temp.next;
        }

        //Second traversal
        temp = head;

        int mid = cnt/2;

        while(mid > 0){ //O(n)
            temp = temp.next;
            mid--;
        }
        return temp;
    }
}