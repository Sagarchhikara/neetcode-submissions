class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[] result = new int[n + m];

        int i = 0, j = 0, k = 0;

        // Merge both arrays
        while (i < n && j < m) {

            if (nums1[i] <= nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        // Remaining elements of nums1
        while (i < n) {
            result[k++] = nums1[i++];
        }

        // Remaining elements of nums2
        while (j < m) {
            result[k++] = nums2[j++];
        }

        int size = result.length;

        // Odd
        if (size % 2 != 0) {
            return result[size / 2];
        }

        // Even
        else {
            return (result[size / 2 - 1] + result[size / 2]) / 2.0;
        }
    }
}