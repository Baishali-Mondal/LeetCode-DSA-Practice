// TC: O(n log m)
// SC: O(1)

class Solution {

    public long powerCheck(int base, int expo, int limit){ //O(n)
        long res = 1;
        for(int i=1; i<=expo; i++){
            res = res * base;
            
            if(res > limit){  //no use of calc further as it will produce a more bigger res
                return res;
            }
        }
        return res;
    }
    
    public int nthRoot(int n, int m) {
       int start = 1;
       int end = m;
       
       if(m == 0) return 0;
       if(n == 1) return m;
       
       while(start <= end){ //O(log m)
           int mid = start + (end-start)/2;
           
           long val = powerCheck(mid, n, m);
           
           if(val == m){ // mid^n == m
               return mid;
           }
           else if(val < m){  //mid^n < m -> need for a bigger no so move to right half
               start = mid + 1;
           } 
           else{//mid^n > m -> need for a smaller no so move to left half
               end = mid - 1;
           }
       }
       return -1;
    }
}