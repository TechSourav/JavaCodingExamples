package org.sourav.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static void main(String[] args) {
        List<Object> test = new ArrayList<>(Arrays.asList(
            5,
            2,
            new ArrayList<Object>(Arrays.asList(7, -1)),
            3,
            new ArrayList<Object>(
                Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4)
            )
        ));
        System.out.println(productSum(test, 1));
    }

    public static int productSum(List<Object> array, int depth) {
        int sum = 0;
        for (Object element : array) {
            sum += element instanceof ArrayList ? productSum((ArrayList<Object>)element, depth + 1) : (int)element;
        }

        return sum * depth;
    }

}
