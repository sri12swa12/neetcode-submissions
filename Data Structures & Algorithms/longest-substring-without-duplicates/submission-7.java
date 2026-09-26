class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int length = s.length();
        int l = 0;
        int r = length;
        for (int i = 0; i < length; i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(i));
            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }
}
