import apple.laf.JRSUIUtils;
import entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {
    private static String SEP = ",";

    private static String NULL = "#";

    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    public static TreeNode deserialize(String data){
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP))
            nodes.add(s);
        return deserialize(nodes);
    }

    public static TreeNode deserialize(LinkedList<String> nodes){
        if(nodes.isEmpty()) return null;

        String first = nodes.removeFirst();
        if(first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = deserialize("1,2,#,4,#,#,3,#,#,");
        System.out.println(node.val);
    }

    void traverse(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        traverse(root.left, sb);
        traverse(root.right, sb);
    }


    TreeNode traverseBackverse(LinkedList<String> nodes){
        if(nodes == null) return null;
        String last = nodes.removeLast();
        if(last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));

        root.right = deserialize(nodes);
        root.left = deserialize(nodes);

        return root;
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }

        serialize(root.left, sb);
        sb.append(root.val).append(SEP);
        serialize(root.right, sb);
    }

    String serializeMiddle(TreeNode root, StringBuilder sb){
        if(root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur == null){
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }

    TreeNode deserializeMiddle(String data) {
        if(data == null) return null;
        if(data.isEmpty()) return null;
        String[] nodeList= data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(nodeList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i=1; i< nodeList.length; ){
            TreeNode parent = queue.poll();
            String left = nodeList[i++];

            if(!left.equals(NULL)){
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.offer(parent.left);
            } else
                parent.left = null;

            String right = nodeList[i++];
            if(!right.equals(NULL)){
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.offer(parent.right);
            } else
                parent.right = null;

        }
        return root;
    }
}
