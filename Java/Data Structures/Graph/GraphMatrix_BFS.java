package Graph;
import java.util.*;
public class GraphMatrix_BFS
{
    static Scanner ob = new Scanner(System.in);
    int matrix[][];
    ArrayList<Integer> result;

    GraphMatrix_BFS(int n)
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

    private void getBFS(int nodes)
    {
        boolean visited[] = new boolean[nodes];
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true; 
        
        while(!queue.isEmpty())
        {
            int currNode = queue.poll();
            result.add(currNode);

            for(int i=0; i<nodes; i++)
            {
                if(matrix[currNode][i] == 1 && !visited[i])
                {
                    visited[i] = true;
                    queue.add(i);
                }

            }
        }
    }

    private void displayResult()
    {
        System.out.println(result);
    }
    public static void main(String[] args) 
    {
        System.out.print("No. of nodes : ");
        int n = ob.nextInt();

        GraphMatrix_BFS bfs = new GraphMatrix_BFS(n);

        bfs.inputMatrix(n);
        bfs.getBFS(n);

        bfs.displayResult();
    }
}

/* example

[
    [0 1 1 0 0]
    [0 0 0 1 1]
    [0 0 0 0 0]
    [0 0 0 0 0]
    [0 0 0 0 0]


    [0, 1, 2, 3, 4]
]

*/