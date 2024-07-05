import java.util.*;

import org.w3c.dom.Node;
public class Hashmap_Implementation {
    
    static class Maps<K,V> {
        private class Node {
            K key;
            V value ; 
            public Node(K key, V value){
                // this.k = key;
                this.key = key;
                this.value = value;
            }
            
        }
        private int n;  // count of root
        private int N;  // Size 
        private LinkedList<Node> bucket[];
        
        // @SuppressWarnings("unchecked")
        // @SuppressWarnings("unchecked")
        @SuppressWarnings("unchecked")
        public Maps(){
            this.n = 0;
            this.N = 4;
            this.bucket = new Linkedlist[4];
            for (int i = 0; i < 4; i++) {
                this.bucket[i] = new LinkedList<>();
            }
        }



        public int getBinaryIndex(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % bucket.length;
                }

        public int searchLL(K key, int bi) {
          LinkedList<Node> ll = bucket[bi];
          int di = 0;
          for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di ++ ;
          }
          return -1;
        }

        public  void rehash() {
            LinkedList<Node> old_bucket[] = bucket;
            bucket = new LinkedList[N*2];
            N = N * 2;
            for (int i = 0; i < bucket.length; i++) {
                bucket[i]=new LinkedList<>();

            }

            for (int i = 0; i < old_bucket.length; i++) {
                LinkedList<Node> ll = old_bucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
            }

            
        





        public void put(K key, V value){
            int bi = getBinaryIndex(key);
            int di = searchLL(key,bi);
            if(di != -1){
                
                Node node = bucket[bi].get(di);
                node.value = value;
            }else {
                bucket[bi].add(new Node(key, value));
                n ++;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0){
                rehash();
            }

            
        }
    }
        
    
    
    
    public static void main(String[] args) {
        Maps<Integer, String> hm = new Maps<>();
        hm.put(1, "abc");
        hm.put(2, "sd");
        hm.put(3, "sdf");
        System.out.println(hm);
    }
}