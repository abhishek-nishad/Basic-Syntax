package Graph;
import java.util.*;
public class GraphMatrix_BFS
{
    static Scanner ob = new Scanner(System.in);

    private void inputMatrix(int matrix[][], int nodes)
    {
        for(int i=0; i<nodes; i++)
        {
            for(int j=0; j<nodes; j++)
            {
                matrix[i][j] = ob.nextInt();
            }
        }
    }

    private ArrayList<Integer> getBFS(int matrix[][], int nodes)
    {
        boolean visited[] = new boolean[nodes];
        Arrays.fill(visited, false);
        System.out.println(nodes);

        ArrayList<Integer> result = new ArrayList<>();
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
        return result;
    }
    public static void main(String[] args) 
    {
        System.out.print("No. of nodes : ");
        int no_of_nodes = ob.nextInt();

        int matrix[][] = new int[no_of_nodes][no_of_nodes];
        ArrayList<Integer> result = new ArrayList<>();

        GraphMatrix_BFS gm = new GraphMatrix_BFS();

        gm.inputMatrix(matrix, no_of_nodes);
        result = gm.getBFS(matrix, no_of_nodes);
        System.out.println(result);


        
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