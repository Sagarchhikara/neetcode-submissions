class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int current : asteroids) {
            boolean alive = true;

            while (!st.isEmpty() && st.peek() > 0 && current < 0) {

                if (Math.abs(st.peek()) < Math.abs(current)) {
                    st.pop();
                }
                else if (Math.abs(st.peek()) == Math.abs(current)) {
                    st.pop();
                    alive = false;
                    break;
                }
                else {
                    alive = false;
                    break;
                }
            }

            if (alive) {
                st.push(current);
            }
        }

        return st.stream()
                 .mapToInt(Integer::intValue)
                 .toArray();
    }
}