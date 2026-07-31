class Solution {
  public int maxProfit(int[] prices) {
    int l = 0;
    int r = 1;
    int maxProfit = 0;
    while (l < r && r < prices.length) {
      while (prices[l] > prices[r] && l < prices.length) {
        l++;
      }
      while(r < prices.length && prices[l] <= prices[r]){
        maxProfit = Math.max(maxProfit, prices[r]-prices[l]);
        r++;
      }
    }
    return maxProfit;
  }
}
