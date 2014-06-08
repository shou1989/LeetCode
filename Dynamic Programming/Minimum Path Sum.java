public class Solution {
    public static int minPathSum(int[][] grid) {  
        int i, j, dp[][] = new int[grid.length][grid[0].length];  
        int col, row;  
  
        // initial variable  
        row = grid.length;  
        col = grid[0].length;  
  
        // initial dp array  
        dp[0][0] = grid[0][0];  
        for (i = 1; i < row; i++) {  
            dp[i][0] = dp[i - 1][0] + grid[i][0];  
        }  
        for (j = 1; j < col; j++) {  
            dp[0][j] = dp[0][j - 1] + grid[0][j];  
        }  
  
        // dynamic process, dp[i][j] = MIN{dp[i - 1][j], dp[i][j - 1]} + grid[i][j]  
        for (i = 1; i < row; i++) {  
            for (j = 1; j < col; j++) {  
                dp[i][j] =  
                        dp[i - 1][j] <= dp[i][j - 1] ? dp[i - 1][j] + grid[i][j] : dp[i][j - 1]  
                                + grid[i][j];  
            }  
        }  
  
        return dp[row - 1][col - 1];  
    } 
}