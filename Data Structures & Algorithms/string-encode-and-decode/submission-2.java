class Solution {
    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for (String s1 : strs) {
            int len = s1.length();
            s.append(len).append("#").append(s1);
        }
        return s.toString();
    }

    public List<String> decode(String str) {

        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            decoded.add(str.substring(i, j));
            i = j;
        }
        return decoded;
    }
}
