public class MinimumOperationstoMakeArrayElementsZero 
{
    public long minOperations(int[][] queries) 
    {
        long total = 0L;
        for (int[] q : queries) 
        {
            int l = q[0];
            int r = q[1];
            long sumSteps = sumStepsRange(l, r);
            total += (sumSteps + 1) / 2;
        }
        return total;
    }
    private long sumStepsRange(long l, long r) 
    {
        if (l > r) return 0L;
        long sum = 0L;
        long lower = 1L; 
        int k = 1;
        while (lower <= r) 
        {
            long upper = lower * 4L - 1L;
            long from = Math.max(l, lower);
            long to = Math.min(r, upper);
            if (from <= to) 
            {
                sum += (to - from + 1L) * (long) k;
            }
            if (lower > r / 4L) break;
            lower *= 4L;
            k++;
        }
        return sum;
    }
    public static void main(String[] args) 
    {
        MinimumOperationstoMakeArrayElementsZero solver = new MinimumOperationstoMakeArrayElementsZero();
        int[][] queries = { {1, 2}, {2, 4}, {1, 8} };
        System.out.println(solver.minOperations(queries)); 
        
    }
}
