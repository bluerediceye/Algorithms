package com.algorithms.amazon9.sde2;

import java.util.*;

/**
 * Created on 19/04/2017
 *
 * @author Ming Li
 */
public class Dijkstra2 {

    static class Vertex {
        String id;

        public Vertex(String id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex vertex = (Vertex) o;

            return id != null ? id.equals(vertex.id) : vertex.id == null;
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }

        @Override
        public String toString() {
            return id;
        }
    }

    static class Edge {
        String id;
        int weight;
        Vertex source;
        Vertex destination;

        public Edge( Vertex source, Vertex destination, int weight) {
            this.weight = weight;
            this.source = source;
            this.destination = destination;
        }
    }

    static class Graph {
        List<Vertex> vertices;
        List<Edge> edges;

        public Graph(List<Vertex> vertices, List<Edge> edges) {
            this.vertices = vertices;
            this.edges = edges;
        }
    }

    private Map<Vertex, Integer> distances;
    private Map<Vertex, Vertex> predecessors;
    private List<Vertex> unsortedVertices;
    private List<Vertex> sortedVertices;

    private Graph graph;

    public Dijkstra2(Graph graph) {
        this.graph = graph;
    }

    public void calculate(Vertex source){
        distances = new HashMap<>();
        predecessors = new HashMap<>();
        for(Vertex vertex : graph.vertices){
            distances.put(vertex, Integer.MAX_VALUE);
            predecessors.put(vertex, null);
        }

        sortedVertices = new ArrayList<>() ;
        unsortedVertices = new ArrayList<>() ;
        distances.put(source, 0);
        unsortedVertices.add(source);

        while(!unsortedVertices.isEmpty()){
            Vertex candidate = getMinimal(unsortedVertices);
            sortedVertices.add(candidate);
            unsortedVertices.remove(candidate);
            recalculateDistances(candidate);
        }
    }

    private void recalculateDistances(Vertex candidate) {

        for(Edge edge : graph.edges){
            if(edge.source == candidate && !sortedVertices.contains(edge.destination)){

                if(distances.get(edge.destination) > distances.get(edge.source) + edge.weight){
                    unsortedVertices.add(edge.destination);
                    predecessors.put(edge.destination, edge.source);
                    distances.put(edge.destination, distances.get(edge.source) + edge.weight);
                }
            }
        }

    }

    private Vertex getMinimal(List<Vertex> unsortedVertices) {
        Vertex min = null;
        int minDist = Integer.MAX_VALUE;
        for(Vertex vertex : unsortedVertices){
             if(minDist > distances.get(vertex)){
                 minDist = distances.get(vertex);
                 min = vertex;
             }
        }
        return min;
    }

    public LinkedList<Vertex> getPath(Vertex target){
        LinkedList<Vertex> path = new LinkedList<>();
        path.add(target);
        Vertex v = predecessors.get(target);
        while(v != null){
            path.add(v);
            v = predecessors.get(v);
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(a, b, 1));
        edges.add(new Edge(a, c, 3));
        edges.add(new Edge(a, d, 5));
        edges.add(new Edge(b, d, 2));
        edges.add(new Edge(b, e, 2));
        edges.add(new Edge(c, e, 2));
        edges.add(new Edge(c, e, 1));
        edges.add(new Edge(d, e, 3));

        Graph graph = new Graph(vertices, edges);

        Dijkstra2 dijkstra = new Dijkstra2(graph);
        dijkstra.calculate(a);
        for(Vertex v : vertices){
            print(dijkstra.getPath(v), dijkstra.distances);
        }
    }

    public static void print(LinkedList<Vertex> vertices, Map<Vertex, Integer> distances) {
        System.out.print(vertices.getLast() + "(" + distances.get(vertices.getLast()) + ")"+ ": ");
        for(Vertex v: vertices){
            System.out.print(v.id + ((vertices.getLast() == v)? "" :"->"));
        }
        System.out.println();
    }

}
