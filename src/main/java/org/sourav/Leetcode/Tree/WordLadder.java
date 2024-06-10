package org.sourav.Leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

public class WordLadder {

    public static void main(String[] args) {
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength2("hit","cog", wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach( word -> {
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(Pair.of(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(Pair.of(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair2> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        q.offer(new Pair2(beginWord,1));

        for(String s : wordList)
            set.add(s);
        set.remove(beginWord);

        while(!q.isEmpty()){
            String currStr = q.peek().str;
            int currCount = q.peek().count;
            q.poll();
            int len = currStr.length();

            if(currStr.equals(endWord))
                return currCount;

            for( int i=0 ; i<len ; i++){
                for(char ch='a' ; ch<='z' ;ch++){
                    String temp = currStr.substring(0,i) + ch + currStr.substring(i+1);
                    if(set.contains(temp)){
                        set.remove(temp);
                        q.offer(new Pair2(temp , currCount+1));
                    }
                }
            }
        }

        return 0;
    }
}

class Pair2{
    String str;
    int count;
    Pair2(String str,int count){
        this.str = str;
        this.count = count;
    }
}
