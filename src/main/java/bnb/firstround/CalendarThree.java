package bnb.firstround;

import java.util.TreeMap;

public class CalendarThree {
    TreeMap<Integer, Integer> treeMap;
    SegmentTree segmentTree;
    public CalendarThree() {
        treeMap = new TreeMap<>();
        segmentTree = new SegmentTree(0, (int)1e9);
    }

    public int book(int startTime, int endTime) {
        int startVal = treeMap.getOrDefault(startTime, 0);
        treeMap.put(startTime, startVal + 1);
        int endVal = treeMap.getOrDefault(endTime, 0);
        treeMap.put(endTime, endVal - 1);
        int rslt = 0;
        int curr = 0;
        for(int key : treeMap.keySet()){
            curr += treeMap.get(key);
            rslt = Math.max(curr, rslt);
        }

        return rslt;

    }

    public int book2(int startTime, int endTime){
        segmentTree.update(startTime, endTime - 1, 1);
        return segmentTree.max;
    }

    private static class SegmentTree {
        int start, end, mid;
        SegmentTree left, right;
        int max;
        int lazy;

        SegmentTree(int s, int e){
            this.start = s;
            this.end = e;
            this.mid = s + (e - s) / 2;
            this.max = 0;
            this.lazy = 0;
        }

        void update(int l, int r, int val){
            if(r < start || l > end){
                return;
            }

            if(l <= start && end <= r){
                this.max += val;
                this.lazy += val;
                return;
            }

            pushDown();

            left.update(l, r, val);
            right.update(l, r, val);
            this.max = Math.max(left.max, right.max) + this.lazy;
        }

        private void pushDown(){
            if(left == null) {
                left = new SegmentTree(start, mid);
                right = new SegmentTree(mid + 1, end);
            }

            if(lazy != 0){
                left.max += lazy;
                left.lazy += lazy;
                right.max += lazy;
                right.lazy += lazy;
                lazy = 0;
            }
        }

    }


}
