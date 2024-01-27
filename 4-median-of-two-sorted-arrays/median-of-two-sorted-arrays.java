class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length+nums2.length;

        int newArray[] = new int[n];

        System.arraycopy(nums1,0,newArray,0,nums1.length);
        System.arraycopy(nums2,0,newArray,nums1.length,nums2.length);
        Arrays.sort(newArray);
        if (n%2 != 0){
            return newArray[n/2];
        }else{
            return (newArray[n/2]+newArray[(n/2)-1])/(float)2;
        }
    }
}