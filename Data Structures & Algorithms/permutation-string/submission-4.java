class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        for (int r = 0; r < s1.length(); r++) {
            s1Freq[s1.charAt(r) - 'a']++;
            s2Freq[s2.charAt(r) - 'a']++;
        }
        int matches = 0;
        for (int r = 0; r < 26; r++) {
            if (s1Freq[r] == s2Freq[r]) {
                matches++;
            }
        }
        if (matches == 26) {
            return true;
        }
        for (int r = s1.length(); r < s2.length(); r++) {
            int index = s2.charAt(r) - 'a';
            s2Freq[index]++;
            if (s1Freq[index] == s2Freq[index]) {
                matches++;
            } else if (s1Freq[index] + 1 == s2Freq[index]) {
                matches--;
            }
            index = s2.charAt(r - s1.length()) - 'a';
            s2Freq[index]--;
            if (s1Freq[index] == s2Freq[index]) {
                matches++;
            } else if (s1Freq[index] - 1 == s2Freq[index]) {
                matches--;
            }
            if (matches == 26) {
                return true;
            }
        }
        return false;
    }
}
