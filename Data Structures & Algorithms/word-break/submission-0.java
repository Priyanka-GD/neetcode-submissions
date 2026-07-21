class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean dp[] = new boolean[len + 1];
        dp[len] = true;
        for(int idx = len; idx >= 0; idx--){
            for(String word : wordDict){
                int wordLen = word.length() + idx;
                if(wordLen <= len){
                    String part = s.substring(idx, wordLen);
                    if(word.equals(part)){
                        dp[idx] = dp[wordLen];
                    }
                    if(dp[idx]){
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}
