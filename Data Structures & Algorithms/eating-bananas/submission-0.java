class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = 0;
        for(int pile : piles){
            end = Math.max(pile, end);
        }
        int res = 0;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(rateOfEating(mid, piles) > h){
                start = mid + 1;
            }else{
                res = mid;
                end = mid - 1;
            }
        }
        return res;
    }

    public int rateOfEating(int mid, int[] piles){
        int rate = 0;
        for(int pile :piles){
            rate += pile/mid;
            if(pile % mid != 0){
                rate++;
            }
        }
        return rate;
    }
}
