class Solution {
    public static int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int asteroid : asteroids) {
            if (asteroid < 0) {
                if (list.isEmpty() || list.peekLast() < 0) {
                    list.addLast(asteroid);
                } else {
                    // while peekLast is positive number
                    while (list.peekLast() <= -asteroid) {
                        // Once existing "add", break. Go next asteroid.
                        if (list.peekLast() < 0) {
                            list.addLast(asteroid);
                            break;
                        } else if (list.pollLast() == -asteroid) { // pop last element. If equal, all collisions
                            break;
                        }

                        if (list.isEmpty()){
                            list.addLast(asteroid);
                            break;
                        }
                    }
                }
            } else list.addLast(asteroid); // just add it
        }

        if (list.isEmpty()) return new int[]{};
        else {
            int[] result = new int[list.size()];
            int i = 0;
            while (!list.isEmpty()) {
                result[i++] = list.pollFirst();
            }
            return result;
        }
    }
}