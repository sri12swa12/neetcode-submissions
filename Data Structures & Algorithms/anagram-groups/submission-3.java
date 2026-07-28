class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);
            String key = String.valueOf(sorted);

            if(map.containsKey(key)){
                List<String> groupStrings = map.get(key);
                groupStrings.add(s);
                map.put(key, groupStrings);
            }
            else{
                List<String> newString = new ArrayList<>();
                newString.add(s);
                map.put(key, newString);
            }
        }

       for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
       }
       return res;

    }
}