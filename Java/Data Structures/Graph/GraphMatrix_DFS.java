package Graph;
import java.util.*;
public class GraphMatrix_DFS
{
    static Scanner ob = new Scanner(System.in);
    int matrix[][];
    ArrayList<Integer> result;

    GraphMatrix_DFS(int n)
    {
        matrix = new int[n+1][n+1];
        result = new ArrayList<>();
    }
    private void inputMatrix(int nodes)
    {
        for(int i=0; i <= nodes; i++)
        {
            for(int j=0; j <= nodes; j++)
            {
                matrix[i][j] = ob.nextInt();
            }
        }
    }

    private void getDFS(int n, int node, boolean[] visited)
    {
        visited[node] = true; 
        result.add(node);

        for(int i=0; i<=n; i++)
        {
            if(matrix[node][i] == 1 && !visited[i])
                getDFS(n, i, visited);      
        }
    }

    private void displayResult()
    {
        System.out.println("DFS traversal : " + result + "\n");
    }
    public static void main(String[] args) 
    {
        System.out.print("No. of nodes : ");
        int n = ob.nextInt();

        GraphMatrix_DFS dfs = new GraphMatrix_DFS(n);

        dfs.inputMatrix(n);

        System.out.print("Enter source : ");
        int source = ob.nextInt(); 

        boolean visited[] = new boolean[n+1];
        Arrays.fill(visited, false);
        dfs.getDFS(n, source, visited);

        dfs.displayResult();
    }
}

/* example

[
    0 0 0 0 0 0 0
    0 0 1 1 0 0 0
    0 1 0 0 1 1 0
    0 1 0 0 0 0 1
    0 0 1 0 0 0 0
    0 0 1 0 0 0 0
    0 0 1 0 0 0 0
    
]

    [1, 2, 4, 3, 5, 6]


*/