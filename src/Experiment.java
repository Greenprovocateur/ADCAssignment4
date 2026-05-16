import java.util.*;

public class Experiment {
    private final Random random = new Random();
    private Graph generateRandomGraph(int n) {
        Graph g = new Graph();
        for (int i = 0; i < n; i++) {
            g.addVertex(new Vertex(i));
        }

        // Делаем граф связным (цикл)
        for (int i = 0; i < n; i++) {
            g.addUndirectedEdge(i, (i + 1) % n);
        }

        int targetEdges = (int) (n * 1.5);
        int currentEdges = n;
        while (currentEdges < targetEdges) {
            int u = random.nextInt(n);
            int v = random.nextInt(n);
            if (u == v) continue;
            if (!g.hasEdge(u, v)) {
                g.addUndirectedEdge(u, v);
                currentEdges++;
            }
        }
        return g;
    }


    public void runTraversals(Graph g, boolean printOrder) {
        long start, end;

        start = System.nanoTime();
        if (printOrder) {
            g.bfs(0, true);
        } else {
            g.bfsSilent(0);
        }
        end = System.nanoTime();
        long bfsTime = end - start;

        start = System.nanoTime();
        if (printOrder) {
            g.dfs(0, true);
        } else {
            g.dfsSilent(0);
        }
        end = System.nanoTime();
        long dfsTime = end - start;

        System.out.println("BFS execution time: " + bfsTime + " ns");
        System.out.println("DFS execution time: " + dfsTime + " ns");
    }

    public void runMultipleTests() {
        System.out.println("=== SMALL GRAPH (10 vertices) ===");
        Graph small = generateRandomGraph(10);
        small.printGraph();
        System.out.println("Vertices: " + small.getVertexCount());
        System.out.println("Edges: " + small.getEdgeCount());
        runTraversals(small, true);   // печатаем порядок обхода
        System.out.println();


        System.out.println("=== MEDIUM GRAPH (30 vertices) ===");
        Graph medium = generateRandomGraph(30);
        System.out.println("Vertices: " + medium.getVertexCount());
        System.out.println("Edges: " + medium.getEdgeCount());
        runTraversals(medium, false); // не печатаем порядок
        System.out.println();


        System.out.println("=== LARGE GRAPH (100 vertices) ===");
        Graph large = generateRandomGraph(100);
        System.out.println("Vertices: " + large.getVertexCount());
        System.out.println("Edges: " + large.getEdgeCount());
        runTraversals(large, false);
        System.out.println();
    }

}