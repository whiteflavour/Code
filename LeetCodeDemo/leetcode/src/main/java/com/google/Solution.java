package com.google;

import java.util.*;

public class Solution {
    private List<List<Integer>> edges;
    private int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        indeg = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            edges.get(p[1]).add(p[0]);
            ++indeg[p[0]];
        }

        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int v = queue.poll();
            for (int next : edges.get(v)) {
                --indeg[next];
                if (indeg[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return visited == numCourses;
    }
}