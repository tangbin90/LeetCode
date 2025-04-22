package leetcodesolutions;

public class NO174_DungeonGame {
  public int calculateMinimumHP(int[][] dungeon) {
    int m = dungeon.length;
    int n = dungeon[0].length;

    // dp[i][j] represents the minimum health needed to reach the bottom-right corner from cell (i, j)
    int[][] dp = new int[m][n];

    // Start from the bottom-right corner
    dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

    // Fill the last row
    for (int i = m - 2; i >= 0; i--) {
        dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
    }

    // Fill the last column
    for (int j = n - 2; j >= 0; j--) {
        dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
    }

    // Fill the rest of the dp table
    for (int i = m - 2; i >= 0; i--) {
        for (int j = n - 2; j >= 0; j--) {
            int down = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
            int right = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
            dp[i][j] = Math.min(down, right);
        }
    }

    // The top-left cell contains the minimum health needed to start
    return dp[0][0];
}
}
