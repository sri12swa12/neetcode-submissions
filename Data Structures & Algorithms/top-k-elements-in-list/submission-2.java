class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    List<Integer>[] freq = new ArrayList[nums.length + 1];
    for (int i = 0; i < freq.length; i++) {
      freq[i] = new ArrayList<>();
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();

      freq[value].add(key);
    }

    int[] res = new int[k];
    int index = 0;
    for(int j=freq.length - 1; j>=0; j--){
        List<Integer> freqNum = freq[j];
        for(int i=0;i<freqNum.size();i++){
            res[index++] = freqNum.get(i);
            if(index == k){
                return res;
            }
        }
    }
    return res;
  }
}