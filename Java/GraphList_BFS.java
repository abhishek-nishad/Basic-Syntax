import java.util.*;
public class GraphList_BFS
{   
    static Scanner ob = new Scanner(System.in);

    private void inputEdges(ArrayList<int[]> edges)
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

    private void createGraph(HashMap<Integer, ArrayList<Integer>> graph, ArrayList<int[]> edges, int n)
    {
        for(int i=1; i<=n; i++)
            graph.put(i, new ArrayList<Integer>());
        
        for(int[] temp : edges)
            graph.get(temp[0]).add(temp[1]);
        
    }

    private ArrayList<Integer> getBFS(HashMap<Integer, ArrayList<Integer>> graph, int n)
    {
        boolean visited[] = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        Arrays.fill(visited, false);

        visited[1] = true; 
        queue.add(1);

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
        return result;
    }
    public static void main(String[] args)
    {
        ArrayList<int[]> edges = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        GraphList_BFS gl = new GraphList_BFS();

        System.out.print("No. of nodes : ");
        int n = ob.nextInt();

        //  example : len = 7, edges = [[1,2], [1,3], [2, 4], [2, 5], [3, 8], [5, 6], [6, 7]]
        gl.inputEdges(edges);
        gl.createGraph(graph, edges, n);

        result = gl.getBFS(graph, n);

        System.out.println(result);
    }
}
