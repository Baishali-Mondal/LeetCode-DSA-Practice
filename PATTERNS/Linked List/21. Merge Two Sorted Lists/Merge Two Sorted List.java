 // ITERATIVE
 // TC - O(m+n)
 // SC - O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            return (list1 != null)? list1 : list2;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        //COMPARING
        while(list1 != null && list2 != null){
            if( list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        //ATTACH THE REMAINING LL
        if(list1 != null){
            curr.next = list1;
        }
        else{
            curr.next = list2;
        }
        return dummy.next;
    }
}
    


 // RECURSION
 // TC - O(m+n)
 // SC - O(m+n)(recursion stack space)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            return (list1 != null)? list1 : list2;
        }

        // Comparing
        if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}