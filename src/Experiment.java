import java.util.Random;

public class Experiment {
    private Graph createGraph(int n) {
        Graph g = new Graph();
        for (int i = 0; i < n; i++) g.addVertex(new Vertex(i));
        for (int i = 0; i < n; i++) {
            g.addEdge(i, (i + 1) % n);
            g.addEdge(i, (i + 2) % n);
        }
        return g;
    }

    public void runTest(int size, boolean printOrder) {
        System.out.println("\n=== Graph with " + size + " vertices ===");
        Graph g = createGraph(size);

        long start = System.nanoTime();
        g.bfs(0);
        long bfsTime = System.nanoTime() - start;

        start = System.nanoTime();
        g.dfs(0);
        long dfsTime = System.nanoTime() - start;

        System.out.printf("BFS time: %d ns\n", bfsTime);
        System.out.printf("DFS time: %d ns\n\n", dfsTime);
    }

    public void runAllTests() {
        runTest(10, true);
        runTest(30, false);
        runTest(100, false);
    }
}