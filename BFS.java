/**
* The program mainly deals with the 2-color problem (Check if a graph is bipertite).
* However, all aspects of BFS have been coded: Print the shortest path from source to destination (using parent array),
* Running BFS on all components of a graph,
* Computed shortest distances from a given source (using distance array)
* CLRS-22.2-7
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	static Graph g;
	static int V;
	static boolean[] visited;
	static int[] distance;
	static int[] parent;
	static int[] color;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of vertices: ");
		V = Integer.parseInt(br.readLine());
		g = new Graph(V);
		System.out.println("Enter the number of wrestlers with rivalries: ");
		int E = Integer.parseInt(br.readLine());
		System.out.println("Enter pair of rivalries: ");
		// construct graph
		for (int i = 0; i < E; i++) {
			String[] edge = br.readLine().split(" ");
			int u = Integer.parseInt(edge[0]);
			int v = Integer.parseInt(edge[1]);
			g.addEdge(u, v);
		}

		// Initialization
		/* Note: This initialization is being done 
		outside of the BFS routine as it is 
		being called several times for each component
		*/
		distance = new int[V];
		parent = new int[V];
		color = new int[V];
		visited = new boolean[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		Arrays.fill(parent, -1);
		Arrays.fill(color, 0);

		// debug: print graph
		g.printGraph();

		if (bfs(0)) {
			System.out.println("0 Is Colorable");
		} else {
			System.out.println("0 Is Not 2- Colorable");
		}
		// check for remaining components
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (bfs(i)) {
					System.out.println(i + " Is Colourable");
				} else {
					System.out.println(i + " Is Not 2-Colorable");
				}
			}
		}


		printPath(0, 4);
		
	}

	public static boolean bfs(int s) {

		boolean is2colourable = true;

		// discover source
		distance[s] = 0;
		visited[s] = true;
		color[s] = 1;

		Queue<Integer> Q = new LinkedList<>();
		Q.add(s);
		while (!Q.isEmpty()) {
			int u = Q.remove();

			ArrayList<Integer> a = g.getAdj(u);

			for (int v : a) {
				if (visited[v] == false) {
					visited[v] = true;
					distance[v] = distance[u] + 1;

					parent[v] = u;
					color[v] = -color[u];
					
					Q.add(v);
				} else {
					if (color[v] == color[u]) {
						// System.out.println("not 2 colorable");
						is2colourable = false;
					}
				}

			}

    		}

		return is2colourable;
	}

	/**
	 * Prints shortest path from s to v, assuming that BFS has already computed
	 * a breadth first tree. *
	 *
	 */

	public static void printPath(int s, int v) {
		
		if (v == s){
			System.out.print(" --> " + s);
			return;
		}
		
		else if (parent[v] == -1) {
			System.out.println("No path from  " + s + " " + " to " + v);

		} else {
			printPath(s, parent[v]);
		}
		System.out.print(" --> " + v);
	}

}

class Graph {
	ArrayList<ArrayList<Integer>> adjList;
	private int V;

	Graph(int V) {
		adjList = new ArrayList<ArrayList<Integer>>(V);
		this.V = V;
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int u, int v) {
		adjList.get(u).add(v);
		// for undirected graph
		adjList.get(v).add(u);
	}

	public ArrayList<Integer> getAdj(int v) {
		return adjList.get(v);
	}

	public void printGraph() {
		for (int i = 0; i < V; i++) {
			ArrayList<Integer> list = adjList.get(i);

			System.out.println(list);
		}
	}

}
