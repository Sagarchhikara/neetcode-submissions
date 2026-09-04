class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequency of each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // How many tasks have the maximum frequency?
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        // Build the schedule around the most frequent task
        int result = (maxFreq - 1) * (n + 1) + maxCount;

        // We can always just execute tasks one after another
        return Math.max(result, tasks.length);
    }
}