package Graph;
import java.util.*; 
public class Dijkstra_Matrix
{
    Scanner ob = new Scanner(System.in);
    int graph[][];

    Dijkstra_Matrix(int v)
    {
        graph = new int[v+1][v+1];
        for(int i=0; i<=v; i++)
            Arrays.fill(graph[i], -1);
    }

    private ArrayList<int[]> inputEdges(int e)
    {
        ArrayList<int[]> edges = new ArrayList<>();

        for(int i=0; i<e; i++)
        {
            int temp[] = new int[3]; 

            temp[0] = ob.nextInt();
            temp[1] = ob.nextInt();
            temp[2] = ob.nextInt();
        
            edges.add(temp);
        }
        return edges;
    }

    private void createGraph(int v, int e)
    {
        ArrayList<int[]> edges = inputEdges(e); 
        for(int i = 0; i < e; i++)
        {
            int t[] = edges.get(i); 
            graph[t[0]][t[1]] = t[2]; 
            graph[t[1]][t[2]] = t[2]; 
        }
    }

    private int dijkstra(int v, int src, int dest)
    {
        int distance[] = new int[v+1];
        int parent[] = new int[v+1];
        boolean visited[] = new boolean[v+1];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        Arrays.fill(distance, Integer.MAX_VALUE); 
        Arrays.fill(visited, false);
    
        minHeap.offer(new int[]{0, src});
        distance[src] = 0; 

        while(!minHeap.isEmpty())
        {
            int t[] = minHeap.poll();
            int currDistance = t[0];
            int currNode = t[1];

            if(currNode == dest)
                return currDistance; 
            
            if(!visited[currNode])
            {
                visited[currNode] = true; 

                for(int nbr =  1; nbr <= v; nbr++)
                {
                    if(graph[currNode][nbr] != -1 && currDistance + graph[currNode][nbr] < distance[nbr])
                    {
                        distance[nbr] = currDistance + graph[currNode][nbr];
                        parent[nbr] = currNode;
                        minHeap.offer(new int[]{distance[nbr], nbr});
                    }
                }                
            }
        }

        if(distance[dest] != Integer.MAX_VALUE)
            return distance[dest];

        return -1;
        // return distance[dest] if distance[dest] != math.inf else -1;
    }
    public static void main(String[] args) 
    {   
        Scanner ob = new Scanner(System.in);
        
        System.out.print("No. of vertices : ");
        int v = ob.nextInt();
        Dijkstra_Matrix dl = new Dijkstra_Matrix(v);

        System.out.print("No. of edges : ");
        int e = ob.nextInt();

        dl.createGraph(v, e);

        System.out.print("Source : ");
        int src = ob.nextInt();

        System.out.print("Destination : ");
        int dest = ob.nextInt();

        int minDistance = dl.dijkstra(v, src, dest); 

        System.out.println(minDistance);

        ob.close();
    }
}