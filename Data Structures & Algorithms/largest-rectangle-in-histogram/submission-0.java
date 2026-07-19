class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for (int idx = 0; idx < heights.length; idx++) {
            int start = idx;
            while (!stack.isEmpty() && stack.peek()[1] > heights[idx]) {
                int[] pair = stack.pop();
                int width = idx - pair[0];
                maxArea = Math.max(maxArea, width * pair[1]);
                start = pair[0];
            }
            stack.push(new int[]{start, heights[idx]});
        }
        for (int pair[] : stack) {
            int width = heights.length - pair[0];
            maxArea = Math.max(maxArea, pair[1] * width);
        }
        return maxArea;
    }
}
