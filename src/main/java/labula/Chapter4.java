package labula;

import java.util.*;

public class Chapter4 {

    List<List<Integer>> subsets(int[] nums){

        List<List<Integer>> rslt = new LinkedList<>();
        rslt.add(new LinkedList<>());
        for(int i=0; i<nums.length; i++){
            for(List<Integer> li : rslt){
                List<Integer> newLi = new ArrayList<Integer>(li);
                newLi.add(nums[i]);
                rslt.add(newLi);
            }
        }
        return rslt;
    }

    List<List<Integer>> subSets2(int[] nums, int end){
        if(end==-1)
            return new ArrayList<>();

        int tmp = nums[end];
        List<List<Integer>> intLists = subSets2(nums, end-1);

        for(List<Integer> li : intLists){
            List<Integer> tt = new ArrayList<>(li);
            tt.add(tmp);
            intLists.add(tt);
        }

        return intLists;
    }

    List<List<Integer>> reslt = new LinkedList<>();
    void subSets3(int[] nums, int start, List<Integer> track){
        reslt.add(new ArrayList<>(track));

        for(int i=0; i < nums.length; i++){
            track.add(nums[i]);
            subSets3(nums, i+1, track);
            track.remove(nums[i]);
        }
    }

    List<List<Integer>> rslt2 = new LinkedList<>();

    List<List<Integer>> combine(int n, int k){
        backTrack(n,  1,  k, new LinkedList<>());
        return rslt2;
    }

    void backTrack(int n, int start, int k, List<Integer> track){
        if(track.size() == k) {
            rslt2.add(new ArrayList<Integer>(track));
            return;
        }

        for(int i=start; i <=n ; i ++){
            track.add(i);
            backTrack(n, start+1, k,  track);
            track.remove(i);
        }
    }

    public static List<List<Integer>> rslt3 = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums){

        HashSet<Integer> hset = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            hset.add(nums[i]);
        }
        backTrack(hset, new ArrayList<>(), nums.length);
        return rslt3;
    }


    public static void backTrack(Set<Integer> nums, List<Integer> track, int length){
        if(track.size() == length) {
            rslt3.add(new ArrayList<Integer>(track));
            return;
        }

        for(Integer num : nums){
            if(track.contains(num))
                continue;
            track.add(num);
            backTrack(nums, track, length);
            track.remove(num);
        }
    }

    public static void solveSudoku(char[][] board){

    }

    public boolean backtackSudoku(char[][] board, int i , int j){
        if(j == board.length){
            return backtackSudoku(board, i+1, 0);
        }

        if(i == board.length)
            return true;

        if(board[i][j] != '.'){
            return backtackSudoku(board, i, j+1);

        }

        for(char c = '0'; c<='9'; c++){
            if(!isValid(board, i, j, c))
                continue;

            board[i][j] = c;
            backtackSudoku(board, i, j+1);
            board[i][j] = '.';

        }
        return false;
    }

    public static boolean isValid(char[][] board, int r, int k, char ch){
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i< m; i++){
            if(board[r][i] == n) return false;
            if(board[i][k] == n) return false;

            if(board[(r/3)*3 + i/3][(k/3)*3 + i%3]==n)
                return false;
        }
        return true;
    }

    public static void printSudoku(char[][] board){
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static List<String> rslt = new LinkedList<>();
    public static List<String> generateParenthesis(int n){
        backTrackParenthesis(n, new StringBuilder());
        return rslt;
    }

    public static void backTrackParenthesis(int n, StringBuilder track){
        if(track.length()== 2*n) {
            rslt.add(track.toString());
            return;
        }
        String[] strs = {"(", ")"};
        for(String str : strs){
            track.append(str);
            backTrackParenthesis(n, track);
            track.delete(track.length()-1, track.length());
        }
    }

    public static void backTrackParenthesis2(int left, int right,StringBuilder track){
        if(left < 0 || right < 0)
            return;

        if(left == 0 && right ==0) {
            rslt.add(track.toString());
            return;
        }

        if(left > right)
            return;


        track.append("(");
        backTrackParenthesis2(left - 1, right, track);
        track.delete(track.length() - 1, track.length());


        track.append(")");
        backTrackParenthesis2(left, right-1, track);
        track.delete(track.length() - 1, track.length());


    }



    int[][] neighbor = {{1,3},{0,4,2},{1,5},{0,4},{3,1,5}};

    int slidingPuzzle(int[][] board){
        int m=2, n=3;
        StringBuilder track = new StringBuilder();
        String target = "123450";
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                track.append(board[i][j]);
            }
        }

        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.add(track.toString());
        Set<String> visited = new HashSet<>();
        visited.add(track.toString());
        while(!q.isEmpty()){
            String tmp = q.poll();
            if(tmp.equals(target))
                return step;

            int idx = 0;
            for(; tmp.charAt(idx)!='0'; idx++);

            int[] neibour =neighbor[idx];
            for(int i=0; i< neibour.length; i++){
                char[] chs = tmp.toCharArray();
                chs[idx]=chs[neibour[i]];
                chs[neibour[i]] = '0';
                String str =new String(chs);
                if(!visited.contains(str)) {
                    q.add(str);
                    visited.add(str);
                }
            }
            step++;
        }
        return -1;

    }
//4.5 two sum
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> store = new HashMap<>();
        int[] result = {-1, -1};
        for(int i=0; i< nums.length; i++){
            if(store.containsKey(target- nums[i])) {
                result[0] = i;
                result[1] = store.get(target - nums[i]);
                return result;
            }
            else
                store.put(target-nums[i], i);
        }
        return result;
    }


    //4.6 nSum
    public static int[] twoSum2(int[] nums, int target){
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums.length - 1;

        while(lo < hi){
            int sum = nums[lo] + nums[hi];

            if(sum < target){
                lo++;
            } else if(sum > target){
                hi--;
            }else if(sum == target){
                return new int[]{nums[lo], nums[hi]};
            }
        }
        return new int[]{};
    }


    public static boolean isDigit(char c){
        if(c >= '0' && c <= '9')
            return true;

        return false;
    }
    public static int calculate(String s, int start, int end){
        Stack<Integer> stack = new Stack<>();
        int num =0;
        int sign ='+';
        for(int i=start; i < end; i++){
            char c = s.charAt(i);
            if(isDigit(c)){
                num = 10 * num + (c -'0');
            }
            if(c=='(') {
                for(int j = end-1; j>start; j--){
                    if(s.charAt(j)==')') {
                        num = calculate(s, i+1, j+1);
                        stack.push(num);
                        i = j;
                        break;
                    }
                }
                continue;
            }

            if((!isDigit(c)&& c != ' ') || i == s.length()-1){
                switch (sign){
                    case '+': stack.push(num); break;
                    case '-': stack.push(-1*num); break;
                    case '*':
                        int tmp = stack.pop();
                        stack.push(tmp * num);
                        break;
                    case '/':
                        int tmp2 = stack.pop();
                        stack.push(tmp2/num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }

        num = 0;
        while(!stack.isEmpty()){
            num+=stack.pop();
        }

        return num;
    }

    
    public static void main(String[] args) {
        String str = "1231+(123-23)*100";
        System.out.println(calculate(str, 0, str.length()));
    }

}
