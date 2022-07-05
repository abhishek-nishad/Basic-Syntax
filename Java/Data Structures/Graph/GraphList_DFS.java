package Graph;
import java.util.*;
public class GraphList_DFS
{   
    static Scanner ob = new Scanner(System.in);
    HashMap<Integer, ArrayList<Integer>> graph;
    ArrayList<int[]> edges;
    ArrayList<Integer> result;

    GraphList_DFS(int n)
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

    private void getDFS(int n, int node)
    {
        boolean visited[] = new boolean[n+1];
        Arrays.fill(visited, false);

        visited[node] = true; 
        result.add(node);

        for(int adj : graph.get(node))
        {
            if(!visited[adj])
            {
                getDFS(n, adj);
            }
        }
    }
    
    private void displayResult()
    {
        System.out.println("\nGraph : " + graph + "\n");
        System.out.println("DFS traversal : " + result + "\n");
    }
    public static void main(String[] args)
    {
        System.out.print("No. of nodes : ");
        int n = ob.nextInt();
        GraphList_DFS dfs = new GraphList_DFS(n);

        //  example : len = 7, edges = [[1,2], [1,3], [2, 4], [2, 5], [3, 8], [5, 6], [6, 7]]
        dfs.inputEdges();
        dfs.createGraph();

        System.out.print("Input Source : ");
        int source = ob.nextInt(); 
        dfs.getDFS(n, source);
        dfs.displayResult();
    }
}
