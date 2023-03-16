import java.io.*;
import java.util.*;
public class Solution 
{
    // ---------- CONSTANTS ----------

    final int MOD1 = 1000000007; 
    final int MOD2 = 998244353;
    final double PI = 3.14159265358979323846;

    // ---------- OBJECTS ----------

    static FastScanner ob = new FastScanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    static final Random random = new Random();


    // ---------- SOLVE FUNCTION ----------


    public void solve() throws IOException
    {  
       //write drive code here 
    }


    // ---------- TEMPLATES ----------


    private void swap(int arr[], int i, int j) { int t = arr[i]; arr[i] = arr[j]; arr[j] = t; }
    
    private void swap(long arr[], int i, int j) { long t = arr[i]; arr[i] = arr[j]; arr[j] = t; }

    private int gcd(int a, int b) { if (b == 0) return a; else return gcd(b, Math.abs(a - b)); }

    private int countTwos(int n) { int count = 0; while(n % 2 == 0) { ++count; n /= 2; } return count; }

    private void reverse(int arr[]) { int l = 0, r = arr.length-1; while(l < r) { swap(arr, l, r); l++; r--; } }

    private boolean isSorted(int arr[]) { for(int i=0; i<arr.length-1; i++) { if(arr[i] > arr[i+1]) return false; } return true; }

    private long arraySum(int arr[]) { long sum = 0; for(int val : arr) sum += val; return sum; }

    private long longArraySum(long arr[]) { long sum = 0; for(long val : arr) sum += val; return sum; }

    private int digitSum(int n){ int sum = 0; while(n > 0){ sum += n % 10; n /= 10; } return sum; }
    
    private int findMin(int arr[], int left, int right) { int minVal = Integer.MAX_VALUE; for(int i=left; i <= right; ++i) minVal = Math.min(minVal, arr[i]); return minVal; }

    private int findMax(int arr[], int left, int right) { int maxVal = Integer.MIN_VALUE; for(int i=left; i < right; ++i) maxVal = Math.max(maxVal, arr[i]); return maxVal; }

    private List<Long> findDivisors(long n)
    {
        List<Long> divisors = new ArrayList<>(); 
        for (long i=1; i <= (long)Math.sqrt(n); i++)
        {
            if (n%i == 0)
            {
                if (n/i == i)
                    divisors.add(i);
      
                else // Otherwise print both
                {
                    divisors.add(i); 
                    divisors.add(n/i);
                }
            }
        }
        return divisors; 
    }

    private long binPower(long a, long b)
    {
        long result = 1; 
        while(b > 0)
        {
            if((b & 1) == 1)
                result = (result * a) % MOD2;
            a = (a*a) % MOD2;  
            b >>= 1; 
        }
        return result % MOD2; 
    }

    private void ruffleSort(int arr[]) 
    {
        int n = arr.length;//shuffle, then sort 
        for (int i=0; i<n; i++) 
        {
            int oi = random.nextInt(n), 
            temp = arr[oi]; arr[oi] = arr[i]; arr[i] = temp;
        }
        Arrays.sort(arr);
    }

    private int lowerBound(List<Integer> array, int key)
    {

        int low = 0, high = array.size();
        int mid;

        while (low < high) 
        {
            mid = low + (high - low) / 2;
 
            if (key <= array.get(mid)) 
                high = mid;
            
            else 
                low = mid + 1;
        }

        if (low < array.size() && array.get(low) < key) 
            low++;
 
        return low;
    }

    // ---------- DRIVER CODE ----------

    public static void main(String[] args) throws IOException 
    {
        // ---------- driver template ----------

        if (System.getProperty("ONLINE_JUDGE") == null) 
        {    
            try 
            {
                ob = new FastScanner(new FileReader(new File("input.txt")));
                pw = new PrintWriter(new FileOutputStream("output.txt"));
                System.setOut(new PrintStream(new FileOutputStream("stdout.txt")));
            }
            catch (Exception e){}
        }

        int t = ob.nextInt();
        // int t = 1; 

        while (t-- > 0)
        {
            new Solution().solve();
        }

        // new Solution().solve();
        pw.close();
    }
}

// ---------- FAST SCANNER CLASS ----------

class FastScanner 
{

    private StringTokenizer st;
    private BufferedReader br;

    public FastScanner(InputStream s) { br = new BufferedReader(new InputStreamReader(s)); }

    public FastScanner(FileReader s) throws FileNotFoundException { br = new BufferedReader(s); }

    public String next() throws IOException 
    {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public int nextInt() throws IOException { return Integer.parseInt(next()); }

    public long nextLong() throws IOException { return Long.parseLong(next()); }

    public String nextLine() throws IOException { return br.readLine(); }

    public double nextDouble() throws IOException { return Double.parseDouble(next()); }

    public int[] readIntArray(int n) throws IOException 
    {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        return arr;
    }

    public long[] readLongArray(int n) throws IOException 
    {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextLong();
        return arr;
    }
    
    public boolean ready() throws IOException { return br.ready(); }
}


    // private int leet2098(int arr[], int n, int k)
    // {
    //     Arrays.sort(arr);
    //     reverse(arr);

    //     int maxSum = 0;
    //     int maxOdd = -1, maxEven = -1; 
    //     int minOdd = -1, minEven = -1;

    //     for(int i = 0; i < k; i++)
    //     {   
    //         maxSum += arr[i];

    //         if(arr[i] % 2 == 0)
    //             minEven = Math.min(arr[i], minEven);

    //         else
    //             minOdd = Math.min(arr[i], maxOdd);
    //     }
    //     // System.out.println(maxSum);
    //     if(maxSum % 2 == 0)
    //         return(maxSum); 

    //     for(int i=0; i < n-k; i++)
    //     {
    //         if(arr[i] % 2 == 0)
    //             maxEven = Math.max(maxEven, arr[i]);

    //         else
    //             maxOdd = Math.max(maxOdd, arr[i]);
    //     }

    //     int t1 = 0, t2 = 0;
    //     if(minEven != -1 && maxOdd != -1)
    //         t1 = maxSum - minEven + maxOdd;

    //     if(minOdd != -1 && maxEven != -1)
    //         t2 = maxSum - minOdd + maxOdd; 

    //     return Math.max(t1, t2);
    // }

// private void createGraph(long n, HashMap<Integer, List<Integer>> tree) throws IOException
//     {   
//         for(int i=0; i < n-1; i++)
//         {
//             int a = ob.nextInt();
//             int b = ob.nextInt();

//             tree.get(a).add(b); 
//             tree.get(b).add(a); 
//         }
//     }

//     private long dfs(int node, long p, long gp, long peers, HashMap<Integer, List<Integer>> tree, long c)
//     {
//         long result = Math.max(0, c - ((p == 0) ? 0 : 1) - ((gp == 0) ? 0 : 1) - peers); 
//         int parentSkipped = 0;

//         for(int i=0; i<tree.get(node).size(); i++)
//         {
//             if(tree.get(node).get(i) == p)
//             {
//                 parentSkipped = 1;
//                 continue;
//             }
//             result = (result * dfs(tree.get(node).get(i), node, p, i - parentSkipped, tree, c) % MOD1); 
//         }
//         return result % MOD1; 
//       }


