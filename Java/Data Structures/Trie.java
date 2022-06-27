import java.util.*; 
public class Trie 
{
    static TrieNode root = null;

    private void createTrie(String input[])
    {
        root = new TrieNode();

        for(int i=0; i<input.length; i++)
            insertString(input[i]);
    }

    private void insertString(String val)
    {
        int length = val.length();
        TrieNode currNode = root;
       
        for (int level = 0; level < length; level++)
        {
            int index = val.charAt(level) - 'a';
            if (currNode.alphabets[index] == null)
                currNode.alphabets[index] = new TrieNode();
       
            currNode = currNode.alphabets[index];
        }
        currNode.endOfWord = true;
    }

    public void display(TrieNode root, char str[], int level, ArrayList<String> result)
    {
        if (root.endOfWord != false) 
        {
            str[level] = '\0';
                result.add(String.valueOf(str));
        }
        for (int i = 0; i < 26; i++) 
        {
            if (root.alphabets[i] != null) 
            {
                str[level] = (char)(i + (int)'a');
                display(root.alphabets[i], str, level + 1, result);
            }
        }
    }
    public static void main(String[] args) 
    {
        Trie trie = new Trie();
        Scanner ob = new Scanner(System.in);

        System.out.println("Enter strings : ");
        String input[] = ob.nextLine().split(" ");
        trie.createTrie(input);

        ArrayList<String> result = new ArrayList<>();
        int level = 0; 
        trie.display(root, new char[50], level, result);
        System.out.println(result);
        ob.close();
    }
}


