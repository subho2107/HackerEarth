import java.awt.geom.Ellipse2D;
import java.io.*;
import java.util.*;

class Graph
{
    ArrayList<ArrayList<int[]>> adjList;
    boolean [] visited;
    int [] parent;
    int [] dist;
    int size, source ;
    Graph(int size)
    {
        this.size = size;
        this.adjList = new ArrayList<ArrayList<int[]>>(size+1);
        this.visited = new boolean[size+1];
        this.dist = new int[size+1];
        this.parent = new int[size+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
    }
    public void addEdge(int src, int dst, int weight)
    {
        int [] edge = {dst, weight};
        int [] edge2 = {src, weight};
        this.adjList.get(src).add(edge);
        this.adjList.get(dst).add(edge2);
    }
    public void calcAllShortestPaths(int src)
    {
        this.dist[src] = 0;
        this.source = src;
        for (int pos = 1; pos <= this.size; pos++) {
            int vertex = -1;
            for (int pos2 = 1; pos2 <= this.size; pos2++) {
                if (!this.visited[pos2] && (vertex == -1 || this.dist[pos2] < this.dist[vertex]))
                    vertex = pos2;
            }
            if (this.dist[vertex]==Integer.MAX_VALUE)
                break;
            this.visited[vertex] = true;
            for (int[] edge :
                    this.adjList.get(vertex)) {
                int dst = edge[0], cost = edge[1];
                if (cost+this.dist[vertex] < this.dist[dst])
                {
                    this.dist[dst] = cost + this.dist[vertex];
                    this.parent[dst] = vertex;
                }
            }
        }
    }
    public String getPath(int dst)
    {
        if (this.parent[dst]==-1)return "Error";
        int vertex = dst;
        String path = "";
        while (this.parent[vertex] != -1)
        {
            path = Integer.toString(vertex) +" "+ path;
            vertex = this.parent[vertex];
        }
        if (vertex != this.source)return "Error";
        path = path.strip();
        return path;
    }
}
public class Routes {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int costLostPerHour = Integer.parseInt(buffer.readLine());
        int noOfCities = Integer.parseInt(buffer.readLine());
        int noOfRoutes = Integer.parseInt(buffer.readLine());
        Graph graph = new Graph(noOfCities);
        for (int pos = 0; pos < noOfRoutes; pos++) {
            String [] inp = buffer.readLine().split(" ");
            int src = Integer.parseInt(inp[0]), dst = Integer.parseInt(inp[1]), time = Integer.parseInt(inp[2]), cost = Integer.parseInt(inp[3]);
            cost += time*costLostPerHour;
            graph.addEdge(src, dst, cost);
        }
        int source = Integer.parseInt(buffer.readLine());
        int dst = Integer.parseInt(buffer.readLine());
        graph.calcAllShortestPaths(source);
        System.out.println(graph.getPath(dst));

    }
}
