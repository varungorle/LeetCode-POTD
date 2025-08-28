public class SortMatrixbyDiagonals 
{
    public int[][] sortMatrix(int[][] grid) 
    {
        int n = grid.length;
        for (int row = 0; row < n; row++) 
        {
            sortDiagonal(grid, row, 0, n);
        }
        for (int col = 1; col < n; col++) 
        {
            sortDiagonal(grid, 0, col, n);
        }
        return grid;
    }

    private void sortDiagonal(int[][] grid, int row, int col, int n) 
    {
        int len = Math.min(n - row, n - col);
        int[] diag = new int[len];
        int r = row, c = col;
        for (int i = 0; i < len; i++) 
        {
            diag[i] = grid[r++][c++];
        }
        selectionSort(diag);
        if (row - col >= 0) 
        {
            reverse(diag);
        }
        r = row; c = col;
        for (int i = 0; i < len; i++) 
        {
            grid[r++][c++] = diag[i];
        }
    }

    private void selectionSort(int[] arr) 
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) 
            {
                if (arr[j] < arr[minIndex]) 
                {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    private void reverse(int[] arr) 
    {
        int i = 0, j = arr.length - 1;
        while (i < j) 
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // ✅ main method
    public static void main(String[] args) 
    {
        SortMatrixbyDiagonals sol = new SortMatrixbyDiagonals();

        int[][] grid = {
            {4, 3, 2},
            {1, 5, 6},
            {9, 8, 7}
        };

        System.out.println("Original Matrix:");
        printMatrix(grid);

        sol.sortMatrix(grid);

        System.out.println("\nSorted Matrix:");
        printMatrix(grid);
    }

    private static void printMatrix(int[][] grid) 
    {
        for (int[] row : grid) 
        {
            for (int val : row) 
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
