import java.util.*; 
public class Trie 
{
    static TrieNode root;
    static Scanner ob = new Scanner(System.in);
    private String[] getInput()
    {
        return ob.nextLine().split(" ");
    }

    private TrieNode createTrie(String input[])
    {
        TrieNode currRoot = null;
        return currRoot;
    }

    public static void main(String[] args) 
    {
        Trie trie = new Trie();
        String input[] = trie.getInput();
        root = trie.createTrie(input);
    }
}
