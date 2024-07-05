public class Sorting {
    public static void main(String[] args) {
        int[] number = {5,4,1,2,1,7,4,3};
        // bubble(number);
        // selection(number);
        // insertion(number);
        count(number);
        print(number);
        

    }
    public static void bubble(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length-1-i; j++) {
            if(arr[j] > arr[j+1]){
                int temp =  arr[j+1];
                arr[j+1]=arr[j];
                arr[j]=temp;
            }
        }
        }
    }

    public static void selection(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minindex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minindex] >  arr[j]){
                    minindex = j;
                }
            }
            int temp = arr[minindex];
            arr[minindex]=arr[i];
            arr[i]=temp;

        }
   }
   public static void insertion(int arr[]) {
    for (int i = 1; i < arr.length; i++) {
        int current = arr[i] ;
        int prev = i-1;
        while (prev >= 0 && arr[prev ]> current) {
            arr[prev+1]=arr[prev];

            prev -- ;
            
        }
        arr[prev+1]=current;
    }
   }
    
   public static void count(int arr[]){
    int largest = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
        largest = Math.max(largest, arr[i]);
    }
    int cnt[] = new int[largest+1];
    for (int i = 0; i < arr.length; i++) {
        cnt[arr[i]]++;
    } 
    int j = 0;
    for (int i = 0; i < cnt.length; i++) {
        while(cnt[i] > 0){
            arr[j]=i;
            j++;
            cnt[i]--;
        }
    }
   }
    public static void print(int arr[]) {
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
    
