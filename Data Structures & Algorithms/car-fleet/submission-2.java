class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] positionSpeed = new int[len][2];

        for(int idx = 0; idx < len; idx++){
            positionSpeed[idx][0] = position[idx];
            positionSpeed[idx][1] = speed[idx];
        }

        Arrays.sort(positionSpeed, (a, b) -> b[0] - a[0]);
        int fleets = 0;
        double currFleet = 0;

        for(int idx = 0; idx < len; idx++){
            double timeToReachTarget = (double)(target - positionSpeed[idx][0]) / positionSpeed[idx][1];
            if(timeToReachTarget > currFleet){
                fleets++;
                currFleet = timeToReachTarget;
            }
        }
        return fleets;
    }
}
