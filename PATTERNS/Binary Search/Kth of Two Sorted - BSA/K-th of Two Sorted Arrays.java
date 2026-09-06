
// TC - O(log(min(n1,n2)))
// SC - O(1)

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n1 = a.length;
        int n2 = b.length;
        
        // mid1 + mid2 = k => mid2 = k - mid1
        // Range for mid1 ==> 0    <= mid1 <= n1
        // Range for mid2 ==> k-n2 <= mid1 <= k 
        // 0 <= mid2 <= n2 == 0 <= k - mid1 <= n2 ==> k-n2 <= mid1 <= k 
        int low = Math.max(0, k-n2);  
        int high = Math.min(k, n1);   
        
        while(low <= high){
            int mid1 = low + (high-low)/2;
            int mid2 = k - mid1;
            
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];
            
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : a[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : b[mid2];
            
            // Correct Partitioning of the Sorted Array
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }
            
            // Picked too many element from a hence reduce no of elements from a
            else if(l1 > r2){
                high = mid1 - 1;
            }
            
            //Picked too few elements from a hence pick more
            else{
                low = mid1 + 1;
            }
            
        }
        return -1;
    }
}