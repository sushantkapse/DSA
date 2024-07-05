/**
 * Recursion
 */
public class Recursion {
public static void main(String[] args) {
    // decreasing_order(10);
    // System.out.println(naturalsum(20));
    int arr[] = {1,2,3,1,4,5};
    // System.out.println(getindex(arr, 0, 2));
    // System.out.println(lastoccurence(arr, 0, 1));
    // binaryString(4, 0, new String());
    search(arr, arr.length, 1);
    
    
}
public static void decreasing_order(int n ) {
    System.out.println(n);
    if(n>1){

        decreasing_order(n-1);
    }
}
   public static int naturalsum(int n ) {
    if(n == 0){
            return 0;
    }
    int sum = n + naturalsum(n-1);
    return sum;
   } 

   public static int getindex(int arr[],int i,int target) {

   
        
        if(i == arr.length  ){
           
                return -1;
                
            }
        


        if(arr[i]==target ){
            return 1;
        }
        // i=i+1;

         return getindex(arr, i+1, target);
    }
    

    public static int lastoccurence(int arr[],int i,int key) {
        if(i==arr.length){
            return -1;
        }

        if(arr[arr.length-1-i]==key){
            return arr.length-1-i;
        }
        return lastoccurence(arr, i +1, key);
    }

    public static void search(int arr[],int n, int target) {

        if(n==-1){
            return ;
        }

        if(arr[n-1]==target){
            System.out.println(n);
        }
        search(arr, n-1, target);


        
    }

    public static void binaryString(int n,int last_place,String str) {
        if(n==0){
            System.out.println(str);
            return;
        }
        
        binaryString(n-1, 0, str+"0");
        if(last_place== 0){
            binaryString(n-1, 1, str+"1");
        }
    }
   }
