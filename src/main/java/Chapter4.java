import sun.awt.image.ImageWatched;

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


    public static void main(String[] args) {
        char[][] nums={{'x','o','x'},{'o','x','x'},{'x','x','o'}};
        printSudoku(nums);
    }



}
