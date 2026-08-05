class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }
     

        HashMap<Character, Integer> windowFreq = new HashMap<>();
        int formed = 0;
        int required = tFreq.size();

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (int r = 0; r < s.length(); r++) {
            char right = s.charAt(r);
            windowFreq.put(right, windowFreq.getOrDefault(right, 0) + 1);

            if (tFreq.containsKey(right) && windowFreq.get(right).intValue() == tFreq.get(right).intValue()) {
                formed++;
            }

            while (formed == required) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minStart = l;
                }

                char leftChar = s.charAt(l);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (tFreq.containsKey(leftChar) &&
                    windowFreq.get(leftChar).intValue() < tFreq.get(leftChar).intValue()) {
                    formed--;
                }

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}