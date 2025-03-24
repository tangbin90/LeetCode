import java.util.HashMap;
import java.util.TreeSet;

public class Chapter5ExamRoom {
    HashMap<Integer, int[]> startWithP;

    HashMap<Integer, int[]> endWithP;

    TreeSet<int[]> distanceStorage;

    int N;

    public Chapter5ExamRoom(int N){
        this.N = N;
        startWithP = new HashMap<>();
        endWithP = new HashMap<>();
        distanceStorage = new TreeSet<>((a, b) -> {
            int aDis = distance(a);
            int bDis = distance(b);
            if(aDis == bDis)
                return b[0] - a[0];
            return  aDis - bDis;
        });
        addIntervals(new int[]{-1, N});
    }

    public int distance(int[] intv){
        return intv[1]-intv[0]-1;
    }

    public void addIntervals(int[] intv){
        startWithP.put(intv[0], intv);
        endWithP.put(intv[1], intv);
        distanceStorage.add(intv);
    }

    public void removeIntervals(int[] intv){
        startWithP.remove(intv[0]);
        endWithP.remove(intv[1]);
        distanceStorage.remove(intv);
    }

    public int seat(){
        int[] longest = distanceStorage.pollLast();
        int x = longest[0];
        int y = longest[1];
        int seat;
        if(x==-1)
            seat = 0;
        else if(y==N)
            seat = N-1;
        else {
            seat = (y-x)/2+x;
        }

        int[] left= new int[]{x, seat};
        int[] right= new int[]{seat, y};
        removeIntervals(longest);
        addIntervals(left);
        addIntervals(right);
        return seat;
    }

    public void leave(int p){
        int[] right = startWithP.get(p);
        int[] left = endWithP.get(p);

        int[] merged = new int[] {left[0], right[1]};
        removeIntervals(right);
        removeIntervals(left);
        addIntervals(merged);
    }
}
