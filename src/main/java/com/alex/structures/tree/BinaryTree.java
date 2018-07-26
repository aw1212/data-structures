package com.alex.structures.tree;

public class BinaryTree<E extends Comparable<E>> {

    private TreeNode<E> root;
    private int size;

    public void add(E value) {

        if (size == 0) {
            root = new TreeNode<>(value);
        } else {
            addNode(value, root);
        }

        size++;
    }

    private TreeNode<E> addNode(E value, TreeNode<E> current) {
        if (current == null) {
            return new TreeNode<>(value, current);
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(addNode(value, current.getLeft()));
        } else {
            current.setRight(addNode(value, current.getRight()));
        }

        return current;
    }

    public void remove(E value) {
        TreeNode<E> nodeToRemove = findNode(value, root);

        if (nodeToRemove.isRootNode()) {
            root = null;
        } else {
            TreeNode<E> parent = nodeToRemove.getParent();

            if (nodeToRemove.isTerminalNode()) {
                if (value.compareTo(parent.getValue()) < 0) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            } else {
                if (nodeToRemove.getRight() == null) {
                    adopt(nodeToRemove.getLeft(), parent);
                } else if (nodeToRemove.getRight().getLeft() == null) {
                    nodeToRemove.getRight().setLeft(nodeToRemove.getLeft());
                    adopt(nodeToRemove.getRight(), parent);
                } else {
                    TreeNode<E> leftMostChild = findLeftMostChild(nodeToRemove.getRight().getLeft());
                    leftMostChild.getParent().setLeft(null);
                    if (leftMostChild.getRight() != null) {
                        leftMostChild.getParent().setLeft(leftMostChild.getRight());
                        leftMostChild.setLeft(nodeToRemove.getLeft());
                        adopt(leftMostChild, parent);
                    }
                }
            }
        }

        size--;
    }

    private TreeNode<E> findLeftMostChild(TreeNode<E> current) {
        if (current.getLeft() == null) {
            return current;
        }

        return current.getLeft();
    }

    private TreeNode<E> findNode(E value, TreeNode<E> current) {
        if (value.equals(current.getValue())) {
            return current;
        }

        if (value.compareTo(current.getValue()) < 0) {
            return findNode(value, current.getLeft());
        }

        return findNode(value, current.getRight());
    }

    private void adopt(TreeNode<E> child, TreeNode<E> parent) {
        if (child.getValue().compareTo(parent.getValue()) < 0) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
        child.setParent(parent);
    }

    private static class TreeNode<E> {

        private TreeNode<E> left;
        private TreeNode<E> right;
        private TreeNode<E> parent;
        E value;

        private TreeNode(E value) {
            this(value, null);
        }

        private TreeNode(E value, TreeNode<E> parent) {
            this.value = value;
            this.parent = parent;
        }

        private TreeNode<E> getLeft() {
            return left;
        }

        private void setLeft(TreeNode<E> left) {
            this.left = left;
        }

        private TreeNode<E> getRight() {
            return right;
        }

        private void setRight(TreeNode<E> right) {
            this.right = right;
        }

        public TreeNode<E> getParent() {
            return parent;
        }

        public void setParent(TreeNode<E> parent) {
            this.parent = parent;
        }

        private E getValue() {
            return value;
        }

        private void setValue(E value) {
            this.value = value;
        }

        private boolean isTerminalNode() {
            return left == null && right == null;
        }

        private boolean isRootNode() {
            return parent == null;
        }
    }

}
