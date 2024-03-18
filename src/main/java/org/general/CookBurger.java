package org.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CookBurger {

    private static Map<String, Integer> BURGER_MAP = Map.of("bread", 1, "cheese", 1, "ham", 1);

    public static void main (String[] args) {
        System.out.println("Hello World!");
        List<String> ingredients = Arrays.asList("bread", "bread", "bread", "ham", "cheese", "ham", "ham", "cheese");
        cookBurger(ingredients);
    }

    private static void cookBurger(List<String> ingredients) {
        //String[] buger = {"bread", "chese", "ham"};
        Map<String, Integer> burgermapTemp = new HashMap<>(BURGER_MAP);

        final Map<String, Integer> storageMap = new HashMap<>();

        // for output
        Map<String, Integer> ans = new HashMap<>();

        int matched = 0;

        for (int i = 0; i < ingredients.size(); i++) {

            String currIngredient =  ingredients.get(i);

            if (burgermapTemp.containsKey(currIngredient) && burgermapTemp.get(currIngredient) > 0) {
                int count1 = storageMap.getOrDefault(currIngredient, 0) + 1;
                storageMap.put(currIngredient, count1);

                // string the count of the each ingredient as received.
                ans.put(currIngredient, Math.max(ans.getOrDefault(currIngredient, 0), count1));

                burgermapTemp.put(currIngredient, burgermapTemp.get(currIngredient) - 1);
                matched++;
            } else {
                int count2 = storageMap.getOrDefault(currIngredient, 0) + 1;
                storageMap.put(currIngredient, count2);
                ans.put(currIngredient, Math.max(ans.getOrDefault(currIngredient, 0), count2));
            }

            // if all ingredients found.
            if (matched == burgermapTemp.size()) {
                while (matched > 0) {
                    for (Map.Entry<String, Integer> entry : burgermapTemp.entrySet()) {
                        String key = entry.getKey();
                        storageMap.put(key, storageMap.get(key) - 1);
                        matched--;
                    }
                }

                // Refill the temp map.
                BURGER_MAP.entrySet().forEach(e -> {
                    burgermapTemp.put(e.getKey(), e.getValue());
                });
            }

        }

        // print final output
        ans.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " : "+ e.getValue());
        });
    }
}
