public class AliceandBobPlayingFlowerGame 
{
    public static void main(String[] args) 
    {
        Solution sol = new Solution();
        int n = 3, m = 2;
        System.out.println(sol.flowerGame(n, m)); 
    }
}

class Solution {
    public long flowerGame(int n, int m) 
    {
        long oddX = (n + 1) / 2;   
        long evenX = n / 2;        
        long oddY = (m + 1) / 2;   
        long evenY = m / 2;        

        return (oddX * evenY) + (evenX * oddY);
    }
}
