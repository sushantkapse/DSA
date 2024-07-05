import java.util.*;;
public class Heap {
    static class Heaps {
        
        ArrayList<Integer> hp = new ArrayList<>();
        
        public void add(int data){
            
            hp.add(data);
            int i = hp.size()-1;
            int par =  (i-1)/2;
            
            while (hp.get(par) > hp.get(i)) {
                
                
                int temp =  hp.get(i);
                hp.set(i, hp.get(par));
                hp.set(par, temp);
                i = par;
                par = (i-1)/2;
            }
            
            
            
            // for(int i = hp.size() -1; i >=  0; i--){
            //     int par =  (i-1)/2;
            //     if(hp.get(par) > hp.get(i)){
            //         int temp =  hp.get(i);
            //         hp.set(i, hp.get(par));
            //         hp.set(par, temp);
                
            //     }
            // }
        }
        

        public int peek(){
            return hp.get(0);
        }

        public void swap(int a, int b){
            int temp = a;
            a = b;
            b = temp ;
        }

        public void heapify(int i){
            int left = 2*i+1;
            int right = 2*i + 2;
            int minIndex = i;
            if(left < hp.size() && hp.get(left) < hp.get(minIndex)){
                minIndex = left;
            }
            if(right < hp.size() && hp.get(right) < hp.get(minIndex)){
                minIndex = right;
            }

            if( minIndex != i){
           
                int temp = hp.get(i);
                hp.set(i, hp.get(minIndex));
                hp.set(minIndex, temp);

                heapify(minIndex);
            }

            // return i ;
        }

        public  int remove() {
            

            int data  =  hp.get(0);
           

            int temp = hp.get(0);
            hp.set(0, hp.get(hp.size()-1));
            hp.set(hp.size()-1, temp);
            hp.remove(hp.size()-1);
            heapify(0);
            return data;



            
        }

        public boolean isEmpty(){
            return hp.size() == 0;
        }
        
    }

    public static void max_Hepify(int arr[],int i,int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;
        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }
        
        if(maxIdx != i){
            int temp = arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;
            // System.out.println(arr[maxIdx]);
            // System.out.println(arr[i]);
            // System.out.println("----------");

            max_Hepify(arr,maxIdx,size);
        }
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;
        for (int i = (n/2); i >= 0 ; i--) {
            // System.out.println(i);
            max_Hepify(arr,i,n);
        }

        for (int size = n-1; size > 0; size--) {
            int temp = arr[0];
            arr[0]=arr[size];
            arr[size]=temp;

            max_Hepify(arr,0,size );
        }
       

        // when we have to remove value from array create for loop intiate it in according to problem and -- it.(Help in manipulation of problem)


        
        
    }

    public static void main(String[] args) {

        // Heaps h = new Heaps();
        // h.add(10);
        // h.add(20);
        // h.add(5);
        // h.add(3);
        // while(!h.isEmpty()){
        //     System.out.println(h.peek());
        //     h.remove();
        // }

        //  System.out.println("hello");

        int arr[]= {1,2,4,5,3};
        // heapSort(arr);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }

    //     for (int i = (5/2); i >= 0; i--) {
    //         System.out.println(i);
    //     }
    // // System.out.println(1/2);
    // System.out.println(5/2);

    // for (int i = (20/2); i >= 0; i--) {
    //     System.out.print(i + "  ");
    // }
    // System.out.println();

    // for (int i = 0; i < arr.length; i++) {
    //     System.out.println(i + " ");
    // }
        
    }
}
