public class String_revision {
    public static void main(String[] args) {
       String s = "ESESNNNWWWWWWWW";
    //    shortest_path(s);
    String s1[] ={"abc","xyz","dasd"};
    // largeststring(s1);
    String s2="asdasd sdfsdf dsfds";
    lowertoupper(s2);
            
        
    }

    public static void shortest_path(String s){
        int x=0;
        int y=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='N'){
                x++;
            }
            else if(s.charAt(i)=='S'){
                x--;
            }
            else if(s.charAt(i)=='W'){
                y++;
            }
            else{
                y--;
            }
        }
        int x2=x*x;
        int y2=y*y;
        float ans=(float) Math.sqrt(x2 + y2);
        System.out.println(ans);
        

    }
    public static void largeststring( String s[]) {
        String large =  s[0] ;
        for (int i = 0; i < s.length; i++) {
            if(s[i].compareTo(large) > 0){
                large=s[i];
            }
        }
        System.out.println("Largest String is : " +large);
    }
    public static void lowertoupper(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);


    }
}
