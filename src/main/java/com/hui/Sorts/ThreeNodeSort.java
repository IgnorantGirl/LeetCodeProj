package com.hui.Sorts;

public class ThreeNodeSort {

    private Node rootNode;

    public static void main(String[] args) {
        int[] array = {7, 3, 10, 12, 5, 2, 8};
        ThreeNodeSort sort = new ThreeNodeSort();
        for (int i = 0; i < array.length; i++) {
            sort.addNode(new Node(array[i]));
        }
        sort.postOrder();
        System.out.println("-----------");
        sort.inOrder();
    }

    private void addNode(Node node) {
        if (rootNode == null) {
            rootNode = node;
        } else {
            rootNode.addNode(node);
        }
    }

    private void postOrder() {
        if (rootNode == null)
            return;
        rootNode.postOrder();
    }

    private void inOrder() {
        if (rootNode == null)
            return;
        rootNode.midOrder();
    }
}


class Node {
    private Node leftNode;
    private Node rightNode;
    private int val;

    public Node(int val) {
        this.val = val;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * 添加节点
     *
     * @param node
     */
    public void addNode(Node node) {
        if (node == null) {
            return;
        }
        if (node.val < this.val) {
            if (leftNode != null)
                leftNode.addNode(node);
            else
                leftNode = node;
        } else {
            if (rightNode != null)
                rightNode.addNode(node);
            else
                rightNode = node;
        }
    }

    public void postOrder() {
        if (leftNode != null) {
            leftNode.postOrder();
        }
        if (rightNode != null) {
            rightNode.postOrder();
        }
        System.out.println(this.toString());

    }

    public void midOrder() {
        if (leftNode != null) {
            leftNode.midOrder();
        }
        System.out.println(this.toString());
        if (rightNode != null) {
            rightNode.midOrder();
        }
    }


    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}