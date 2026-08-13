class Solution {
    public int characterReplacement(String s, int k) {
    int[] count = new int[26];
    int left = 0;
    int maxFreq = 0;
    int maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        // add current character to window
        int idx = s.charAt(right) - 'A';
        count[idx]++;
        maxFreq = Math.max(maxFreq, count[idx]);

        // if window is invalid, shrink from left
        while ((right - left + 1) - maxFreq > k) {
            count[s.charAt(left) - 'A']--;
            left++;
            // maxFreq is intentionally not updated here
        }

        // window valid, update max length
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;

    }
}