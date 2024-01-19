package org.sourav.AlgoExpert.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TournamentWinner {

    public static void main(String[] args) {
        List<Integer> results = Arrays.asList(0,1,1);

        List<String> com1 = Arrays.asList("HTML", "Java");
        List<String> com2 = Arrays.asList("Java", "Python");
        List<String> com3 = Arrays.asList("Python", "HTML");

        ArrayList<List<String>> competitions = new ArrayList<>();
        competitions.add(com1);
        competitions.add(com2);
        competitions.add(com3);

        System.out.println(tournamentWinner(competitions, results));

    }
    public static String tournamentWinner(final ArrayList<List<String>> competitions, List<Integer> results) {
            Map<String, Integer> tree = new TreeMap<>();
            int i = 0;

            for (List<String> comp : competitions) {
                int res = results.get(i);
                if (res == 0) {
                    Integer count = tree.get(comp.get(1));
                    if(count == null){
                        count = 0;
                    }
                    tree.put(comp.get(1), count + 3);
                }
                if (res == 1) {
                    Integer count = tree.get(comp.get(0));
                    if(count == null){
                        count = 0;
                    }
                    tree.put(comp.get(0), count + 3);
                }
                i++;
            }

            NavigableMap<String, Integer> map = new TreeMap<>(Comparator.comparing(tree::get));
            map.putAll(tree);

            return map.lastKey();
    }

}
