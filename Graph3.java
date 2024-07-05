import java.util.*;;
public class Graph3 {
    static class Edge {
        int src = 0;
        int dest= 0;
        int wt= 0;
        public Edge(int source, int dest, int weight){
            this.src = source;
            this.dest =  dest;
            this.wt =  weight;
        }
    }

        public static void createGraph(ArrayList<Edge>[] graph) {
            for (int i = 0; i < graph.length; i++) {
                graph[i]= new ArrayList<>();
            }

            graph[0].add(new Edge(0, 1, 2));
            graph[0].add(new Edge(0, 2, 4));

            graph[1].add(new Edge(1, 2, -4));

            graph[2].add(new Edge(2, 3, 2));
            graph[3].add(new Edge(3, 4, 4));
            graph[4].add(new Edge(4, 1, 1));
        }

        public static void createGrap1(ArrayList<Edge>[] graph) {
            for (int i = 0; i < graph.length; i++) {
                graph[i]= new ArrayList<>();
            }

            graph[0].add(new Edge(0, 1, 10));
            graph[0].add(new Edge(0, 2, 30));
            graph[0].add(new Edge(0, 3, 15));

            graph[1].add(new Edge(1, 0, 10));
            graph[1].add(new Edge(1, 2, 40));

            graph[2].add(new Edge(2, 3, 50));
            graph[2].add(new Edge(2, 0, 30));

            graph[3].add(new Edge(3, 2, 50));
            graph[3].add(new Edge(4, 0, 15));
        }

        public static void bellmond(ArrayList<Edge>[] graph, int src) {

            int[] dist = new int[graph.length];
            for (int i = 0; i < dist.length; i++) {
                if(i != src){
                    dist[i]= Integer.MAX_VALUE;
                }
            }
            int V = graph.length;

            for (int i = 0; i < V-1 ; i++) {
                
                for (int j = 0; j < graph.length; j++) {
                    for (int k = 0; k < graph[j].size(); k++) {
                        Edge e = graph[j].get(k);
                        int u = e.src;
                        int v = e.dest;
                        int wt = e.wt;
                        if(dist[u] != Integer.MAX_VALUE && (dist[u] + wt) < dist[v] ){
                            dist[v]= dist[u] + wt;
                            
                        }
                    }
                }
            }

            for (int m = 0; m < dist.length; m++) {
                System.out.println(dist[m]);
            }
        }

        static class Pairs implements Comparable<Pairs> {
            int V;
            int cost;
            public Pairs(int V, int cost){
                this.V =  V;
                this.cost =  cost;
            }
            @Override
            public int compareTo(Pairs p){
                return this.cost - p.cost;
            }
            
        }

        public static void Prims(ArrayList<Edge>[] graph) {
            PriorityQueue<Pairs> pq = new PriorityQueue<>();
            pq.add(new Pairs(0, 0));
            boolean[] vis =  new boolean[graph.length];
            int finalcost = 0;
            while (!pq.isEmpty()) {
                Pairs curr = pq.remove();
                if(!vis[curr.V]){

                    vis[curr.V] =  true;
                    finalcost += curr.cost;
                    for (int i = 0; i < graph[curr.V].size(); i++) {
                        Edge e = graph[curr.V].get(i);
                        pq.add(new Pairs(e.dest, e.wt));
                    } 
                }
            }

            System.out.println(finalcost);
        }
        
    


    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph =  new ArrayList[V];
        // System.out.println("heell");
        // createGraph1(graph);
        createGrap1(graph);
        // bellmond(graph, 0);
        Prims(graph);
        

    }
}
