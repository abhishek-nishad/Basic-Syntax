import java.util.Arrays;
public class TrieNode 
{
    TrieNode[] alphabets; 
    boolean endOfWord; 
    
    TrieNode()
    {
        this.alphabets = new TrieNode[26]; 
        this.endOfWord = false; 
        Arrays.fill(alphabets, null);
    }
}
