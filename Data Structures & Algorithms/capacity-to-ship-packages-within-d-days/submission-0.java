class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        // Search range
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        int answer = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int requiredDays = 1;
            int currentLoad = 0;

            // Check if capacity = mid works
            for (int weight : weights) {

                if (currentLoad + weight > mid) {
                    requiredDays++;
                    currentLoad = weight;
                } else {
                    currentLoad += weight;
                }
            }

            if (requiredDays <= days) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}