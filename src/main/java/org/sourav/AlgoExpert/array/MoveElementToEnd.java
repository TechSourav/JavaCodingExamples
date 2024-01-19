package org.sourav.AlgoExpert.array;

import java.util.ArrayList;
import java.util.List;

public class MoveElementToEnd {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);
        System.out.println(moveElementToEnd(list, 2));
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        if (array.size() == 1) {
            return array;
        }

        int moveToIndx = 0;
        for (int i = 0; i< array.size(); i++) {
            if (array.get(i) != toMove) {
                int temp = array.get(moveToIndx);
                array.set(moveToIndx, array.get(i));
                array.set(i, temp);
                moveToIndx++;
            }
        }
        return array;
    }

}
