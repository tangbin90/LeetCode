package basic;

public class SegmentTreeHandWriting {
    int[] nums;
    SegNode root;

    public SegmentTreeHandWriting(int[] nums){
        this.nums = nums;
        root = build(nums, 0, nums.length - 1);
    }

    private SegNode build(int[] nums, int left, int right){
        SegNode segNode = new SegNode(left, right);
        if(left == right){
            segNode.sum = nums[left];
            return segNode;
        }

        int mid = (left + right) / 2;
        segNode.left = build(nums, left, mid);
        segNode.right = build(nums, mid+1, right);
        segNode.sum  = segNode.left.sum + segNode.right.sum;
        return segNode;
    }

    public void update(SegNode node, int index, int num){
        if(node == null || index < node.l || index > node.r)
            return;

        if(node.l == node.r){
            node.sum = num;
            return;
        }
        int mid = (node.l + node.r) / 2;
        if(index > mid)
            update(node.right, index, num);
        else
            update(node.left, index, num);

        node.sum = node.left.sum + node.right.sum;


    }

    public int query(int left, int right) {
        return query(root, left, right);
    }

    public int query(SegNode node, int left, int right) {
        if (node == null || left > node.r || right < node.l) {
            return 0; // out of range
        }

        if (left <= node.l && right >= node.r) {
            return node.sum; // current segment is completely within the range
        }

        int mid = (node.l + node.r) / 2;
        int sum = 0;
        if (left <= mid) {
            sum += query(node.left, left, right); // query left child
        }
        if (right > mid) {
            sum += query(node.right, left, right); // query right child
        }
        return sum;
    }


    public class SegNode{
        int sum;
        int l;
        int r;
        SegNode left;
        SegNode right;

        public SegNode(int start,int end){
            l = start;
            r = end;
            left= null;
            right = null;
            sum = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        SegmentTreeHandWriting segmentTree = new SegmentTreeHandWriting(nums);
        System.out.println("Segment Tree built successfully.");

        int rslt = segmentTree.query(1,2);
        System.out.println("rslt = " + rslt);
        // You can add methods to query or update the segment tree as needed.
        segmentTree.update(segmentTree.root, 1, 8);
        System.out.println("update rslt = " + segmentTree.query(1, 2));
    }
}
