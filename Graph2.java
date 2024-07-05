import java.util.*;
import java.util.Stack;;
public class Graph2 {

    static class Edge {
        int src = 0;
        int dest = 0;
        int wt = 0;
        public Edge(int src,int dest,int weight){
            this.src = src;
            this.dest = dest;
            this.wt= weight;
        }
        
    }

    

    // public static void createGraph(ArrayList<Edge> graph[]) {
    //     // int V = 7;
    //     // ArrayList<Edge> graph[] = new ArrayList[V];
    //     for (int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     graph[0].add(new Edge(0, 1));
    //     // graph[0].add(new Edge(0, 2));

    //     // graph[1].add(new Edge(1, 3));
    //     graph[1].add(new Edge(1, 2));
    //     // graph[1].add(new Edge(1, 0));

    //     // graph[2].add(new Edge(2, 1));
    //     // graph[2].add(new Edge(2, 1));
    //     graph[2].add(new Edge(2, 3));

    //     // graph[3].add(new Edge(3, 2));
    //     // graph[3].add(new Edge(3, 1));
    //     // // graph[3].add(new Edge(3, 5));
        
    //     // // graph[4].add(new Edge(4, 2));
    //     // graph[4].add(new Edge(4, 1));
    //     // graph[4].add(new Edge(4, 0));
    //     // // 
    //     // graph[5].add(new Edge(5, 0));
    //     // graph[5].add(new Edge(5, 2));
    //     // graph[5].add(new Edge(5, 1));

    //     // graph[6].add(new Edge(6, 5));

    // }

    public static void createGraph1(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 5, 5));
        graph[4].add(new Edge(4, 2, 3));

        // graph[4].add(new Edge(4, 2, 3));
    }


    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] vis =  new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                dfsutil(graph, vis, i);
            }
        }
    }
    public static void dfsutil(ArrayList<Edge>[] graph,boolean[] vis, int curr) {
        System.out.print(curr + "  ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e =  graph[curr].get(i);
            if(!vis[e.dest]){
                dfsutil(graph, vis, e.dest);
            }
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                bfsutil(graph,vis,i);
            }
        }

    }
    public static void bfsutil(ArrayList<Edge>[] graph, boolean[] vis, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int curr =  q.remove();
            
            if(!vis[curr]){
                System.out.println(curr);
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e =  graph[curr].get(i);

                    q.add(e.dest);
                }
            }
        }
    }

    public static boolean cycle(ArrayList<Edge> graph[]) {
        boolean[] vis =  new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                if(cycleutil(graph,vis,i,-1)){
                    return true;    
                };
            }
            
        }
        return false;
    }

    public static boolean cycleutil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                if(cycleutil(graph, vis, e.dest, curr)){
                    return true;
                }
            }

            else if(vis[e.dest] && e.dest != parent){
                return true;
            }
        }

        return false;
    }

    public static boolean bipatrete(ArrayList<Edge>[] graph) {
        int[] col = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i]=-1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if(col[i]==-1){
                q.add(i);
                col[i]=0;

                while (!q.isEmpty()) {
                    int curr =  q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e =  graph[curr].get(j);
                        if(col[e.dest]==-1){
                            int nextval = col[curr]== 0 ? 1: 0;
                            col[e.dest]=nextval;
                            q.add(e.dest);
                        }
                        else if(col[curr]==col[e.dest]){
                            return false;        
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean cycle_directed(ArrayList<Edge> graph[]) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(cycle_directed_util(graph, vis, stack, i)){
                return true;
            }
        }
        return false;
    }

    public static boolean cycle_directed_util(ArrayList<Edge> graph[],boolean[] vis, boolean[] stack, int curr){
        vis[curr]= true;
        stack[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!stack[e.dest] && cycle_directed_util(graph, vis, stack, e.dest)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
    

    public static void topology_dfs(ArrayList<Edge>[] graph) {
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]){
                topology_dfs_util(graph,s,vis,i);
            }
        }

        while (!s.empty()) {
            System.out.println(s.pop());
        }
    }

    public static void topology_dfs_util(ArrayList<Edge>[] graph, Stack<Integer> s, boolean[] vis, int curr) {
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topology_dfs_util(graph, s, vis, e.dest);
            }
        }
        s.push(curr);
    }
    public static void cal_indegree(int[]  arr,ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                arr[e.dest]++;
            }
        }
    }
    public static void topology_bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q =  new LinkedList<>();
        int[] indegree =  new int[graph.length];

        cal_indegree(indegree, graph);

        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr =  q.remove();
            System.out.println(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e =  graph[curr].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        
    }

    public static void all_path(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if(src == dest){
            System.out.println(path+dest);
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // if(e.dest == dest){
                // String path1 = path + e.dest;
                all_path(graph, e.dest, dest, path+src); 
            // }
            // else{
            //     System.out.println(" no path");
            // }
        }
    }

    static class  Pairs implements Comparable<Pairs> {
        int n;
        int path;
        Pairs(int n, int path){
            this.n = n;
            this.path = path;
        } 
        @Override
        public int compareTo(Pairs p){
            return this.path - p.path;
        } 
        
    }

    public static void dijkstra(ArrayList<Edge>[] graph,int src) {
        int[] dist = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if(i!= src){

                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean[] vis  =  new boolean[graph.length];
        PriorityQueue<Pairs> pq = new PriorityQueue<>();
        pq.add(new Pairs(src, 0));
        while (!pq.isEmpty()) {
            Pairs curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v =  e.dest;
                    int wt = e.wt;
                    if((dist[u] + wt) < dist[v] ){
                        dist[v]=dist[u] + wt;
                        pq.add(new Pairs(v, dist[v]));
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]);
        }

    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph1(graph);
        // createGraph(graph);
        // dfs(graph);s
        // bfs(graph);
        // System.out.println(cycle(graph));
        // int[] col = new int[V];
        // for (int i = 0; i < col.length; i++) {
        //     col[i]=-1;
        // }

        // System.out.println(bipatrete(graph));
        // System.out.println(cycle_directed(graph));
        // topology_dfs(graph);
        // topology_bfs(graph);
        // all_path(graph, 0, 3, " ");
        dijkstra(graph, 0);
        
    }
}


