
//Floyd's Cycle Detection (TORTOISE & HARE)
// TC - O(n)
// SC - O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                return true;
            }            
        }
        return false;
    }
}



// BRUTE - USING HASHSET
// TC - O(n)
// SC - O(n)
public class Solution {
    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();

        while(head != null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);

            head = head.next;
        }
        return false;
    }
}