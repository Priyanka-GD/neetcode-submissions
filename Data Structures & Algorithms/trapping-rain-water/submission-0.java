class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int left[] = new int[len];
        int right[] = new int[len];
        left[0] = height[0];

        for(int idx = 1; idx < len; idx++){
            left[idx] = Math.max(left[idx - 1], height[idx]);
        }

        right[len - 1] = height[len - 1];
        for(int idx = len - 2; idx >= 0; idx--){
            right[idx] = Math.max(right[idx + 1], height[idx]);
        }

        int trappedWater = 0;
        for(int idx = 0; idx < len; idx++){
            int units = Math.min(left[idx], right[idx]);
            trappedWater += units - height[idx];
        }
        return trappedWater;
    }
}
