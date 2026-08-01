class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> dupSet = new HashSet<>();
        int maxLength = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (dupSet.contains(s.charAt(r))) {
                dupSet.remove(s.charAt(l));
                l++;
            }

            dupSet.add(s.charAt(r));

            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
