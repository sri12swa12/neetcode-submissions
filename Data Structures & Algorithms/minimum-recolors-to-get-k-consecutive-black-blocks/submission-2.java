class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int recolor = 0;
        for (int r = 0; r < blocks.length(); r++) {
            if (blocks.charAt(r) == 'W') {
                recolor++;
            }
            if (r - l + 1 == k) {
                min = Math.min(min, recolor);
                if (blocks.charAt(l) == 'W')
                    recolor--;
                l++;
            }
        }

        return min;
    }
}