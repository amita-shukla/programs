import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ConnectedComponents {

	public static int V;
	public static boolean[] visited;
	public static int[] parent;
	public static int[] d_t;
	public static int[] f_t;
	static int time;
	static int cc;

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of vertices: ");
		V = Integer.parseInt(br.readLine());
		Graph graph = new Graph(V);
		System.out.println("Enter the number of edges");
		int E = Integer.parseInt(br.readLine());
		System.out.println("Enter the graph");
		// construct graph
		for (int i = 0; i < E; i++) {
			String[] edge = br.readLine().split(" ");
			int u = Integer.parseInt(edge[0]);
			int v = Integer.parseInt(edge[1]);
			graph.addEdge(u, v);
		}
		visited = new boolean[V];
		parent = new int[V];
		d_t = new int[V];
		f_t = new int[V];
		Arrays.fill(visited, false);
		Arrays.fill(parent, -1);

		dfs(graph);
		System.out.println(" Number of connected components= " + cc);
	}

	public static void dfs(Graph graph) {
		time = 0;
		for (int u = 0; u < V; u++) {
			if (!visited[u]) { // if u is not visited
				cc++;
				dfsVisit(graph, u); // u is the root of the dfs tree
			}
		}
	}

	public static void dfsVisit(Graph graph, int u) {
		time++;
		d_t[u] = time; // u is discovered
		visited[u] = true;
		ArrayList<Integer> edges = graph.getAdj(u);
		for (int i = 0; i < edges.size(); i++) { // visit every node adjacent to
													// u
			int v = edges.get(i);
			if (!visited[v]) {
				parent[v] = u;
				dfsVisit(graph, v);
			}
		}
		time++;
		f_t[u] = time;
	}

}

class Graph {
	int V;
	ArrayList<ArrayList<Integer>> adj;

	public Graph(int V) {
		this.V = V;
		adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int u, int v) {
		adj.get(u).add(v);
		// for undirected graph
		// adj.get(v).add(u);
	}

	public ArrayList<Integer> getAdj(int u) {
		return adj.get(u);
	}

	public void printGraph() {
		for (int i = 0; i < V; i++) {
			ArrayList<Integer> list = adj.get(i);

			System.out.println(list);
		}
	}

}
