/**
 * A simple directed graph structure using an adjacency matrix representation.
 * 
 * @author Jim Teresco and copilot
 * @version Spring 2025
 * 
 */
public class GraphMatrixDirected {

    // 2d array to hold the adjacency matrix, with rows and columns representing vertices,
    // with the value representing the weight of the edge from row to column
    private int[][] adjMatrix;

    // number of vertices in the graph
    private int numVertices;

    // constructor
    public GraphMatrixDirected(int numVertices) {
        adjMatrix = new int[numVertices][numVertices];
        this.numVertices = 0;
    }

    // add a vertex to the graph
    public void addVertex() {
        if (numVertices == adjMatrix.length) {
            // resize the matrix to accommodate the new vertex
            int[][] newMatrix = new int[adjMatrix.length * 2][adjMatrix.length * 2];
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    newMatrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = newMatrix;
        }
        numVertices++;
    }

    // add an edge to the graph
    public void addEdge(int from, int to, int weight) {
        if (from < numVertices && to < numVertices) {
            adjMatrix[from][to] = weight;
        }
    }
    // remove an edge from the graph
    public void removeEdge(int from, int to) {
        if (from < numVertices && to < numVertices) {
            adjMatrix[from][to] = 0;
        }
    }
    // get the weight of an edge
    public int getWeight(int from, int to) {
        if (from < numVertices && to < numVertices) {
            return adjMatrix[from][to];
        }
        return 0;
    }
    // get the number of vertices in the graph
    public int getNumVertices() {
        return numVertices;
    }
    // string representation of the graph
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                sb.append(adjMatrix[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // main method for testing
    public static void main(String[] args) {
        GraphMatrixDirected g = new GraphMatrixDirected(5);
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2,6);
        g.addEdge(1, 2, 9);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 4, 0);
        System.out.println(g);
    }
}