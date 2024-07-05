import java.util.Scanner;

class Array_twod {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
       int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    //    for (int i = 0; i < arr.length; i++) {
    //         for (int j = 0; j < arr[0].length; j++) {
    //             arr[i][j]=sc.nextInt();
    //         }
    //    }
    //    display(arr);
    //    search(arr, 4);
    //    Min_mAx(arr);
    // spiral(arr);
    //    display(arr);
    // diagonalSum(arr);
    // diagonalsum(arr);
    System.out.println(arr.length);



       
    }
    public static void spiral(int arr[][]) {
        
        int start_row = 0;
        int end_row=arr.length-1;
        int start_column = 0;
        int end_column= arr[0].length-1;
        while (start_column <= end_column && start_row <= end_row) {
            
            for (int i = start_column; i <= end_column; i++) {
                System.out.println(arr[start_row][i]);
            }
            for (int i = start_row + 1; i <= end_row; i++) {
                System.out.println(arr[i][end_column]);
            }
            for (int i = end_column-1; i >= start_column ; i--) {

                if (start_row == end_row){
                    return ; 
                }
                System.out.println(arr[end_row][i]);
            }
            for (int i = end_row -1; i >= start_row + 1; i--) {
                if (start_column == end_column){
                    return ; 
                }
                System.out.println(arr[i][start_column]);
            }
    
            start_column  ++;
            start_row++;
            end_column--;
            end_row--;
        
        }

    }

    public static void diagonalSum(int arr[][]) {
        int sum=0;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i==j){
                     sum += arr[i][j] ;
                }
            }
        }
        System.out.println(sum);
    }

    public static void diagonalsum(int arr[][]){
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            // diagonal primary- pointer are same 
            sum += arr[i][i];

            // in odd length they are overlap so one pointer is not equal to another so it is 
            if(i != arr.length-1-i){
                
                // secondary diagonal = pointers sum is length-1;
                sum += arr[i][arr.length-i-1];
            } 
        }

        System.out.println(sum);
    }
    
    public static void display(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
       }
    }

    public static void search(int arr[][],int key) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(key == arr[i][j]){
                    System.out.println("Element found at (" + i +"," + j +")" );
                }
            }
       }
       System.out.println("element not found");
    }
    public static void Min_mAx(int arr[][]){
        int min = Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
       }
       System.out.println(max);
       System.out.println(min);
    }
}
