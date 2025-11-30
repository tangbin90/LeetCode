package bnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class FileSystem {
    private static class Node{
        Map<String, Node> children = new HashMap<>();
        boolean isFile = false;
        String value = null;

        List<Consumer<String>> watchers = new ArrayList<>();
    }

    Node root = new Node();

    private Node findNode(String path) {
        if (path.equals("/")) return root;

        String[] parts = path.split("/");
        Node curr = root;

        for (String p : parts) {
            if (p.length() == 0) continue;
            if (!curr.children.containsKey(p)) return null;
            curr = curr.children.get(p);
        }
        return curr;
    }

    public boolean createPath(String path, String value) {
        String[] parts = path.split("/");
        Node curr = root;

        for (int i = 1; i < parts.length - 1; i++) {
            String dir = parts[i];
            if (!curr.children.containsKey(dir)) return false; // 父路径不存在
            curr = curr.children.get(dir);
        }

        String last = parts[parts.length - 1];
        if (curr.children.containsKey(last)) return false; // 已存在

        Node newNode = new Node();
        newNode.isFile = true;
        newNode.value = value;
        curr.children.put(last, newNode);

        triggerWatch(curr); // watch callback
        return true;
    }

    public boolean set(String path, String value) {
        Node node = findNode(path);
        if (node == null) return false;

        node.isFile = true;
        node.value = value;

        triggerWatch(node);
        return true;
    }

    public String get(String path) {
        Node node = findNode(path);
        if (node == null || !node.isFile) return null;
        return node.value;
    }

    public void watch(String path, Consumer<String> callback) {
        Node node = findNode(path);
        node.watchers.add(callback);
    }

    private void triggerWatch(Node node) {
        for (Consumer<String> callback : node.watchers) {
            callback.accept("path changed");
        }
    }


}
