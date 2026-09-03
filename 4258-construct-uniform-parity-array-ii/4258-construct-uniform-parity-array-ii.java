class Solution {
    public boolean uniformArray(int[] nums1) {
        int[] arr = nums1.clone();
        Arrays.sort(arr);

        boolean hasOddBefore = false;
        boolean okEven = true;
        boolean okOdd = true;

        for(int val : arr){
            int par = val % 2;
            if(par == 0){
                if(!hasOddBefore){
                    okOdd = false;
                }
            }else{
                if(!hasOddBefore){
                    okEven = false;
                }
                hasOddBefore = true;
            }
        }
        return okEven || okOdd;
    }
}