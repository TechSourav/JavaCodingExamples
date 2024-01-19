package org.sourav.Leetcode;

import java.util.*;

public class RandomizedSet {

    Map<Integer, Integer> dict;
    List<Integer> list;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.dict = new HashMap();
        this.list = new ArrayList();
    }

    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (!this.dict.containsKey(val)) {
            return false;
        }
        int lastElem = this.list.get(list.size() - 1);
        int idx = this.dict.get(val);
        this.list.set(idx, lastElem);
        this.dict.put(lastElem, idx);
        this.list.remove(list.size() - 1);
        this.dict.remove(val);
        return true;
    }

    public int getRandom() {
        return this.list.get(rand.nextInt(this.list.size()));
    }

}
