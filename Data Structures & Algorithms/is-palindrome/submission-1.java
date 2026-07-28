class Solution {
  public boolean isPalindrome(String s) {
    char[] c = s.toCharArray();

    int l = 0;
    int r = s.length() - 1;

    while (l < r) {
      if (!((c[l] >= '0' && c[l] <= '9') || (c[l] >= 'A' && c[l] <= 'Z') || (c[l] >= 'a'
              && c[l] <= 'z'))) {
        l++;
        continue;
      }
      if (!((c[r] >= '0' && c[r] <= '9') || (c[r] >= 'A' && c[r] <= 'Z') || (c[r] >= 'a'
              && c[r] <= 'z'))) {
        r--;
        continue;
      }
      if (!(Character.toLowerCase(c[l]) == Character.toLowerCase(c[r]))) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }
}
