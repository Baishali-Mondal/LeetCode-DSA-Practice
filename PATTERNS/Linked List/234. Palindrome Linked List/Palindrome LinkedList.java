
// APPROACH 4 - USING RECURSION WHICH COMPARES WHILE REWINDING THE RECURSION CALL
// TC - O(n)
// SC - O(1) -it uses the stack space
class Solution {
    ListNode curr;
    private boolean solve(ListNode head){
        if(head == null ){
            return true;
        }
        //Traversing till the end
        boolean ans = solve(head.next);

        // OR
        // Traversing till the end
        // if(!solve(head.next)){
        //     return false;
        // }


        //Comparing the start node and last node(while rewinding)
        if(head.val != curr.val){
            return false;
        }
        curr = curr.next;
        return ans;
    }

    public boolean isPalindrome(ListNode head) {
        curr = head;
        return solve(head.next);        
    }
}


// APPROACH 3 - REVERSING THE 1ST HALF OF THE LL WHILE FINDING THE MIDDLE NODE
// TC - O(n)
// SC - O(1) LEES NO OF TRAVERSAL
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        // Reversing the 1st half of the LL while Finding the Middle of the LL
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;

            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // to handle the case for Odd no of nodes 1->2->3->2->1 here slow will stay at 3 and hence will return false while comparing the two LL as fast is at last node and it can't move further
        if(fast != null){
            slow = slow.next;
        }

        //Comparing the reversed the 1st half and the 2nd half of LL
        while(slow != null && prev != null){
            if(prev.val != slow.val){
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}


// OPTIMAL - 1.FIND MIDDLE 2.REVERSE THE SECOND HALF OF LL 3.COMPARE BOTH THE LL
// TC - O(N)
// TC - O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        // Find the Middle of the LL
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the 2nd Half
        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;

            slow.next = prev;
            prev = slow;
            slow = next;
        }

        //Comparing both half of the LL
        ListNode firstHead = head;
        ListNode secondHead = prev;

        while(secondHead != null && firstHead != null){
            if(firstHead.val != secondHead.val){
                return false;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return true;
    }
}


// BRUTE -COPY INTO AN ARRAY AND USE TWO POINTERS ON BOTH ENDS
// TC - O(n)
// SC - O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        List<Integer> list = new ArrayList<>();

        // Copying node elemnts into the ArrayList
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        // Using Two Point on both ends 
        int left = 0;
        int right = list.size()-1;

        while(left < right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}