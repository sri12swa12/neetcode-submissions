class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen < tLen) {
            return "";
        }

        Map<Character, Integer> tFreqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreqMap.put(c, tFreqMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> winFreqMap = new HashMap<>();
        int formed = 0;
        int required = tFreqMap.size();
        int l = 0;
        int resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        for (int r = 0; r < sLen; r++) {
            char c = s.charAt(r);
            winFreqMap.put(c, winFreqMap.getOrDefault(c, 0) + 1);

            if (tFreqMap.containsKey(c)&& (tFreqMap.get(c).equals(winFreqMap.get(c)))) {
                formed++;
            }
            while (formed == required) {
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char leftChar = s.charAt(l);
                winFreqMap.put(leftChar, winFreqMap.get(leftChar)- 1);
                if (tFreqMap.containsKey(leftChar)
                    && winFreqMap.get(leftChar) < tFreqMap.get(leftChar)) {
                    formed--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
