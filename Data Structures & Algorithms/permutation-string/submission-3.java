class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Freq = new int[26];
        int s1len = s1.length();
        for (int r = 0; r < s1len; r++) {
            s1Freq[s1.charAt(r) - 'a']++;
        }
        int[] s2Freq = new int[26];
        for (int r = 0; r < s1len; r++) {
            s2Freq[s2.charAt(r) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] == s2Freq[i]) {
                matches++;
            }
        }
        if (matches == 26) {
            return true;
        }
        for (int r = s1len; r < s2.length(); r++) {
            int index = s2.charAt(r) - 'a';
            s2Freq[index]++;
            if (s1Freq[index] == s2Freq[index]) {
                matches++;
            } else if (s1Freq[index] + 1 == s2Freq[index]) {
                matches--;
            }
            int leftIdx = s2.charAt(r - s1len) - 'a';
            s2Freq[leftIdx]--;
            if (s1Freq[leftIdx] == s2Freq[leftIdx]) {
                matches++;
            } else if (s1Freq[leftIdx] - 1 == s2Freq[leftIdx]) {
                matches--;
            }
            if (matches == 26) {
                return true;
            }
        }
        return false;
    }
}
