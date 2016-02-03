import java.io.*;
import java.util.*;

/**
 * 
 * @author Amita
 * Sample input: 8
0 1
0 3
1 4
2 4
2 5
3 1
5 5
4 3
 * fig 22.4 CLRS
 */
public class DfsAlgo {

	static int time = 0;
	static boolean[] visited;
	static int[] dTime;
	static int[] fTime;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		int n = 6;
		Graph G = new Graph(n);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of edges (0 indexed): ");
		int E = Integer.parseInt(br.readLine());
		System.out.println("Enter the edges:");
		for (int i = 0; i < E; i++) {
			String[] s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			G.addEdge(u, v);
		}
		// Initialization:
		visited = new boolean[n];
		dTime = new int[n];
		fTime = new int[n];
		parent = new int[n];
		Arrays.fill(parent, -1);
		// arrays are already initialized with these values
		Arrays.fill(visited, false);
		Arrays.fill(dTime, 0);
		Arrays.fill(fTime, 0);

		dfs(G);
		
		//Check validity:
		printTimes(G);
	}

	public static void dfs(Graph g) {
		for (int i = 0; i < g.v; i++) {
			if (!visited[i]) {
				dfsVisit(g, i);
			}
		}

	}

	public static void dfsVisit(Graph g, int u) {
		time++;
		dTime[u] = time;
		visited[u] = true;
		ArrayList<Integer> adj = g.getAdj(u);
		for (int v : adj) {
			if (!visited[v]) {
				parent[v] = u;
				dfsVisit(g, v);
			}
		}

		time++;
		fTime[u] = time;
	}

	public static void printTimes(Graph g) {
		for (int i = 0; i < g.v; i++) {
			System.out.print(" " + dTime[i]);
		}
		System.out.println();
		for (int i = 0; i < g.v; i++) {
			System.out.print(" " + fTime[i]);
		}
	}

 static class Graph{ 
	 ArrayList<ArrayList<Integer>> adjList;
		int v;
		Graph(int v){
			adjList = new ArrayList<ArrayList<Integer>>();
			this.v=v;
			for(int i=0;i<v;i++){
				adjList.add(new ArrayList<Integer>());
			}
		}
		
		public void addEdge(int u, int v){
			adjList.get(u).add(v);
			//for undirected graph
			//adjList.get(v).add(u);
		}
		
		public ArrayList<Integer> getAdj(int u){
			return adjList.get(u);
		}
 }

}
