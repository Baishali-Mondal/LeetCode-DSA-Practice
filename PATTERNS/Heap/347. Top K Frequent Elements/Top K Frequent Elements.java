// TC - O(n)(Storing freq) + O(nlogk)(Heap)
// SC - O(k)(Heap) + O(n)(Map)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

       //Step1 : Store freq into a map
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num : nums){  // O(n)
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }

        //Step : Min heap based on freq
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> mp.get(a) - mp.get(b));

        //Step 3 : Keep only K elements into the heap  // O(mlogk)
        for(int num : mp.keySet()){  // mp.keySet() --> this will run for unique elements in map & not for n elements
            pq.add(num);

            if(pq.size() > k){
                pq.poll();
            }
        }

        //Step 4 : Put heap elements into res
        int[] res = new int[k];

        for(int i=0; i<k; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}