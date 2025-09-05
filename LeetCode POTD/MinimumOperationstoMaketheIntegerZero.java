public class MinimumOperationstoMaketheIntegerZero 
{

    static class Solution 
    {
        public int makeTheIntegerZero(int num1, int num2) 
        {
            for (int k = 1; k <= 60; k++) 
            {
                long S = (long) num1 - (long) k * num2;
                if (S < 0) continue;
                int bits = Long.bitCount(S);
                if (bits <= k && k <= S) 
                {
                    return k;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) 
    {
        Solution sol = new Solution();

        int num1 = 3, num2 = -2;
        System.out.println("Input: num1 = " + num1 + ", num2 = " + num2);
        System.out.println("Output: " + sol.makeTheIntegerZero(num1, num2));

        num1 = 5; 
        num2 = 2;
        System.out.println("\nInput: num1 = " + num1 + ", num2 = " + num2);
        System.out.println("Output: " + sol.makeTheIntegerZero(num1, num2));
    }
}
