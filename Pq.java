import java.util.Comparator;
import java.util.PriorityQueue;
public class Pq {

    static class Student implements Comparable<Student>  {
        int marks;
        String Name ;
        Student(int marks , String Name){
            this.marks = marks;
            this.Name = Name;
        }
        @Override
        public int compareTo(Student s2){
            return this.marks - s2.marks;
        }
        
    }

    static class Points implements Comparable<Points>{
        int x1;
        int x2;
        int distance;
        int idx;
        Points(int x1, int x2, int distance, int idx){
            this.x1 = x1;
            this.x2 = x2;
            this.distance = distance;
            this.idx = idx;
        }

        @Override
        public int compareTo(Points p2){
            return this.distance - p2.distance;
        }
    }
    public static void cost_connecting_N_ropes(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int min = pq.remove();
            int min1 = pq.remove();

            cost += min + min1;
            pq.add(min+min1);
        }
        System.out.println("cost is : " + cost);
    }

    static class army implements Comparable<army> {
        int soldier;
        int idx;
        army(int soldier,int idx){
            this.soldier = soldier;
            this.idx = idx;
        }

        @Override 
        public int compareTo(army a1){
            if(this.soldier == a1.soldier){
                return this.idx - a1.idx;
            }else {
                return this.soldier - a1.soldier;
            }

        }

        
    }

    public static void weakest_soldier(int arr[][],int k) {
        PriorityQueue<army> pq = new PriorityQueue<>();
        for(int i = 0 ; i < arr.length ; i ++){
            int count  = 0;
            for (int j = 0; j < arr[0].length; j++) {
                count += arr[i][j] == 1 ? 1 : 0;
            }
            pq.add(new army(count, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println(" Row ->" + pq.remove().idx);
        }
    }

    
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // pq.add(10);
        // pq.add(15);
        // pq.add(8);
        // System.out.println();
        // System.out.println("hello");
        
        // PriorityQueue<Student> pq =  new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(new Student(10,"sk"));
        // pq.add(new Student(9,"ks"));
        // pq.add(new Student(8,"abc"));
        //     while (!pq.isEmpty()) {
        //         System.out.println(pq.peek().Name + "->" + pq.peek().marks);
        //         pq.remove();

        //     }

            // System.out.println(pq);

        // PriorityQueue<Points> p = new PriorityQueue<>();

        // int cars[][] = {{3,2},{5,-1},{-2,4}};
        // int k = 2;

        // for (int i = 0; i < cars.length; i++) {
        //     int distance =  cars[i][0]*cars[i][0] + cars[i][1]*cars[i][1];
        //     p.add(new Points(cars[i][0], cars[i][1], distance, i));
        // }

        // for (int i = 0; i < k; i++) {
        //     System.out.println("C->" + p.remove().idx);
            
        // }

        // int arr[] = {2,3,3,4,6};
        // cost_connecting_N_ropes(arr);

        int arr[][] = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k = 2;
        weakest_soldier(arr, k);
        // weakest_soldier(arr, k);

        // PriorityQueue<army> pq = new PriorityQueue<>();
        // for(int i = 0 ; i < arr.length ; i ++){
        //     int count  = 0;
        //     for (int j = 0; j < arr[0].length; j++) {
        //         count += arr[i][j] == 1 ? 1 : 0;
        //     }
        // }

        // for (int i = 0; i < k; i++) {
        //     System.out.println(" Row ->" + pq.remove().idx);
        // }

        


    }
}
