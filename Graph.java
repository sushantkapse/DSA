import java.util.*; 
public class Graph {

    static class Edge {
        int src = 0;
        int dest = 0;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
        
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // int V = 7;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));


        

    }
    // @SuppressWarnings('unchecked')
    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if(!vis[curr]){
                System.out.println(curr);
                vis[curr]=true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        
    }
    
    // @SuppressWarnings("unchecked")
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        System.out.println(curr);
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int curr,int dest, boolean[] vis) {
        if(curr == dest){
            return true;
        }
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
               return true;
            }
        }

        return false;
    }

    
    public static void main(String[] args) {
        // createGraph();
        // System.out.println();
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // bfs(graph);
        // dfs(graph, 0, new boolean[V]);
        boolean a = hasPath(graph, 0, 4, new boolean[V]);
        System.out.println(a);

    }
}
