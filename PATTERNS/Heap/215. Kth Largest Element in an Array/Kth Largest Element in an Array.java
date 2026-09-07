// TC - O(nlogk)
// SC - O(k)
// USING HEAP CONCEPT - MIN HEAP
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.add(num);

            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}