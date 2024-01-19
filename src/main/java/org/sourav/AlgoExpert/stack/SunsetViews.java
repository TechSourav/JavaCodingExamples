package org.sourav.AlgoExpert.stack;

import java.util.*;

public class SunsetViews {

    public static void main(String[] args) {
        //int[] buildings = new int[] {3, 5, 4, 4, 3, 1, 3, 2};
        int[] buildings = new int[] {2, 4};
        String dir = "WEST";
        sunsetViews(buildings, dir);
    }

    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        int index = (direction.equals("EAST")) ? 0 : buildings.length - 1;
        int step = (direction.equals("EAST")) ? 1 : -1;
        Stack<Integer> st = new Stack<>();

        while (index >= 0 && index < buildings.length) {
            if (st.isEmpty()) {
                st.push(index);
                continue;
            }

            int buildingPos = st.peek();
            while (buildings[index] >= buildings[buildingPos]) {
                int x = st.pop();
                System.out.println("popping the building with height: " + buildings[x]);
                if (st.isEmpty())
                    break;
                buildingPos = st.peek();
            }
            st.push(index);
            index = index + step;
        }

        ArrayList<Integer> list = new ArrayList<>(st);
        ArrayList<Integer> reverseList = new ArrayList<>(st);
        Collections.reverse(reverseList);
        ArrayList<Integer> finalList = (direction.equals("EAST")) ? list : reverseList;

        return new ArrayList<>(finalList);
    }

}
