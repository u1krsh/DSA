class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> nextGreat = new HashMap<>();

        for(int num: nums2){
            while(!stack.isEmpty() && stack.peek() <num){
                nextGreat.put(stack.pop(),num);
            }
            stack.push(num);
        }

        while(!stack.isEmpty()){
            nextGreat.put(stack.pop(),-1);
        }
        int[] result = new int[nums1.length];
        for(int i =0;i<nums1.length;i++){
            result[i] = nextGreat.get(nums1[i]);
        }
        return result;
    }

}