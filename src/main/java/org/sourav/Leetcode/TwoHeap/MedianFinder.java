package org.sourav.Leetcode.TwoHeap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(3);
        mf.addNum(2);
        mf.addNum(7);
        System.out.println("Median of 2,3,7 is : " + mf.findMedian());
        mf.addNum(4);
        mf.addNum(1);
        System.out.println("Median of 1,2,3,4,7 is : " + mf.findMedian());
    }

    public void addNum(int num) {
        if(maxHeap.size()==minHeap.size()){
            minHeap.add(num);
            maxHeap.add(minHeap.remove());
        }
        else{
            maxHeap.add(num);
            minHeap.add(maxHeap.remove());
        }

    }

    public double findMedian() {

        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
        return maxHeap.peek()/1.0;

    }

}
