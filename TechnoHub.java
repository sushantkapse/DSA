public class TechnoHub {

    public static int equlibrium(int arr[]) {
        int lsum= 0;
        int rsum= 0;
        
        for (int i = 0; i < arr.length-1; i++) {
            
        
            lsum += arr[i];
        for( int j = i + 2 ; i<arr.length;j++){
            
                rsum += arr[j];

                if(lsum == rsum){
                    return i + 1;
                }
            
            }
            rsum = 0;
    }
        return -1;
    }

    public static int Trapping(int arr[]) {
        int left = 0;
        int right = arr.length-1;
        int maxarea= 0;
        while (left<right) {
            int currentSum= Math.min(arr[left], arr[right]*( right - left));
            maxarea=Math.max(maxarea, currentSum);
            if(arr[left]<arr[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return maxarea;
    }
    public static void main(String[] args) {
        int arr[]= {2,3,4,5};
        System.out.println(equlibrium(arr));
        // System.out.println(Trapping(arr));
    }
}
