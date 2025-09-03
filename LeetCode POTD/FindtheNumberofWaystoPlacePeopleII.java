class Solution 
{
    public int numberOfPairs(int[][] points) 
    {
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if (points[i][0] > points[j][0] ||
                   (points[i][0] == points[j][0] && points[i][1] < points[j][1])) 
                   {
                    int tempX = points[i][0];
                    int tempY = points[i][1];
                    points[i][0] = points[j][0];
                    points[i][1] = points[j][1];
                    points[j][0] = tempX;
                    points[j][1] = tempY;
                }
            }
        }
        for (int i = 0; i < n; i++) 
        {
            int ax = points[i][0], ay = points[i][1];
            for (int j = i + 1; j < n; j++) 
            {
                int bx = points[j][0], by = points[j][1]; 
                if (ax <= bx && ay >= by) 
                {
                    boolean valid = true;

                    for (int k = 0; k < n; k++) 
                    {
                        if (k != i && k != j) 
                        {
                            int x = points[k][0], y = points[k][1];
                            if (ax <= x && x <= bx && by <= y && y <= ay) 
                            {
                                valid = false;
                                break;
                            }
                        }
                    }

                    if (valid) ans++;
                }
            }
        }

        return ans;
    }
}
public class FindtheNumberofWaystoPlacePeopleII 
{
    public static void main(String[] args) 
    {
        Solution sol = new Solution();

        int[][] points1 = {{1,1},{2,2},{3,3}};
        System.out.println(sol.numberOfPairs(points1)); 

        int[][] points2 = {{6,2},{4,4},{2,6}};
        System.out.println(sol.numberOfPairs(points2)); 
    }
}

