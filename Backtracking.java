public class Backtracking {

    public static void String_Subsets(String s,String ans,int i) {

        if(i==s.length()){
            if(ans.length()==0){
                System.out.println("Null");
            }else{
                System.out.println(ans);
            }
            return ;
        }

        String_Subsets(s, ans+s.charAt(i), i+1);
        String_Subsets(s, ans, i+1);
    }

    public static void findPermutation(String str,String ans) {
        
        if(str.length()==0){
            System.out.println(ans);
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String Newstr= str.substring(0, i) + str.substring(i + 1);
            findPermutation(Newstr, ans+curr);
        }
    }

    public static void nQueens(char arr[][] , int row) {

        if (row==arr.length) {
            printBoard(arr);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(isTrue(arr, row, i)){

                arr[row][i]= 'Q';
                nQueens(arr, row+1);
                arr[row][i]='x';
            }
        }
    }

    public static boolean isTrue(char arr[][],int row, int col) {
        
        // check vertical upside
        
        for (int i = row -1; i >=0; i--) {
            if(arr[i][col]=='Q')
                return false;
        }

        for (int i = row -1,j=col-1; i >=0 && j>=0; i--,j--) {
            if(arr[i][j]=='Q')
                return false;
        }
        
        for (int i = row -1,j=col+1; i >=0 && j< arr[row].length; i--,j++) {
            if(arr[i][j]=='Q')
                return false;
        }

        return true;
    }

    public static int gridWays(int i,int j,int m,int n) {
        if(i==m-1 && j==n-1){
            return 1;
        }
        else if(i==m || j==n){
            return 0;
        }

        int way1=gridWays(i +1, j, m, n);
        int way2=gridWays(i , j + 1, m, n);
        return way1 + way2;
    }

    public static void printBoard(char arr[][]) {

        System.out.println("-----------Chess Board-----------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int arr[][], int row,int column,int digit) {
        // for column check
        for (int i = 0; i <=8 ; i++) {
            if(arr[i][column]==digit){
                return false;
            }
        }

        // for row check

        for (int i = 0; i <= 8; i++) {
            if(arr[row][i]==digit){
                return false;
            }
        }

        // for grid check

        int sr=(row/3)*3;
        int sc=(column/3)*3;
        for (int i = sr; i < sr+3; i++) {
            for (int j = sc; j < sc+3; j++) {
                if(arr[i][j]==digit){
                    return false;
                }
            }
        }

        return true;

    }

    public static void printArray(int arr[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }



    public static boolean sudokuSolver( int arr[][],int row,int column) {

        // base case

        if(row==9 ){
            return true ;
        }

        int nextrow=row;
        int nextcolumn=column + 1;
        if(column+1==9){
            nextrow=row+1;
            nextcolumn=0;
        }

        if(arr[row][column]!=0){
            return sudokuSolver(arr,nextrow,nextcolumn);
        }
        

            for (int digit = 1; digit <= 9; digit++) {
                if(isSafe(arr, row, column, digit)){
                    arr[row][column]=digit;
                    if(sudokuSolver(arr,nextrow,nextcolumn)){
                        return true;
                    }
                    arr[row][column]=0;
                }
               
            }
        

        return false;
        
    }

    


    public static void main(String[] args) {
        String s = "abc";
        // String_Subsets(s, "", 0);
        // findPermutation(s, "");
        int n = 3,m=3;
        // char arr[][]= new char[n][n];
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr.length; j++) {
        //         arr[i][j]='x';
        //     }
        // }
        // nQueens(arr, 0);
        // int a =gridWays(0, 0, m, n);
        // System.out.println(5/3);

        int arr[][]= {{0, 0, 8, 0, 0, 0, 0, 0, 0},
        {4, 9, 0, 1, 5, 7, 0, 0, 2},
        {0, 0, 3, 0, 0, 4, 1, 9, 0},
        {1, 8, 5, 0, 6, 0, 0, 2, 0},
        {0, 0, 0, 0, 2, 0, 0, 6, 0},
        {9, 6, 0, 4, 0, 5, 3, 0, 0}, 
        {0, 3, 0, 0, 7, 2, 0, 0, 4},
        {0, 4, 9, 0, 3, 0, 0, 5, 7},
        {8, 2, 7, 0, 0, 9, 0, 1, 3} };

        // int arr[][]= {{3, 0, 6, 5, 0, 8, 4, 0, 0},
        // {5, 2, 0, 0, 0, 0, 0, 0, 0},
        // {0, 8, 7, 0, 0, 0, 0, 3, 1},
        // {0, 0, 3, 0, 1, 0, 0, 8, 0},
        // {9, 0, 0, 8, 6, 3, 0, 0, 5},
        // {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        // {1, 3, 0, 0, 0, 0, 2, 5, 0},
        // {0, 0, 0, 0, 0, 0, 0, 7, 4},
        // {0, 0, 5, 2, 0, 6, 3, 0, 0} };

        // System.out.println(arr);
        // if(sudokuSolver(arr, 0, 0)){
        //     System.out.println("solution exist");
        //     printArray(arr);
        // }else{
        //     System.out.println("solution does not exist");
        // }
    }
}
