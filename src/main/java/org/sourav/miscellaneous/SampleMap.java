package org.sourav.miscellaneous;

public class SampleMap<T> implements Comparable<SampleMap<T>> {

    private T t;

    public void add(T t){
        this.t = t;
    }

    @Override
    public int compareTo(SampleMap<T> o) {
        return 1;
    }
}
