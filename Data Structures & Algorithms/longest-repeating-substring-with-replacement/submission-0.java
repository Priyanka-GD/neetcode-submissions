class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> currWindow = new HashMap<>();

        int maxCharFrequency = 0, maxSubstringLength = 0;
        int left = 0, right = 0;
        while(right < s.length()){
            char rightChar = s.charAt(right);
            currWindow.put(rightChar, currWindow.getOrDefault(rightChar, 0)+ 1);
            maxCharFrequency = Math.max(maxCharFrequency, currWindow.get(rightChar));
            int windowSizeWithoutMaxChar = right - left - maxCharFrequency + 1;

            if(windowSizeWithoutMaxChar > k){
                char leftChar = s.charAt(left);
                currWindow.put(leftChar, currWindow.get(leftChar) - 1);
                left++;
            }     

            maxSubstringLength = Math.max(maxSubstringLength, right - left + 1);
            right++;   
        }
        return maxSubstringLength;
    }
}
