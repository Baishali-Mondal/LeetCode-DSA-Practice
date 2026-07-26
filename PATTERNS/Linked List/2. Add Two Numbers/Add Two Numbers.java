
// TC - O(max(m, n))
// SC - O(max(m,n)+1){Auxilary space}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;

        while(temp1 != null || temp2 != null || carry != 0){ // to avoid the carry of last elemnt
            int sum = carry;
            if(temp1 != null){
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if(temp2 != null){
                sum += temp2.val;
                temp2 = temp2.next;
            }

            carry = sum / 10;

            curr.next = new ListNode(sum % 10); //Creating and storing the nodes in a LL
            curr = curr.next;
        }
        return dummy.next;
    }
}