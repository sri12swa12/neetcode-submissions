class Solution {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> dupSet = new HashSet<>();

    int l = 0;
    int maxLen = 0;

    for (int r = 0; r < s.length(); r++) {
      while (dupSet.contains(s.charAt(r))) {
        dupSet.remove(s.charAt(l));
        l++;
      }

      dupSet.add(s.charAt(r));
      maxLen = Math.max(maxLen, r - l + 1);
    }
    return maxLen;
  }
}
