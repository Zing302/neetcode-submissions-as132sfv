class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deqeue = new ArrayDeque<>();
        int[] res=new int[nums.length-k+1];
        int left=0;
        for(int right=0;right<nums.length;right++){
            while(!deqeue.isEmpty() && nums[right] > nums[deqeue.peekLast()]){
                deqeue.pollLast();
            }
            deqeue.add(right);
            if(deqeue.peekFirst()==left-1){
                deqeue.pollFirst();
            }
            if(right-left+1==k){
                res[left]=nums[deqeue.peekFirst()];
                left++;
            }
        }
        return res;
    }
}
