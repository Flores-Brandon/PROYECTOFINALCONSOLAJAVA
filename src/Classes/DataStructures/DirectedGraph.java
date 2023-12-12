/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DataStructures;
import java.util.*;
/**
 *
 * @author andre
 */
public class DirectedGraph<T> {
    private Map<T, List<T>> adjacencyList;

    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Añade un vértice al grafo dirigido
    public void AddVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
            System.out.println("Vertex " + vertex + " added to the graph.");
            return;
        }

        System.out.println("Vertex " + vertex + " already exists in the graph.");
    }

    // Elimina un vértice y todas las aristas salientes asociadas
    public void RemoveVertex(T vertex) {
        if (adjacencyList.containsKey(vertex)) {
            adjacencyList.remove(vertex);
            System.out.println("Vertex " + vertex + " removed from the graph.");

            for (T otherVertex : adjacencyList.keySet()) {
                adjacencyList.get(otherVertex).remove(vertex);
            }
            return;
        }
        System.out.println("Vertex " + vertex + " does not exist in the graph.");
    }

    // Añade una arista dirigida desde vertexStart a vertexEnd
    public void AddEdge(T vertexStart, T vertexEnd) {
        if (adjacencyList.containsKey(vertexStart) && adjacencyList.containsKey(vertexEnd)) {
            adjacencyList.get(vertexStart).add(vertexEnd);
            System.out.println("Directed edge added from " + vertexStart + " to " + vertexEnd + ".");
            return;
        }
        System.out.println("Vertices " + vertexStart + " or " + vertexEnd + " do not exist in the graph.");
    }

    // Elimina una arista dirigida desde vertexStart a vertexEnd
    public void RemoveEdge(T vertexStart, T vertexEnd) {
        if (adjacencyList.containsKey(vertexStart) && adjacencyList.containsKey(vertexEnd)) {
            adjacencyList.get(vertexStart).remove(vertexEnd);
            System.out.println("Directed edge removed from " + vertexStart + " to " + vertexEnd + ".");
            return;
        }
        System.out.println("Vertices " + vertexStart + " or " + vertexEnd + " do not exist in the graph.");
    }

    // Comprueba la existencia de un vértice en el grafo dirigido
    public boolean VertexExists(T vertex) {
        boolean exists = adjacencyList.containsKey(vertex);
        System.out.println("Vertex " + vertex + " exists in the graph: " + exists + ".");
        return exists;
    }

    // Comprueba la existencia de una arista dirigida desde vertexStart a vertexEnd
    public boolean EdgeExists(T vertexStart, T vertexEnd) {
        boolean exists = adjacencyList.containsKey(vertexStart) && adjacencyList.get(vertexStart).contains(vertexEnd);
        System.out.println("Directed edge from " + vertexStart + " to " + vertexEnd + " exists: " + exists + ".");
        return exists;
    }

    // Obtiene todos los vértices en el grafo dirigido
    public List<T> GetAllVertices() {
        List<T> vertices = new ArrayList<>(adjacencyList.keySet());
        System.out.println("All vertices in the graph: " + String.join(", ", vertices.toString()));
        return vertices;
    }

    // Obtiene todas las aristas dirigidas en el grafo
    public List<Pair<T, T>> GetAllEdges() {
        List<Pair<T, T>> edges = new ArrayList<>();

        for (T vertex : adjacencyList.keySet()) {
            for (T neighbor : adjacencyList.get(vertex)) {
                edges.add(new Pair<>(vertex, neighbor));
            }
        }

        System.out.println("All directed edges in the graph: " + edges);
        return edges;
    }

    // Recorre el grafo dirigido usando BFS
    public List<T> TraverseBFS(T startVertex) {
        List<T> visited = new ArrayList<>();
        var queue = new LinkedList<>();

        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Vertex " + startVertex + " does not exist in the graph.");
            return visited;
        }

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            T currentVertex = (T) queue.poll();

            for (T neighbor : adjacencyList.get(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("BFS traversal result: " + visited);
        return visited;
    }

    // Calcula el grado de salida de un vértice en el grafo dirigido
    public int CalculateDegree(T vertex) {
        int outDegree = adjacencyList.containsKey(vertex) ? adjacencyList.get(vertex).size() : -1;
        System.out.println("Out-degree of vertex " + vertex + ": " + outDegree + ".");
        return outDegree;
    }

    // Calcula el ancho del grafo dirigido y el nivel en el que se encuentra un nodo
    public Map<T, Integer> CalculateBFSLevels(T startVertex) {
        Map<T, Integer> levels = new HashMap<>();
        var queue = new LinkedList<>();

        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Vertex " + startVertex + " does not exist in the graph.");
            return levels;
        }

        levels.put(startVertex, 0);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            T currentVertex = (T)queue.poll();

            for (T neighbor : adjacencyList.get(currentVertex)) {
                if (!levels.containsKey(neighbor)) {
                    levels.put(neighbor, levels.get(currentVertex) + 1);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("BFS levels: " + levels);
        return levels;
    }

    private static class Pair<X, Y> {
        X first;
        Y second;

        public Pair(X first, Y second) {
            this.first = first;
            this.second = second;
        }
    }
}
