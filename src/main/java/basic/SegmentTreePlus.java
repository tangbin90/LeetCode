package basic;

public class SegmentTreePlus {
    private class SegNode {
        int start, end, sum;
        SegNode left, right;

        SegNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }

    private SegNode root;
    private int[] nums;

    public SegmentTreePlus(int[] nums) {
        this.nums = nums;
        if (nums.length > 0) {
            root = build(0, nums.length - 1);
        }
    }

    private SegNode build(int start, int end) {
        if (start > end) return null;
        SegNode node = new SegNode(start, end);
        if (start == end) {
            node.sum = nums[start];
            return node;
        }

        int mid = (start + end) / 2;
        node.left = build(start, mid);
        node.right = build(mid + 1, end);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    public int query(int left, int right) {
        return query(root, left, right);
    }

    private int query(SegNode node, int left, int right) {
        if (node == null || left > node.end || right < node.start) {
            return 0; // out of range
        }

        if (left <= node.start && right >= node.end) {
            return node.sum; // current segment is completely within the range
        }
        int mid = (node.start + node.end) / 2;
        int sum = 0;
        if (left <= mid) {
            sum += query(node.left, left, right); // query left child
        }
        if (right > mid) {
            sum += query(node.right, left, right); // query right child
        }
        return sum; // combine results from both children

    }

    private void update(SegNode node, int index, int value) {
        if (node == null || index < node.start || index > node.end) {
            return; // out of range
        }
        if (node.start == node.end) {
            node.sum = value; // leaf node
            return;
        }
        int mid = (node.start + node.end) / 2;
        if (index <= mid) {
            update(node.left, index, value);
        } else {
            update(node.right, index, value);
        }
        node.sum = node.left.sum + node.right.sum; // update current node's sum
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        SegmentTreePlus segmentTree = new SegmentTreePlus(nums);

        // Query the sum of elements from index 1 to 3
        System.out.println("Sum of range (1, 3): " + segmentTree.query(1, 3)); // Output: 15

        // Update the value at index 2 to 6
        segmentTree.update(segmentTree.root, 2, 6);

        // Query again after the update
        System.out.println("Sum of range (1, 3) after update: " + segmentTree.query(1, 3)); // Output: 16
    }
}


