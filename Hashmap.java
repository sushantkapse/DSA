import java.util.*;;
public class Hashmap {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1, "abc");
        map.put(2, "asd");
        map.put(3, "ewe");
        map.put(4, "gg");
        // System.out.println(map.remove(1));

        // System.out.println(map);
        // System.out.println(map.get(3));

        Set<Integer> hs = map.keySet();
        System.out.println(hs); 

        for (Integer key : hs) {
            System.out.println(key + "-> " +map.get(key));
        }
    }
}
