package basic;

class SegmentTree {
    int[] tree;   // 线段树数组
    int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[n * 4];  // 够用的空间
        build(nums, 0, n - 1, 1);
    }

    void build(int[] nums, int l, int r, int node) {
        if (l == r) {
            tree[node] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        build(nums, l, mid, node * 2);
        build(nums, mid + 1, r, node * 2 + 1);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }  

    int query(int L, int R, int l, int r, int node) {
        if (L <= l && r <= R) return tree[node];
        int mid = (l + r) / 2, sum = 0;
        if (L <= mid) sum += query(L, R, l, mid, node * 2);
        if (R > mid)  sum += query(L, R, mid + 1, r, node * 2 + 1);
        return sum;
    }

    void update(int index, int val, int l, int r, int node) {
        if (l == r) {
            tree[node] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (index <= mid)
            update(index, val, l, mid, node * 2);
        else
            update(index, val, mid + 1, r, node * 2 + 1);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}