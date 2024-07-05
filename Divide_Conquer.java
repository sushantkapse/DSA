public class Divide_Conquer {
    public static void main(String[] args) {
        // int arr[]={7,4,98,1,45,76,2,33};
        int arr[]={4,5,6,7,0,1,2,3};
        
        
        // mergesort(arr, 0, arr.length-1);
        // quickSort(arr, 0, arr.length-1);
        // display(arr);
        int idx=RotateSearch(arr, 9, 0, arr.length);
        System.out.println(idx);

    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
    public static void mergesort(int arr[],int si,int ei) {
        if (si >= ei) {
            return ;
        }

        int mid = si + (ei-si)/2;
        mergesort(arr, si, mid);
        mergesort(arr, mid + 1, ei);

        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[],int si, int mid , int ei) {
        int temp[]=new int[ei-si+1];
        int i = si;
        int j = mid +1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i]<arr[j]) {
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
            
        }
        while (i<=mid) {
            temp[k++]=arr[i++];
        }
        while (j<=ei) {
            temp[k++]=arr[j++];
        }

        for ( i = si , k=0; k < temp.length; i++,k++) {
            arr[i]=temp[k];
        }
    }

    public static void quickSort(int arr[],int si, int ei) {

        if(si>=ei){
            return ;
        }

        int p_id=partition(arr,si,ei);
        quickSort(arr, si, p_id-1);
        quickSort(arr, p_id+1, ei);
    }
    public static int partition(int arr[],int si,int ei) {
        int i = si-1;
        int pivot = arr[ei];
        for (int j = si; j < ei; j++) {
            
            if(arr[j] <= pivot ){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }

        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }

    public static int RotateSearch(int arr[],int target,int si,int ei) {
        if(si >= ei){
            return -1;
        }

        int mid = si+ (ei-si)/2;
        if(arr[mid]==target){
            return mid;
        }

        if(arr[si]<arr[mid]){
            if(target<=arr[mid] && arr[si]<=target){
                return RotateSearch(arr, target, si, mid-1);
            }else{
                return RotateSearch(arr, target, mid +1, ei);
            }
        }else{
            if(arr[mid]<=target && target<=arr[mid]){
                return RotateSearch(arr, target, mid +1, ei);
            }else{
                return RotateSearch(arr, target, si, mid-1);
            }
        }

        
    }
}
