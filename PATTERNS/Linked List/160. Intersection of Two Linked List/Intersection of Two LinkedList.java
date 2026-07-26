//OPTIMAL - USING TWO POINTER ( IF 1 NODE REACHES NULL MOVE TO THE OTHER LL TO COVER THE DIFF)
// TC - O(m+n)
// SC - O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while( tempA != tempB){
            if(tempA == null){
                tempA = headB;
            }else{
            tempA = tempA.next;
            }

            if(tempB == null){
                tempB = headA;
            }else{
                tempB = tempB.next;
            }
        }
        return tempA;
    }
}



//APPROACH 2 - USING LENGTH DIFFERENCE 
// TC - O(m) + O(n) + O(|m-n|) + O(min(m,n))
// SC - O(1)
public class Solution {
    //Find the length of each LL
    private int getNodeLength(ListNode head){

        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        int lengthA = getNodeLength(headA);
        int lengthB = getNodeLength(headB);

        // moving the k difference pointers ahead
        if(lengthA > lengthB){
            int diff = lengthA - lengthB;
            tempA = headA;
            while( diff > 0 ){
                diff--;
                tempA = tempA.next;
            }
        }else{
            int diff = lengthB - lengthA;

            tempB = headB;
            while( diff > 0 ){
                diff--;
                tempB = tempB.next;
            }            
        }

        //Moving both the pointers together to find the intersection node
        while(tempA!= null && tempB != null){
            if(tempA == tempB){
                return tempA;
            }
            tempA = tempA.next;
            tempB =tempB.next;
        }
        return null;
    }
}


//APPROACH 2 - USING HASHSET
// TC - O(m+n)
// SC - O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode tempA = headA;
        
        while(tempA != null){
            set.add(tempA);
            tempA = tempA.next;
        }

        ListNode tempB = headB;
        while(tempB != null){
            if(set.contains(tempB)){
                return tempB;
            }
            set.add(tempB);
            tempB = tempB.next;
        }
        return null;
    }
}


// BRUTE - COMPARING EVERY NODE OF ONE LL TO EVERY NODE OF THE OTHER LL
// TC - O(m*n)
// SC - O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        
        while(tempA != null){
            ListNode tempB = headB;

            while(tempB != null){
                if(tempA == tempB){
                    return tempB;
                }
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return null;
    }
}