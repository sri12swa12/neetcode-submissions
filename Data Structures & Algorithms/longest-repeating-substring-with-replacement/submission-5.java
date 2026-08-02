class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxFreq = 0;
        int[] freq = new int[26];
        int maxLength = 0;
        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);
            while ((r - l + 1) - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
