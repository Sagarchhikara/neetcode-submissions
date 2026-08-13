

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Store frequency of each number
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[k];

        // Step 2: Find the maximum frequency k times
        for (int i = 0; i < k; i++) {

            int maxKey = -1;
            int maxFrequency = Integer.MIN_VALUE;

            // Traverse the map to find the element with highest frequency
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                if (entry.getValue() > maxFrequency) {
                    maxFrequency = entry.getValue();
                    maxKey = entry.getKey();
                }
            }

            // Store the answer
            ans[i] = maxKey;

            // Remove it so it won't be selected again
            map.remove(maxKey);
        }

        return ans;
    }
}