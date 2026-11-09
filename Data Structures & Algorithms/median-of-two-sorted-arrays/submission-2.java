class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int total = nums1.length + nums2.length;
        int half = (total+1) / 2;
        int left = 0;
        int right = nums2.length;
        while(left <= right){
            int i = left + (right-left) / 2;
            int partition = half - i;
            int biggerLeft = Integer.MIN_VALUE;
            int biggerRight = Integer.MAX_VALUE;
            int smallerLeft = Integer.MIN_VALUE;
            int smallerRight = Integer.MAX_VALUE;
            if(i > 0){
                smallerLeft = nums2[i-1];
            }
            if(i < nums2.length){
                smallerRight = nums2[i];
            }
            if(partition > 0){
                biggerLeft = nums1[partition - 1];
            }
            if(partition < nums1.length){
                biggerRight = nums1[partition];
            }
            if(smallerLeft <= biggerRight && biggerLeft <= smallerRight){
                if(total % 2 == 0){
                    return (Math.max(smallerLeft,biggerLeft) + Math.min(biggerRight, smallerRight))/2.0;
                }
                return Math.max(smallerLeft,biggerLeft);
            }else if(smallerLeft > biggerRight){
                right = i - 1;
            }else{
                left = i + 1;
            }
        }
        return -1;
    }
}
