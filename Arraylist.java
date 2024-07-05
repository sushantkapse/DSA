import java.util.ArrayList;
public class Arraylist {

    public static int storeWater_Bruteforce( ArrayList<Integer> list) {

        int maxSum=Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                int ht=Math.min(list.get(i), list.get(j));
                int wd=j-i;
                int currentSum = ht * wd;
                maxSum=Math.max(maxSum, currentSum);
                
            }
        }
        return maxSum;

    }
    public static int storeWater_Optimum( ArrayList<Integer> list){
        int lp=0;
        int rp=list.size()-1;
        int maxsum=Integer.MIN_VALUE;

        while (lp<rp) {
            int height=Math.min(list.get(lp), list.get(rp));
            int width=rp-lp;
            int currentSum = height * width;
            maxsum=Math.max(maxsum, currentSum);

            if (list.get(lp)<list.get(rp) ) {
                lp++;
            }else{
                rp--;
            }

        }

        return maxsum;

    }
    public static boolean pairSum(ArrayList<Integer> list,int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i)+list.get(j)==target){
                    System.out.println(list.get(i));
                    System.out.println(list.get(j));

                    return true;
                }
            }
            
        }
        return false;
    }

    public static boolean pairSum_Optimistic(ArrayList<Integer> list,int target){
        int lp=0;
        int rp=list.size()-1;
        while (lp != rp) {
            int sum=list.get(lp)+list.get(rp);
            if(target == sum){
                System.out.println(list.get(lp));
                System.out.println(list.get(rp));

                return true;
            }else if(sum < target){
                lp++;
            }else{
                rp--;
            }
        }


        return false;
    }

    public static boolean pairSum_Rotated(ArrayList<Integer> list,int target){
        int bp=-1;
        
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)>list.get(i+1)){

                bp=i;
                break;
            }
        }
        
        int lp=bp+1;
        int rp=bp;
        while (lp != rp) {
            int sum=list.get(lp)+list.get(rp);
            if(sum==target){
                System.out.println(list.get(lp));
                System.out.println(list.get(rp));

                return true;
            }
             if(sum < target){
                lp=(lp+1)%list.size();
            }else{
                rp=(list.size()+rp-1)%list.size();
            }
        }


        return false;
    }

    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(8);
        // list.add(6);
        // list.add(7);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(2);
        // list.add(8);
        
        // System.out.println(list);
        // System.out.println(storeWater_Optimum(list));
        System.out.println(pairSum_Rotated(list, 5));
        
    }
}
