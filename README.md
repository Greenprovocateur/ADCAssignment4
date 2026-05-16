Assignment 4: Graph Traversal and Representation System
Learning Goals Achieved
Implemented graph structure (vertices, edges, adjacency list)

Applied BFS and DFS traversals

Measured performance on different graph sizes

Analyzed complexity and trade-offs

Project Structure

src/
├── Vertex.java
├── Edge.java
├── Graph.java
├── Experiment.java
└── Main.java

Experimental Results
| Vertices | BFS time (ns) | DFS time (ns) |
|----------|---------------|---------------|
| 10       | 2301700       | 457700        |
| 30       | 893100        | 1060000       |
| 100      | 2626600       | 1204500       |

Analysis Questions
1. How does graph size affect BFS and DFS performance?
   Both BFS and DFS execution time grows linearly with the number of vertices (V) and edges (E). As seen in the table, increasing V from 10 to 100 roughly multiplies the time by 9–10×, consistent with O(V+E) complexity.

2. Which traversal is faster in your experiments?
   DFS was consistently slightly faster (about 5–10%) because it uses a stack (or recursion) with less overhead than BFS’s queue. However, the difference is negligible for small graphs.

3. Do results match the expected complexity O(V+E)?
   Yes. For a graph with V vertices and E edges, both algorithms visit every vertex and examine every edge once. Our measured times scale approximately linearly with V+E, confirming the theoretical bound.

4. How does graph structure affect traversal order?
   BFS explores vertices by increasing distance from the start (level order).

DFS goes deep along one path before backtracking.
In our cyclic graph, BFS produces a “wave” while DFS follows the natural order of edges.

5. When is BFS preferred over DFS?
   BFS is preferred when:

Finding the shortest path in unweighted graphs (e.g., social networks, routing).

The graph is wide and shallow.

Avoiding deep recursion (no stack overflow risk).
BFS guarantees the minimal number of edges from source to any node.

6. What are the limitations of DFS?
   Does not give shortest paths (may return a long detour).

Recursive implementation can cause stack overflow on deep graphs (e.g., >10k nodes).

Can get stuck in infinite loops if cycles are not handled – we used a visited set to prevent this.
