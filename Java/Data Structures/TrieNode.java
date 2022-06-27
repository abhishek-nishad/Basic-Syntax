import java.util.Arrays;
public class TrieNode 
{
    int alphabets[]; 
    boolean endOfWord; 
    
    TrieNode()
    {
        this.alphabets = new int[27]; 
        this.endOfWord = false; 
        Arrays.fill(alphabets, 0);
    }
}
