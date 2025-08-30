import java.util.HashSet;
public class ValidSudoku 
{
    public static void main(String[] args) 
    {
        Solution sol = new Solution();
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        boolean isValid = sol.isValidSudoku(board);
        if (isValid) 
        {
            System.out.println("The Sudoku board is valid.");
        } 
        else 
        {
            System.out.println("The Sudoku board is NOT valid.");
        }
    }
}
class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        @SuppressWarnings("unchecked")
        HashSet<Character>[] rows = new HashSet[9];
        @SuppressWarnings("unchecked")
        HashSet<Character>[] cols = new HashSet[9];
        @SuppressWarnings("unchecked")
        HashSet<Character>[] boxes = new HashSet[9];


        for (int i = 0; i < 9; i++) 
        {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) 
        {
            for (int j = 0; j < 9; j++) 
            {
                char c = board[i][j];
                if (c == '.') continue;
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (rows[i].contains(c) || cols[j].contains(c) || boxes[boxIndex].contains(c)) 
                {
                    return false;
                }
                rows[i].add(c);
                cols[j].add(c);
                boxes[boxIndex].add(c);
            }
        }

        return true;
    }
}
