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

//  TC = O(N log K)
//  SC = O(K)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);

        //Add first node of each list
        for(ListNode node : lists){
            if(node != null){
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!pq.isEmpty()){

            //retrive the smallest node
            ListNode curr = pq.poll();

            //Adding to the final result
            tail.next = curr;
            tail =tail.next;

            //add next node 
            if(curr.next != null){
                pq.add(curr.next);
            }

        }
        return dummy.next;
    }
}