class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int total = nums1.length + nums2.length;
        int half = (total+1)/2;
        int left = 0;
        int right = nums2.length;
        while(left <= right){
            int i = left + (right - left) / 2;
            int p = half - i;
            double nums2Left = Double.NEGATIVE_INFINITY;
            double nums2Right = Double.POSITIVE_INFINITY;
            double nums1Left = Double.NEGATIVE_INFINITY;
            double nums1Right = Double.POSITIVE_INFINITY;
            if(i > 0){
                nums2Left = nums2[i-1];
            }
            if(i < nums2.length){
                nums2Right = nums2[i];
            }
            if(p > 0){
                nums1Left = nums1[p-1];
            }
            if(p < nums1.length){
                nums1Right = nums1[p];
            }
            if(nums2Left <= nums1Right && nums1Left <= nums2Right){
                if(total %2 !=0){
                    return Math.max(nums2Left, nums1Left);
                }
                return (Math.max(nums2Left, nums1Left) + Math.min(nums2Right,nums1Right))/2.0;
            }else if(nums2Left > nums1Right){
                right = i - 1;
            }else{
                left = i + 1;
            }
        }
        return -1.0;
    } 
}
