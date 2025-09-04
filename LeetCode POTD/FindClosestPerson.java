public class FindClosestPerson 
{
    static class Solution 
    {
        public int findClosest(int x, int y, int z)
         {
            int distance1 = Math.abs(x - z);
            int distance2 = Math.abs(y - z);

            if (distance1 < distance2) 
            {
                return 1; 
            }
             else if (distance2 < distance1) 
            {
                return 2; 
            } 
            else 
            {
                return 0; 
            }
        }
    }

    public static void main(String[] args) 
    {
        Solution sol = new Solution();
        System.out.println(sol.findClosest(2, 7, 4)); 
    }
}
