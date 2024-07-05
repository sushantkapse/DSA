public class Tries {
    static class Node{
        Node[] children = new Node[26];
        boolean eof = false;
        int idx = 0;
        int freq = 0;
        public Node(){
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();
    
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
                // curr.freq = 1 ;
            }
            else{
                curr.children[idx].freq++ ;
            }
            curr = curr.children[idx];
        }
        curr.eof = true;
    }

    public static boolean search(String key) {
        Node curr = root;
         for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                // curr.children[idx] = new Node();
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eof == true;
    }

    public static void prefix(Node root, String ans) {
        if(root == null){
            return;
        }

        if(root.freq == 1){
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                prefix(root.children[i], ans + (char)(i  + 'a'));
            }
        }
    }

    public static boolean wordBreak(String key) {
        if(key.length()==0){
            return true;
        }
        // Node curr = root;
        for (int i = 1; i <= key.length(); i++) {
            if(search(key.substring(0,i)) && wordBreak(key.substring(i))){
                return true;
            }
        }

        return false;
    }

    public static boolean startWith(String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
        
    }

    public static int count(Node root) {
        if(root == null){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null){
                count += count(root.children[i]);
            }
        }

        return count + 1;
    }

    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp) {
        if(root == null){
            return ;
        }

        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null && root.children[i].eof == true){
                char ch = (char)(i + 'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    
    public static void main(String[] args) {

        // String[] word = {"i","like","samsung","sam","hello"};
        String[] word = {"a","banana","app","apply","appl","ap"};

        // String[] word = {"the","this","there","thee","hello"};
        // String[] word = {"dog","dove","duck","zebra"};
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        // String key = "ababa";

        // System.out.println(search(key));
     
        // System.out.println("hello");
        // root.freq = -1;
        // System.out.println(wordBreak(key));
        // prefix(root, "");
        // System.out.println(prefix(root, key));
        // System.out.println(startWith( key));
        // for (int i = 0; i < key.length(); i++) {
        //     String suffix = key.substring(i);
        //     insert(suffix);
        // }
        // System.out.println(count(root));
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
