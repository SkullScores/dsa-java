package 2D_Arrays.templates;

public class transposeOfMatrix 
{
    // General Approach (works for Rectangular & Square Matrices)
    // for Matrix of m x n, u make another n x m  for storage
    public int[][] transpose(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        int[][] temp = new int[n][m];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                temp[j][i] = grid[i][j];
            }
        }

        return temp;
    }

    // TC = O(n2)
    // SC = O(n2)

    // In-place Approach (works for Square Matrix)
    public int[][] transposeOfSquareMatrix(int[][] grid)
    {
        int n = grid.length;

        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int temp = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i] = temp;
            }
        }

        return grid;
    }

}
