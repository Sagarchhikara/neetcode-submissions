class Solution {
    public int lastStoneWeight(int[] stones) {

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones
        for (int stone : stones) {
            pq.add(stone);
        }

        // Keep smashing while we have at least 2 stones
        while (pq.size() >= 2) {

            int x = pq.poll();  // largest
            int y = pq.poll();  // second largest

            // If they are different, put the difference back
            if (x != y) {
                pq.add(x - y);
            }
        }

        // Either one stone remains or none
        return pq.isEmpty() ? 0 : pq.peek();
    }
}