class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, count = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.get(ch) > 1){
                char leftCh = s.charAt(left);
                map.put(leftCh, map.get(leftCh) - 1);
                left++;
            }

            count = Math.max(count, right - left + 1);
            right++;
        }
        return count;
    }
}
