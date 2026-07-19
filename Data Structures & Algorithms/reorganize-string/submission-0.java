class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> mapOfCharFreq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mapOfCharFreq.put(ch, mapOfCharFreq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        for (char key : mapOfCharFreq.keySet()) {
            pq.add(new Pair<>(key, mapOfCharFreq.get(key)));
        }

        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            Pair<Character, Integer> pair = pq.poll();
            if(!str.isEmpty() && str.charAt(str.length() - 1) == pair.getKey()){
                if(!pq.isEmpty()){
                    Pair<Character, Integer> nextPair = pq.poll();
                    str.append(nextPair.getKey());
                    int remainingFreq = nextPair.getValue() - 1;
                    if (remainingFreq > 0) {
                        pq.add(new Pair<>(nextPair.getKey(), remainingFreq));
                    }
                    pq.add(pair);
                }else{
                    return "";
                }
            }else{
                str.append(pair.getKey());
                int remainingFreq = pair.getValue() - 1;
                if (remainingFreq > 0) {
                    pq.add(new Pair<>(pair.getKey(), remainingFreq));
                } 
            }
        }
        return str.toString();
    } 
}