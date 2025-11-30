package bnb.second;

public class SegmentTree {
    public int[] tree;
    public int[] lazy;
    int n;
    public SegmentTree(int[] nums) {
        this.n = nums.length;
        this.tree = new int[4 * n];
        this.lazy = new int[4 * n];
        build(nums, 1, 0, n - 1);
    }

    private void build(int[] nums, int idx, int start, int end){
        if(start == end){
            tree[idx] = nums[start];
            return;
        }
        int mid = (start + end )/2;

        build(nums, idx * 2, start, mid);
        build(nums, idx * 2 + 1, mid + 1, end);
        pushup(idx);
    }

    private void pushup(int idx){
        tree[idx] = tree[idx*2] + tree[idx*2+1];

    }

    public void addRange(int L, int R, int val) {
        addRange(1, 0, n - 1, L, R, val);
    }

    public int queryRange(int L, int R){
        return queryRange(1, 0, n-1, L, R);
    }

    public int queryRange(int idx, int left, int right, int L, int R){
        if(left > R || right < L){
            return 0;
        }

        if(left >= L && right <= R){
            return tree[idx];
        }

        pushdown(idx, left, right);
        int mid = (left + right) / 2;
        int rslt = queryRange(idx * 2, left, mid, L, R);
        rslt += queryRange(idx * 2 + 1, mid + 1, right, L, R);
        return rslt;

    }

    public void pushdown(int idx, int l, int r){
        if(lazy[idx] == 0)
            return;

        int left = idx*2;
        int right = idx*2+1;
        int tag = lazy[idx];
        int mid = (l + r) / 2;

        tree[left] += tag * (mid - l + 1);
        tree[right] += tag * (r - mid);
        lazy[left] += tag;
        lazy[right] += tag;

        lazy[idx] = 0;
    }

    public void addRange(int idx, int left, int right, int L, int R, int val){
        if(left > R || right < L){
            return;
        }

        if(left >= L && right <= R){
            tree[idx] += (right - left + 1) * val;
            lazy[idx] += val;
            return;
        }

        pushdown(idx, left, right);

        int mid = (right + left) / 2;
        addRange(idx * 2, left, mid, L, R, val);
        addRange(idx*2 + 1, mid + 1, right, L, R, val);

        pushup(idx);

    }
}
