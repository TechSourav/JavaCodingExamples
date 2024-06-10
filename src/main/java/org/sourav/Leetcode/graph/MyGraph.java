package org.sourav.Leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MyGraph {

    public static void main(String[] args) {
        Graph graph = Graph.createGraph(new Graph());

        System.out.println(graph.getAdjVertices("Rob"));
    }

}

@Data
@NoArgsConstructor
class Graph {
    private Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();
    private Vertex vertex;

    public void addVertex(String val) {
        this.adjVertices.putIfAbsent(new Vertex(val), new ArrayList<>());
    }

    public void removeVertex(String val) {
        Vertex v = new Vertex(val);
        this.adjVertices.values().forEach(vr -> vr.remove(v));
        this.adjVertices.remove(v);
    }

    public void addEdge(String val1, String val2) {
        Vertex v1 = new Vertex(val1);
        Vertex v2 = new Vertex(val2);
        this.adjVertices.get(v1).add(v2);
        this.adjVertices.get(v2).add(v1);
    }

    public void removeEdge(String val1, String val2) {
        Vertex v1 = new Vertex(val1);
        Vertex v2 = new Vertex(val2);
        List<Vertex> vs1 = this.adjVertices.get(v1);
        List<Vertex> vs2 = this.adjVertices.get(v2);
        if (vs1 != null) {
            vs1.remove(v2);
        }
        if (vs2 != null) {
            vs2.remove(v1);
        }
    }

    List<Vertex> getAdjVertices(String label) {
        return this.adjVertices.get(new Vertex(label));
    }

    static Graph createGraph(Graph graph) {
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }
}

@Data
@Builder
class Vertex {
    private String label;
    Vertex(String label) {
        this.label = label;
    }
}