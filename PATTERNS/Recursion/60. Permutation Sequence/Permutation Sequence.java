// TC - O(n) * O(n)
// SC - O(n)
class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;

        List<Integer> numbers = new ArrayList<>();

        for(int i=1; i<n; i++){
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);

        String str = "";

        k = k-1; // bring k to zero based indexing

        while(true){
            str = str + numbers.get(k/fact);

            numbers.remove(k/fact);

            //if all numbers are used
            if(numbers.size() == 0){
                break; 
            }

            //update k
            k = k % fact;

            //cal fact for next position
            fact = fact / numbers.size();
        }
        return str;
    }
}