class Solution {
    public boolean isValid(int[] arr, int k, long maxPage){
        int stu = 1;
        long sum = 0;
        
        for(int pages : arr){
           if (sum + pages > maxPage) {
                stu++;
                sum = pages;
            } 
            else {
                sum += pages;
            }
            if(stu > k){
                return false;
            }
        }
        return true;
    }
    public int findPages(int[] arr, int k) {
        // code here
        long start = 0;
        long end = 0;
        // int res =0;
        int n = arr.length;
        
        if(k > n){
            return -1;
        }
        
        for(int pages : arr){
            start = Math.max(start, pages);
            end += pages;
        }
        
        while(start <= end){
            long mid = start + (end-start)/2;
            
            if(isValid(arr, k, mid)){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return (int)start;
    }
}

// TC = O(n log(sum of pages))
// SC = O(1)