package com.demos.leetcode;

import java.util.*;

public class CourseSchedule {

    //Solution 1 : Brute force : Detect cycles in a directed graph

//    List<Integer> beingVisited = new ArrayList<>();
//    List<Integer> visited = new ArrayList<>();
//
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        List<List<Integer>> adjList = new ArrayList<>();
//        for (int i = 0; i < numCourses; i++) {
//            adjList.add(new ArrayList<>());
//        }
//
//        for (int[] prerequisite : prerequisites) {
//            adjList.get(prerequisite[0]).add(prerequisite[1]);
//        }
//        if(prerequisites.length == 0) return true;
//        return !hasCycle(adjList);
//    }
//
//    private boolean hasCycle(Integer course,  List<List<Integer>> adjList) {
//
//        beingVisited.add(course);
//
//        for (Integer neighbor : adjList.get(course)) {
//            if (beingVisited.contains(neighbor)) {
//                // backward edge exists
//                return true;
//            } else if (!visited.contains(neighbor) && hasCycle(neighbor, adjList)) {
//                return true;
//            }
//        }
//
//        beingVisited.remove(course);
//        visited.add(course);
//        return false;
//    }
//    private boolean hasCycle(List<List<Integer>> adjList) {
//        int i = 0;
//        while (i < adjList.size()){
//            if(!adjList.get(i).isEmpty() && !visited.contains(i) && hasCycle(i, adjList)) return true;
//            i++;
//        }
//        return false;
//    }

    //Using Kahn's algorithm
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        // Array to store indegree of each vertex
        int[] indegree = new int[numCourses];

        //Initialize our adj list with empty lists
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        //Populate adj list with edges represented by course prerequisites provided
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            //increment indegree count for a vertex which has a dependency i.e a course which has a prereq
            indegree[p[0]]++;
        }
        // Queue to store vertices with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        int[] visited = new int[numCourses];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[count++] = cur;

            // Decrease indegree of adjacent vertices as the
            // current node is in topological order
            for(int c : adj.get(cur)) {
                indegree[c]--;

                // If indegree becomes 0, push it to the
                // queue
                if (indegree[c] == 0) {
                    queue.offer(c);
                }
            }
        }
        //System.out.println(Arrays.toString(visited));
        //Check for cycle
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        System.out.println(new CourseSchedule().canFinish(20, prerequisites));
    }


}
