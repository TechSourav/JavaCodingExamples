package org.sourav.Leetcode.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

import lombok.Data;

public class ExecutionTime {

    public static int[] exclusiveTime(int n, List<String> logs) {
        final Stack<Event> stack = new Stack<>();
        int[] ans = new int[n];

        for (final String content: logs) {
            final Event event = new Event(content);
            if (event.isStart()) {
                stack.push(event);
            } else {
                final Event top = stack.pop();
                final int totalTime = event.getTime() - top.getTime() + 1;

                ans[top.getId()] += totalTime;

                // This is because we have to calculate the total time of the stack.peek() log based on the entire timeframe
                if (!stack.isEmpty()) {
                    ans[stack.peek().getId()] -= totalTime;
                }
            }
        }

        return ans;
    }

    // Driver code
    public static void main(String args[]) {
        List<List<String>> events = Arrays.asList(
            Arrays.asList("0:start:0", "1:start:2", "1:end:3", "2:start:4", "2:end:7", "0:end:8"),
            Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"),
            Arrays.asList("0:start:0", "1:start:5", "1:end:6", "0:end:7"),
            Arrays.asList("0:start:0", "1:start:5", "2:start:8", "3:start:12", "4:start:15", "5:start:19", "5:end:22", "4:end:24", "3:end:27", "2:end:32", "1:end:35", "0:end:36"),
            Arrays.asList("0:start:0", "1:start:3", "1:end:6", "0:end:10")
        );
        List<Integer> n = Arrays.asList(3, 2, 2, 6, 2);
        int x = 1;
        for (int i = 0; i<n.size(); i++) {
            System.out.println(x + ".\tn = " + n.get(i));
            System.out.println("\tevents = " + events.get(i));
            System.out.println("\tOutput: " + Arrays.toString(exclusiveTime(n.get(i), events.get(i))));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            x += 1;
        }
    }
}

@Data
class Event {
    private int id;
    private boolean isStart;
    private int time;

    public Event(String content) {
        String[] strs = content.split(":");
        this.id = Integer.valueOf(strs[0]);
        this.isStart = strs[1].equals("start");
        this.time = Integer.valueOf(strs[2]);
    }
}