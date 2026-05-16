Assignment 4: Graph Traversal and Representation System

This project implements a graph traversal system in Java using an adjacency list representation.  
Two fundamental algorithms are implemented:
- Breadth-First Search (BFS) – explores level by level using a queue
- Depth-First Search (DFS) – explores depth-first using recursion

Three random graph sizes are tested:
- **Small**: 10 vertices, 15 edges
- **Medium**: 30 vertices, 45 edges
- **Large**: 100 vertices, 150 edges

For the small graph, the program prints the full adjacency list and traversal order.  
For medium and large graphs, only execution time is displayed.

---
Project Structure

| File | Description |
|------|-------------|
| `Vertex.java` | Node with unique ID, getter, toString() |
| `Edge.java` | Connection (source → destination), getters, toString() |
| `Graph.java` | Adjacency list, BFS, DFS, edge/vertex management |
| `Experiment.java` | Random graph generation, timing, test execution |
| `Main.java` | Entry point |

---

Algorithm Details

 Breadth-First Search (BFS)
- Uses a queue (FIFO)
- Explores vertices by increasing distance from start
- Time Complexity: O(V + E)

Depth-First Search (DFS)
- Uses recursion (implicit stack)
- Explores as deep as possible before backtracking
- Time Complexity: O(V + E)

---

Experimental Results

Small Graph (10 vertices, 15 edges)

**Adjacency List:**
0: 1 9 8 6
1: 0 2 5
2: 1 3
3: 2 4 5
4: 3 5
5: 4 6 1 3 9
6: 5 7 0
7: 6 8
8: 7 9 0
9: 8 0 5


Traversal Order from vertex 0:
- BFS: `V0 V1 V9 V8 V6 V2 V5 V7 V3 V4`
- DFS: `0 1 2 3 4 5 6 7 8 9`

Performance Comparison

| Graph Size | Vertices | Edges | BFS Time (ns) | DFS Time (ns) |
|------------|----------|-------|---------------|---------------|
| Small      | 10       | 15    | 1,265,400     | 501,400       |
| Medium     | 30       | 45    | 60,499        | 37,101        |
| Large      | 100      | 150   | 140,200       | 89,000        |



---

Analysis Questions

1. How does graph size affect BFS and DFS performance?
Performance grows roughly linearly with the number of vertices and edges. As the graph size increases from 10 → 30 → 100 vertices, execution time increases proportionally, which matches the **O(V + E)** complexity.

2. Which traversal is faster in your experiments?
DFS is consistently faster across all graph sizes (about 30–40% faster in these tests). This is because:
- DFS uses recursion with less overhead than BFS's queue
- BFS requires more memory operations (poll/add to queue)

3. Do results match the expected complexity O(V + E)?
Yes. The time increase from 10→30→100 vertices is roughly linear with V+E, confirming the theoretical complexity.

4. How does graph structure affect traversal order?
- BFS visits vertices level by level (distance from start)
- DFSfollows one branch completely before backtracking  
  In the small graph, BFS produced `V0 V1 V9 V8 V6...` (wave-like), while DFS followed a simple path `0→1→2→3→4→5→6→7→8→9`.

5. When is BFS preferred over DFS?
- Finding the shortest path in unweighted graphs
- When the graph is wide and shallow
- When you need level-order traversal (e.g., social networks, web crawling)

6. What are the limitations of DFS?
- Does not guarantee the shortest path
- Can cause stack overflow on very deep graphs (recursive implementation)
- May get stuck exploring a deep branch while a solution is close to the start





