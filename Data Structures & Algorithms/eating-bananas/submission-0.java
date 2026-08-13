class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // Find the maximum pile size
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long hours = 0;

            // Calculate total hours needed at speed = mid
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // Equivalent to ceil(pile / mid)
            }

            if (hours <= h) {
                answer = mid;      // This speed works
                right = mid - 1;   // Try a smaller speed
            } else {
                left = mid + 1;    // Need to eat faster
            }
        }

        return answer;
    }
}