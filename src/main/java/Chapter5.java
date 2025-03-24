import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import java.lang.reflect.Array;
import java.util.*;

public class Chapter5 {
    public static int countPrimes(int n){
        int count=0;
        for(int i=2; i<=n ; i++)
            if(isPrime(i)) count++;

        return count;
    }

    public static boolean isPrime(int num){
        int end = (int) Math.sqrt(num);
        for(int i=2; i <=  end; i++){
            if(num%i == 0)
                return false;
        }
        return true;
    }

    public static int countPrimes2(int n){
        boolean[] isPrime = new boolean[n+1];

        Arrays.fill(isPrime, true);
        for(int i=2; i*i <= n; i++ ){
            if(isPrime[i]){
                for(int j=i*2; j<=n ; j = j+i)
                    isPrime[j] = false;
            }
        }

        int count=0;
        for(int i =2; i <= n; i++)
            if(isPrime[i]) count++;

        return count;
    }
    static int base = 1237;
    public static int superPow(int a, Stack<Integer> b){
        //a^b[n-1]* superPow(a, b)^10
        if(b.empty())
            return 1;

        int result1 = mypow(a, b.pop());
        int result2 = mypow(superPow(a, b), 10);
        return (result1*result2) % base;
    }

    public static int mypow(int a, int pow){
        // (a*b)% c = a%c * b%c %c
        if(pow ==0)
            return a % base;

        int result= 1;
        for(int i=0; i<pow; i++){
            result = result * a;
            result %= base;
        }
        return result;
    }


    public static int minEatingSpeed(int[] piles, int H) {
        int max = Arrays.stream(piles).max().getAsInt();
        int result = -1;
        for (int i = 1; i <= max; i++) {
            if (canFinish(piles, H, i)) {
                return i;
            }

        }
        return result;

    }

    public static int minEatingSpeed2(int[] piles, int H){
        int max = Arrays.stream(piles).max().getAsInt();
        int left = 0;
        int right = piles.length + 1;
        while(left < right){
            int mid = left+(right-left)/2;
            if (canFinish(piles, H, mid)) {
                right = mid;
            }else
                left = mid+1;

        }
        return left;
    }

    public static boolean canFinish(int[] piles, int H, int speed){
        int remain = H;
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i< piles.length; i++)
            stk.push(piles[i]);

        while(remain > 0 && !stk.empty()){
            int pileNum = stk.pop();
            if( pileNum > speed){
                stk.push(pileNum-speed);
            }
            remain--;
        }

