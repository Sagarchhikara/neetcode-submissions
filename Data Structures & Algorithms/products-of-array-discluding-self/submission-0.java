class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] suffix = new int[nums.length];

        suffix[nums.length - 1] = 1;

        for(int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = nums[i + 1] * suffix[i + 1];
        }

        int res = nums[0];

        for(int i = 1; i < nums.length; i++) {
            suffix[i] = suffix[i] * res;
            res = res * nums[i];
        }

        return suffix;
    }
}