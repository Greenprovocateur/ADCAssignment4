import java.util.*;

public class Graph {
    private final Map<Integer, Vertex> vertices = new HashMap<>();
    private final Map<Integer, List<Integer>> adj = new HashMap<>();

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adj.put(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        adj.get(from).add(to);
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        System.out.print("BFS order: ");
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(vertices.get(v) + " ");
            for (int nb : adj.get(v))
                if (!visited.contains(nb)) {
                    visited.add(nb);
                    queue.add(nb);
                }
        }
        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS order: ");
        dfsRec(start, visited);
        System.out.println();
    }

    private void dfsRec(int v, Set<Integer> visited) {
        visited.add(v);
        System.out.print(vertices.get(v) + " ");
        for (int nb : adj.get(v))
            if (!visited.contains(nb))
                dfsRec(nb, visited);
    }
}