        if(remain >= 0 && stk.empty())
            return true;
        return false;
    }

    public static int shipWithinDays(int[] weights, int days){
        int right= Arrays.stream(weights).sum() + 1;
        int left= Arrays.stream(weights).max().getAsInt();

        while(left < right){
            int cap = left + (right - left)/2;
            if(canShip(weights, days, cap)){
                right = cap;
            } else
                left = cap + 1;
        }
        return left;
    }

    public static boolean canShip(int[] weights, int days, int cap){
        int i = 0;
        for (int day = 0; day < days; day++){
            int tmpCap = cap;
            while((tmpCap -= weights[i]) >= 0){
                i++;
                if(i==weights.length)
                    return true;
            }
        }
        return false;
    }

    //dp[p] least number: num
    //dp[n-1] = 0
    //dp[n-2] = 1
    //dp[n-3] min(dp[n-2]+1, num[n-3]> 2? 1)
    public static int dp(int[] nums){
        int n = nums.length;
        if(n == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[n-1] = 0;

        for(int i=n-2; i>=0; i--){
            int rslt = Integer.MAX_VALUE;
            for(int j=1; j<=nums[i];j++){
                if(i+j >= n-1)
                    rslt = 1;
                if(rslt > dp[i+j])
                    rslt = dp[i+j]+1;
            }
            dp[i] = rslt;
        }

        return dp[0];
    }

    public static int intervalSchedule(int[][] intvs){
        if(intvs.length == 0) return 0;

        Arrays.sort(intvs, Comparator.comparingInt(o -> o[1]));
        int end = intvs[0][1];
        int count = 1;

        for(int[] interval : intvs){
            int start = interval[0];
            if(start >= end){
                count++;
                end = interval[1];
            }
        }
        return count;
    }

    void dfs(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;

        if(i<0 || j<0 || i >= m || j >= n)
            return;

        if(board[i][j] != '0')
            return;

        board[i][j] = '#';
        dfs(board, i+1, j);
        dfs(board, i, j+1);
        dfs(board, i-1, j);
        dfs(board, i, j-1);
    }

    void solution(char[][] board) {
        if(board.length ==0)
            return;
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; i++){
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }

        for(int j=0; j < n; j++){
            dfs(board, 0, j);
            dfs(board, m-1, j);
        }

        for(int i=1; i< m-1; i++)
            for(int j=1; j< n-1; j++){
                if(board[i][j] == '0')
                    board[i][j] = 'X';
            }
        for(int i=0; i< m; i++)
            for(int j=0; j< n; j++){
                if(board[i][j] == '#')
                    board[i][j] = '0';
            }
    }

    void solution2(char[][] board){
        if(board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        Chapter5UnionFind uf = new Chapter5UnionFind(n*m + 1);
        int dummy = m*n;

        for(int i=0; i < m; i++){
            if(board[i][0] == '0')
                uf.union(i*n, dummy);
            if(board[i][n-1] == '0')
                uf.union(i*n+n-1, dummy);
        }

        for(int j=0; j < n; j++){
            if(board[0][j] == '0')
                uf.union(j, dummy);
            if(board[m-1][j] == '0')
                uf.union((m-1)*n+j, dummy);
        }

        int[][] d = new int[][]{{1,0}, {0,1},{0,-1}, {-1,0}};
        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(board[i][j]=='0'){
                    for(int k=0; k<4; k++){
                        int x = i+d[k][0];
                        int y = j+d[k][1];
                        if(board[x][y] == '0')
                            uf.union(x*n+y, i*n+j);
                    }
                }

            }

        }

        for(int i=1; i< m-1; i++){
            for(int j=1; j<n-1; j++)
                if(!uf.connected(dummy, i*n+j))
                    board[i][j] ='X';

        }
    }

    boolean equationsPossible(String[] equations) {
        Chapter5UnionFind uf = new Chapter5UnionFind(26);
        for(String eq: equations){
            if(eq.charAt(1) =='='){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x-'a', y-'a');
            }
        }

        for(String eq : equations){
            if(eq.charAt(1) =='!'){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if(uf.connected(x-'a', y-'a'))
                    return false;
            }
        }
        return true;

    }

    // water[i] = min(left_max, right_max) - height[i]

    public static int trap(int[] height){
        int n = height.length;
        int ans = 0;

        for(int i=1; i<n-1; i++){
            int l_max = 0, r_max = 0;
            for(int j=i; j >= 0; j--){
                l_max = Math.max(height[j], l_max);
            }

            for(int j=i;j < n; j++){
                r_max = Math.max(r_max, height[j]);
            }
            ans += Math.min(l_max, r_max) - height[i];
        }
        return ans;
    }

    public static int trap2(int[] height){
        if(height.length == 0)
            return 0;

        int n = height.length;
        int ans = 0;
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];

        int ltmp = 0;
        int rtmp = 0;
        for(int i=0; i<height.length; i++){
            if(height[i] > ltmp){
                ltmp = height[i];
            }
            lMax[i] = ltmp;
        }

        for(int i=n-1; i>=0; i--){
            if(height[i] > rtmp){
                rtmp = height[i];
            }
            rMax[i] = rtmp;
        }


        for(int i=1; i<n-1; i++){
            ans += Math.min(lMax[i], rMax[i]) - height[i];
        }

        return ans;
    }

    public static int trap3(int[] height){
        if(height.length == 0)
            return 0;

        int lMax = height[0];
        int rMax = height[height.length-1];
        int right = height.length -2;
        int left = 1;
        int ans = 0;
        while(left <= right){
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);

            if(lMax <= rMax){
                ans += lMax - height[left];
                left++;
            } else {
                ans += rMax - height[right];
                right--;
            }
        }
        return ans;
    }

    public static int removeDuplicates(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;
        int slow = 0;
        int fast = 1;

        while(fast < nums.length){
            if(nums[slow]!=nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

    public static String palindrome(String str, int l , int r){
        while(l>=0 && r < str.length()){
            if(str.charAt(l)==str.charAt(r)){
                l--;
                r++;
            } else
                break;
        }

        return str.substring(l+1, r-l-1);
    }

    public static String longestPalindrome(String str){
        String res ="";

        for(int i=0; i<str.length(); i++){
            String s1 = palindrome(str, i, i);
            String s2 = palindrome(str, i, i+1);
            res = s1.length()>res.length()? s1 : res;
            res = s2.length()>res.length()? s2 : res;
        }

        return res;
    }

    //dp[i]-> di[i+1...dp[i]]
    public static boolean canJump(int[] nums, int index, Map<Integer, Boolean> mem){
        if(index >= nums.length-1)
            return true;
        for(int i=1; i<= nums[nums[index]]; i++){
            if(mem.containsKey(index+i))
                return mem.get(index+i);
            else {
                boolean rslt = canJump(nums, index + i, mem);
                mem.put(index, rslt);
                return rslt;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] piles = {3,2,1,1,4};

        System.out.println(canJump(piles, 0, new HashMap<Integer, Boolean>()));

    }
}
