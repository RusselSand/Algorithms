import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
public class Crib {
    public static Trie trie;
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String init = reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            trie = new Trie();
            for (int i = 0; i < n; i++) {
                trie.insert(reader.readLine());
            }
            if(check(init)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static boolean check(String init){
        char[] letters = init.toCharArray();
        boolean[] dp = new boolean[letters.length + 1];
        dp[0] = true;
        for (int i = 1; i <= letters.length; i++) {
            if(dp[i - 1]){
                TrieNode current = trie.getRoot();
                for (int j = i; j <= letters.length ; j++) {
                    char letter = letters[j - 1];
                    current = current.getChildren().get(letter);
                    if(current != null){
                        if(current.isWord()) {
                            dp[j] = true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return dp[letters.length];
    }
    public static class Trie {
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode current = root;
            for(char letter: word.toCharArray()){
                current = current.getChildren().computeIfAbsent(letter, t -> new TrieNode());
            }
            current.setWord(true);
        }

        public TrieNode getRoot() {
            return root;
        }
    }


    public static class TrieNode {
        private HashMap<Character, TrieNode> children;
        private boolean isWord;
        public TrieNode(){
            children = new HashMap<>();
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }
}
