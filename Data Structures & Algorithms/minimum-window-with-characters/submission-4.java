class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen < tLen) {
            return "";
        }

        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int required = tFreq.size();
        int resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        int l = 0;
        int got = 0;

        Map<Character, Integer> window = new HashMap<>();
        for (int r = 0; r < sLen; r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (tFreq.containsKey(c) && tFreq.get(c).equals(window.get(c))) {
                got++;
            }
            while (got == required) {
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (tFreq.containsKey(leftChar) && window.get(leftChar) < tFreq.get(leftChar)) {
                    got--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
