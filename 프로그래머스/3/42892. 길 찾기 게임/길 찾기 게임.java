import java.util.*;

class Solution {
    static class Node {
        int x;
        int y;
        int index;
        Node left;
        Node right;

        Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        void insert(Node child) {
            if (child.x < this.x) {
                if (this.left == null) this.left = child;
                else this.left.insert(child);
            } else {
                if (this.right == null) this.right = child;
                else this.right.insert(child);
            }
        }
    }

    List<Integer> preOrderList = new ArrayList<>();
    List<Integer> postOrderList = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodeList.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        nodeList.sort((a, b) -> {
            if (a.y == b.y) return Integer.compare(a.x, b.x);
            return Integer.compare(b.y, a.y);
        });

        Node root = nodeList.get(0);
        for (int i = 1; i < nodeList.size(); i++) {
            root.insert(nodeList.get(i));
        }

        preorder(root);
        postorder(root);

        return new int[][] {
            preOrderList.stream().mapToInt(i -> i).toArray(),
            postOrderList.stream().mapToInt(i -> i).toArray()
        };
    }

    void preorder(Node node) {
        if (node == null) return;
        preOrderList.add(node.index);
        preorder(node.left);
        preorder(node.right);
    }

    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        postOrderList.add(node.index);
    }
}
