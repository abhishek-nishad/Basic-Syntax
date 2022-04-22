import java.util.*;
public class GraphMatrix_BFS
{
    static Scanner ob = new Scanner(System.in);

    private void inputMatrix(int matrix[][], int nodes)
    {
        for(int i=1; i<=nodes; i++)
        {
            for(int j=1; j<=nodes; j++)
            {
                matrix[i][j] = ob.nextInt();
            }
        }
    }

    private ArrayList<Integer> printBFS(int matrix[][], int nodes)
    {
        
    }
    public static void main(String[] args) 
    {
        int no_of_nodes = ob.nextInt();
        int matrix[][] = new int[no_of_nodes + 1][no_of_nodes + 1];

        GraphMatrix_BFS gm = new GraphMatrix_BFS();

        gm.inputMatrix(matrix, no_of_nodes);
    }
}