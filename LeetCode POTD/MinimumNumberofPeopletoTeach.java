public class MinimumNumberofPeopletoTeach 
{
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) 
    {
        int m = languages.length;
        boolean[][] userLang = new boolean[m][n + 1];
        for (int i = 0; i < m; i++) 
        {
            for (int lang : languages[i]) 
            {
                userLang[i][lang] = true;
            }
        }
        boolean[] toTeach = new boolean[m];
        int toTeachCount = 0;
        for (int[] f : friendships) 
        {
            int u = f[0] - 1;
            int v = f[1] - 1;
            boolean canCommunicate = false;
            for (int lang = 1; lang <= n; lang++) 
            {
                if (userLang[u][lang] && userLang[v][lang]) 
                {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) 
            {
                if (!toTeach[u]) 
                {
                    toTeach[u] = true;
                    toTeachCount++;
                }
                if (!toTeach[v]) 
                {
                    toTeach[v] = true;
                    toTeachCount++;
                }
            }
        }
        if (toTeachCount == 0) return 0;
        int[] count = new int[n + 1];
        for (int u = 0; u < m; u++) 
        {
            if (toTeach[u]) 
            {
                for (int lang = 1; lang <= n; lang++) 
                {
                    if (userLang[u][lang]) 
                    {
                        count[lang]++;
                    }
                }
            }
        }
        int maxKnown = 0;
        for (int lang = 1; lang <= n; lang++) 
        {
            if (count[lang] > maxKnown) 
            {
                maxKnown = count[lang];
            }
        }
        return toTeachCount - maxKnown;
    }
    public static void main(String[] args) {
        MinimumNumberofPeopletoTeach sol = new MinimumNumberofPeopletoTeach();
        int n = 2;
        int[][] languages = {{1}, {2}, {1,2}};
        int[][] friendships = {{1,2}, {1,3}, {2,3}};
        System.out.println(sol.minimumTeachings(n, languages, friendships));
    }
}
