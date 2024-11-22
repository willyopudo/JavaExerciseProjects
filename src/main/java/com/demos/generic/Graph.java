package com.demos.generic;

import java.util.*;

public class Graph {
    private final Map<Integer, List<Integer>> adjacencyList;
    private final boolean isDirected;

    // Constructor
    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        this.adjacencyList = new HashMap<>();
    }

    // Add a vertex
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge
    public void addEdge(int source, int destination) {
        addVertex(source); // Ensure the source vertex exists
        addVertex(destination); // Ensure the destination vertex exists
        adjacencyList.get(source).add(destination);

        // If the graph is undirected, add the reverse edge
        if (!isDirected) {
            adjacencyList.get(destination).add(source);
        }
    }

    // Remove an edge
    public void removeEdge(int source, int destination) {
        List<Integer> sourceNeighbors = adjacencyList.get(source);
        if (sourceNeighbors != null) {
            sourceNeighbors.remove((Integer) destination);
        }

        // If the graph is undirected, remove the reverse edge
        if (!isDirected) {
            List<Integer> destinationNeighbors = adjacencyList.get(destination);
            if (destinationNeighbors != null) {
                destinationNeighbors.remove((Integer) source);
            }
        }
    }

    // Remove a vertex
    public void removeVertex(int vertex) {
        adjacencyList.remove(vertex);

        // Remove the vertex from other adjacency lists
        for (List<Integer> neighbors : adjacencyList.values()) {
            neighbors.remove((Integer) vertex);
        }
    }

    // Get all vertices
    public Set<Integer> getVertices() {
        return adjacencyList.keySet();
    }

    // Get neighbors of a vertex
    public List<Integer> getNeighbors(int vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    // Print the graph
    public void printGraph() {
        for (int vertex : adjacencyList.keySet()) {
            System.out.print(vertex + " -> ");
            System.out.println(adjacencyList.get(vertex));
        }
    }

    // Check if the graph is directed
    public boolean isDirected() {
        return isDirected;
    }

    public static Set<Integer> depthFirstTraversal(Graph graph, int root) {
        Set<Integer> visited = new LinkedHashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (int v : graph.getNeighbors(vertex)) {
                    stack.push(v);
                }
            }
        }
        return visited;
    }

    public static Set<Integer> breadthFirstTraversal(Graph graph, int root) {
        Set<Integer> visited = new LinkedHashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int v : graph.getNeighbors(vertex)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        // Create a graph
        Graph graph = new Graph(false); // Change to true for a directed graph

        // Add edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addVertex(6);
        graph.addEdge(6, 3);

        // Print the graph
        System.out.println("Graph:");
        graph.printGraph();

        //DFS traversal
        System.out.println("Depth First Traversal:");
        System.out.println(Graph.depthFirstTraversal(graph, 2).toString());

        //BFS traversal
        System.out.println("Breadth First Traversal:");
        System.out.println(Graph.breadthFirstTraversal(graph, 2).toString());

        // Get neighbors
        System.out.println("Neighbors of 2: " + graph.getNeighbors(2));

        // Remove an edge
        graph.removeEdge(1, 3);
        System.out.println("After removing edge 1 -> 3:");
        graph.printGraph();

        // Remove a vertex
        graph.removeVertex(4);
        System.out.println("After removing vertex 4:");
        graph.printGraph();
    }
}

