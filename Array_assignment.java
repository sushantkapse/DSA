public class Array_assignment {
    public static void main(String[] args) {
        int numbers[] = {1,2,3,4};
        // System.out.println(same(numbers));
        System.out.println(check(numbers, 0));
    }
    public static boolean same(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static int check(int arr[],int key){
        int start = 0,end = arr.length;
        while (start<=end) {
            int mid = (start + end)/2;
            if(key==arr[mid]){
                return mid;
            }
            if(key < arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return -1;
    }
}
