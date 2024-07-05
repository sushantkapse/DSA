// class Array{

//     public static void main(String[] args) {
//         System.out.println("hello")
//     }
// }

public class Array {
    public static void main(String[] args) {
        int[] numbers = {4,2,0,6,3,2,5}; 
        // binarysearch(numbers, 6);
        // reverse(numbers);
        // for (int i = 0; i < numbers.length; i++) {
        //     System.out.println(numbers[i]);
        // }
        // pair(numbers);
        subarray(numbers);
        // subarraysum(numbers);
        // prefixsum(numbers);
        // kadanes(numbers);
        // trapping(numbers);
    }

   
    public static void binarysearch(int numbers[],int key){
            int start = 0 , end = numbers.length-1;
            while (start<=end) {
                int mid = (start + end)/2;
                if(numbers[mid] == key){
                    System.out.println(" element found at index : "+ mid);
                }
                if(mid < key){
                    start = mid + 1;
                }
                else{
                    
                        end = mid -1;
                    
                }
                
            }
            System.out.println("Element is not found");
    }
    public static void reverse (int arr[]){

        int start = 0,end = arr.length-1;
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end] ;
            arr[end] = temp;
            start = start +1;
            end = end -1;
        }
    }

    public static void pair(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + " , " + arr[j] + ") ");
            }
            System.out.println();
        }
    }
    public static void subarray(int arr[]){

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int j2 = i; j2 <= j ; j2++) {
                    System.out.print(arr[j2]+ " ");
                }
                System.out.println(", ");
            }
            System.out.println();
        }
    }
    public static void subarraysum(int arr[]){
        int sum = 0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int j2 = i; j2 <= j ; j2++) {
                    sum = sum + arr[j2];
                }
                if (sum > max){
                    max = sum;
                }
                System.out.print(sum + "  " );
                sum = 0;
            }
            System.out.println();
        }
        System.out.println("maximum sum is : " + max);
    }
    public static void prefixsum(int arr[]){
        int sum= 0;
        int max=Integer.MIN_VALUE;

        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i]=prefix[i-1]+arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end  = j;
               sum = start == 0 ? prefix[end] :  prefix [end] - prefix[start-1];
               System.out.print(sum+" ");
               if(max < sum){
                max = sum ;
               }
            }
            System.out.println();
        }

        System.out.println("max is : " + max);
    }
    public static void kadanes (int arr[]){
        int currentSum= 0, maximum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            if(currentSum <= 0 ){
                    currentSum = 0;
            }
            if(currentSum > maximum){
                maximum=currentSum;
            }
        }

        System.out.println("maximum sum is : " + maximum);
    }

    public static void trapping(int arr[]){
        int n = arr.length;
        int[] lmax= new int [n];
        lmax[0]=arr[0];
        for (int i = 1; i < lmax.length; i++) {
            lmax[i] = Math.max(arr[i], lmax[i-1]);
        }
        int[] rmax= new int [n];
        rmax[n-1]=arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            rmax[i] = Math.max(arr[i], rmax[n-1]);
        }

        int trappedwater=0;

        for (int i = 0; i < arr.length; i++) {
            int waterlevel = Math.min(lmax[i], rmax[i]);
             trappedwater += waterlevel - arr[i];
        }

        System.out.println("Trapped water stored is : "+trappedwater);

        
    }

    public static void rotate_sear(String[] args) {
        
    }


}
