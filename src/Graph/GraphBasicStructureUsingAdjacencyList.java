package Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class GraphBasicStructureUsingAdjacencyList {

    private LinkedList<Integer> adj[];

    GraphBasicStructureUsingAdjacencyList(int v) {
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdges(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices and edges: ");
        int v = sc.nextInt();
        int e = sc.nextInt();

        GraphBasicStructureUsingAdjacencyList graph = new GraphBasicStructureUsingAdjacencyList(v);

        for(int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();

            graph.addEdges(source, destination);
        }
    }
}
