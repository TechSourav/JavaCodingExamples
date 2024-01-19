package org.sourav.AlgoExpert.stack;

import java.util.Stack;

public class CollidingAstroid {

    public static void main(String[] args) {
        System.out.println(collidingAsteroids(new int[] {4, -4}));
    }

    public static int[] collidingAsteroids(int[] asteroids) {
        if (asteroids.length == 1)
            return asteroids;

        Stack<Integer> st = new Stack<>();
        int size = asteroids.length;

        for (int i = 0; i < size;) {
            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
                i++;
                continue;
            }
            while (!st.isEmpty()) {
                int a = st.peek();
                if (a < 0) {
                    st.push(asteroids[i]);
                    i++;
                    break;
                } else if (a > 0) {
                    if (Math.abs(a) < Math.abs(asteroids[i])) {
                        st.pop();
                    } else if (Math.abs(a) > Math.abs(asteroids[i])) {
                        i++;
                        break;
                    } else if (Math.abs(a) == Math.abs(asteroids[i])) {
                        st.pop();
                        i++;
                        break;
                    }
                }
            }
            if (st.empty() && i < size) {
                st.push(asteroids[i]);
                i++;
            }
        }


        /*int asteroid0 = asteroids[0];
        int asteroid1 = asteroids[1];

        if (asteroid0 < 0 && asteroid1 < 0) {
            st.push(asteroid0);
            st.push(asteroid1);
        } else if (asteroid0 < 0 && asteroid1 > 0) {
            st.push(asteroid0);
            st.push(asteroid1);
        } else if (asteroid0 > 0 && asteroid1 < 0) {
            if (Math.abs(asteroid0) < Math.abs(asteroid1)) {
                st.push(asteroid1);
            } else if (Math.abs(asteroid0) > Math.abs(asteroid1)) {
                st.push(asteroid0);
            }
        } else if (asteroid0 > 0 && asteroid1 > 0) {
            st.push(asteroid0);
            st.push(asteroid1);
        }

        if (asteroids.length > 2) {
            for (int i = 2; i < asteroids.length; i++) {
                int astroid = st.peek();
                while (!st.isEmpty() && astroid > 0 && asteroids[i] < 0) {
                    if (astroid > 0 && asteroids[i] < 0) { // collide
                        if (Math.abs(astroid) < Math.abs(asteroids[i])) {
                            st.pop();
                            st.push(asteroids[i]);
                        } else if (Math.abs(astroid) == Math.abs(asteroids[i])) {
                            st.pop();
                        }
                    } else {
                        st.push(asteroids[i]);
                    }
                    astroid = st.peek();
                }
            }
        }
*/

        return st.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


}
