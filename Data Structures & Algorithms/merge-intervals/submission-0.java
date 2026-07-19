class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int idx = 0;
        int len = intervals.length;
        List<int[]> result = new ArrayList<>();

        int start = intervals[idx][0];
        int end = intervals[idx][1];

        idx++;

        while(idx < len){
            if(intervals[idx][0] <= end){
                start = Math.min(start, intervals[idx][0]);
                end = Math.max(end, intervals[idx][1]);
            }else{
                result.add(new int[]{start, end});
                start = intervals[idx][0];
                end = intervals[idx][1];
            }
            idx++;
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }
}
