import java.util.*;
public class Greedy {

    public static void Activity(int[] start,int[] end) {
        int maxcount = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int lastend=end[0];

        list.add(0);
        maxcount=1;
        for (int i = 1; i < end.length; i++) {
            if(start[i] < lastend){
                maxcount++;
                list.add(i);
                lastend=end[i];
            }
        }

        System.out.println("Activity count is : " + maxcount);
        for (int i = 0; i < list.size(); i++) {
            System.out.print("A"+list.get(i)+" ");
        }

    }

    /**
     * @param start
     * @param end
     */
    public static void Activity_forUnsorted(int[] start,int[] end) {
        
        int activities[][]= new int[end.length][3];
        for (int i = 0; i < end.length; i++) {
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
            
        }
        
        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
        
        int maxcount = 0;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(activities[0][0]);
        int lastend = activities[0][2];
        maxcount=1;
        for (int i = 1; i < end.length; i++) {
            if(activities[i][1] < lastend){
                maxcount++;
                list.add(activities[i][0]);
                lastend=activities[i][2];
            }
        }

        System.out.println("Activity count is : " + maxcount);
        for (int i = 0; i < list.size(); i++) {
            System.out.print("A"+list.get(i)+" ");
        }

    }



    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};

        Activity(start, end);
    }
}
