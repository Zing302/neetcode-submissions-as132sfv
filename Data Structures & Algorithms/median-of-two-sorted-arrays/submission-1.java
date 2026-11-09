class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0.0;
        int total = nums1.length + nums2.length;
        boolean isEven = false;
        if(total % 2 == 0){
            isEven = true;
        }
        int half = (total+1) / 2;
        int[] bigger;
        int[] smaller;
        if(nums1.length > nums2.length){
            bigger = nums1;
            smaller = nums2;
        }else{
            bigger = nums2;
            smaller = nums1;
        }
        int left = 0;
        int right = smaller.length;
        while(left <= right){
            int i = left + (right-left) / 2;
            int partition = half - i;
            int biggerLeft = Integer.MIN_VALUE;
            int biggerRight = Integer.MAX_VALUE;
            int smallerLeft = Integer.MIN_VALUE;
            int smallerRight = Integer.MAX_VALUE;
            if(i > 0){
                smallerLeft = smaller[i-1];
            }
            if(i < smaller.length){
                smallerRight = smaller[i];
            }
            if(partition > 0){
                biggerLeft = bigger[partition - 1];
            }
            if(partition < bigger.length){
                biggerRight = bigger[partition];
            }
            if(smallerLeft <= biggerRight && biggerLeft <= smallerRight){
                if(isEven){
                    return (Math.max(smallerLeft,biggerLeft) + Math.min(biggerRight, smallerRight))/2.0;
                }
                return Math.max(smallerLeft,biggerLeft);
            }else if(smallerLeft > biggerRight){
                right = i - 1;
            }else{
                left = i + 1;
            }
        }
        return res;
    }
}
