// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> result = new ArrayList<>();
        if(pairs.size() == 0)
            return result;
        result.add(new ArrayList<>(pairs));
        // Perform the insertion sort, step by step, adding snapshots of the list to the result
        for (int i = 1; i < pairs.size(); i++) {
            Pair current = pairs.get(i);
            int j = i - 1;

            // Shift elements that are greater than the current key to the right
            while (j >= 0 && pairs.get(j).key > current.key) {
                pairs.set(j + 1, pairs.get(j));
                j--;
            }
            // Insert the current pair at the correct position
            pairs.set(j + 1, current);

            // Take a snapshot of the current state of the list and add it to the result
            result.add(new ArrayList<>(pairs));
        }
        return result;
    }
}
