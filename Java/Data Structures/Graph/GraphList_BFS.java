package Graph;
import java.util.*;
public class GraphList_BFS
{   
    static Scanner ob = new Scanner(System.in);
    HashMap<Integer, ArrayList<Integer>> graph;
    ArrayList<int[]> edges;
    ArrayList<Integer> result;

    GraphList_BFS(int n)
    {
        graph = new HashMap<>(); 
        edges = new ArrayList<>(); 
        result = new ArrayList<>(); 

        for(int i=0; i <= n; i++)
            graph.put(i, new ArrayList<>());

    }

    private void inputEdges()
    {
        System.out.print("No. of edges : ");
        int no_of_edges = ob.nextInt();

        for(int i=0; i<no_of_edges; i++)
        {
            int a = ob.nextInt();
            int b = ob.nextInt();
            edges.add(new int[]{a, b});
        }       
    }

    private void createGraph()
    {   
        for(int[] temp : edges)
            graph.get(temp[0]).add(temp[1]); 
    }

    private void displayResult()
    {
        System.out.println("\nGraph : " + graph + "\n");
        System.out.println("BFS traversal : " + result + "\n");
    }

    private void getBFS(int n, int source)
    {
        boolean visited[] = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = true; 
        queue.add(source);

        while(!queue.isEmpty())
        {
            int currNode = queue.remove();
            result.add(currNode);

            for(int adj : graph.get(currNode))
            {
                if(!visited[adj])
                {
                    visited[adj] = true; 
                    queue.add(adj);
                }
            }
        }
    }
    public static void main(String[] args)
    {
        System.out.print("No. of nodes : ");
        int n = ob.nextInt();

        GraphList_BFS bfs = new GraphList_BFS(n);

        //  example : len = 7, edges = [[1,2], [1,3], [2, 4], [2, 5], [3, 6], [5, 7], [7, 8]]
        bfs.inputEdges();
        bfs.createGraph();

        System.out.print("Input Source : ");
        int source = ob.nextInt();
        bfs.getBFS(n, source);

        bfs.displayResult();
    }
}
