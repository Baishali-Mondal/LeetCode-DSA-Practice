class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        //Store the freq of characters
        int[] freq = new int[26];

        for(char task : tasks){
            freq[task - 'A']++;
        }

        //Implemnet Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int heap : freq){
            if(heap > 0){
                pq.add(heap);
            }
        }

        int time = 0;

        while(!pq.isEmpty()){

            List<Integer> list = new ArrayList<>();

            int cycle = n+1;

            while(cycle > 0 &&!pq.isEmpty()){
                int cnt = pq.poll();
                cnt--;

                if(cnt > 0){
                    list.add(cnt);
                }
                time++;
                cycle--;
            }

            //All the remaining task need to added to the schedular
            for(int x : list){
                pq.add(x);
            }

            //for idle time --> when a task is left to complete
            if(!pq.isEmpty()){
                time = time + cycle;
            }
        }
        return time;
    }
}