import java.util.*;

public class Graph {
    private final Map<Integer, Vertex> vertices = new HashMap<>();
    private final Map<Integer, List<Integer>> adj = new HashMap<>();
    private final List<Edge> edges = new ArrayList<>();

    public void addVertex(Vertex v) {
        int id = v.getId();
        vertices.put(id, v);
        adj.put(id, new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        adj.get(from).add(to);
        edges.add(new Edge(from, to));
    }

    public void addUndirectedEdge(int from, int to) {
        addEdge(from, to);
        addEdge(to, from);
    }

    public boolean hasEdge(int u, int v) {
        return adj.getOrDefault(u, Collections.emptyList()).contains(v);
    }

    public void printGraph() {
        for (int id : adj.keySet()) {
            System.out.print(id + ": ");
            for (int nb : adj.get(id)) {
                System.out.print(nb + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start, boolean printOrder) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        if (printOrder) System.out.print("BFS order: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (printOrder) System.out.print(vertices.get(current) + " ");
            for (int neighbor : adj.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        if (printOrder) System.out.println();
    }

    public void dfs(int start, boolean printOrder) {
        Set<Integer> visited = new HashSet<>();
        if (printOrder) System.out.print("DFS order: ");
        dfsRecursive(start, visited, printOrder);
        if (printOrder) System.out.println();
    }

    private void dfsRecursive(int v, Set<Integer> visited, boolean printOrder) {
        visited.add(v);
        if (printOrder) System.out.print(v + " ");
        for (int neighbor : adj.get(v)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, printOrder);
            }
        }
    }

    public void bfsSilent(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adj.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public void dfsSilent(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsSilentRecursive(start, visited);
    }

    private void dfsSilentRecursive(int v, Set<Integer> visited) {
        visited.add(v);
        for (int neighbor : adj.get(v)) {
            if (!visited.contains(neighbor)) {
                dfsSilentRecursive(neighbor, visited);
            }
        }
    }

    public int getVertexCount() {
        return vertices.size();
    }

    public int getEdgeCount() {
        return edges.size() / 2; //
    }
}
