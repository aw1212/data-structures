package com.alex.structures.tree;

public class BinarySearchTree<E extends Comparable<E>> {

    private TreeNode<E> root;
    private int size;

    public int getSize() {
        return size;
    }

    public void add(E value) {
        TreeNode<E> newNode = new TreeNode<>(value);

        if (size == 0) {
            root = newNode;
        } else {
            addNode(newNode, root, null);
        }

        size++;
    }

    private TreeNode<E> addNode(TreeNode<E> nodeToAdd, TreeNode<E> current, TreeNode<E> parent) {
        if (current == null) {
            nodeToAdd.setParent(parent);
        } else if (nodeToAdd.getValue().compareTo(current.getValue()) < 0) {
            current.setLeft(addNode(nodeToAdd, current.getLeft(), current));
        } else {
            current.setRight(addNode(nodeToAdd, current.getRight(), current));
        }

        return nodeToAdd;
    }

//    public void add(E value) {
//        TreeNode<E> newNode  = new TreeNode<>(value);
//
//        if (size == 0) {
//            root = newNode;
//        } else {
//            insert(root, newNode);
//        }
//
//        size++;
//    }
//
//    private void insert(TreeNode<E> parent, TreeNode<E> child) {
//        // if child is smaller than parent, it goes on the left
//        if (child.getValue().compareTo(parent.getValue()) < 0) {
//            // if parent has no left child, set this child to be its left child
//            if (parent.getLeft() == null) {
//                parent.setLeft(child);
//                child.setParent(parent);
//            }
//            //parent has a left child already so we need to visit its left child and try again
//            else {
//                insert(parent.getLeft(), child);
//            }
//        }
//        // if child is greater or equal to the parent, it goes on the right
//        else {
//            // if parent has no right child, set this child to be its right child
//            if (parent.getRight() == null) {
//                parent.setRight(child);
//                child.setParent(parent);
//            }
//            //parent has a right child already so we need to visit its right child and try again
//            else {
//                insert(parent.getRight(), child);
//            }
//        }
//    }

    public boolean remove(E value) {
        TreeNode<E> nodeToRemove = findNode(value, root);

        if (nodeToRemove == null) {
            return false;
        }

        // if there is only one in the list (aka the root)
        if (size == 1) {
            root = null;
        }
        // there is more than one in the list
        else {
            TreeNode<E> parent = nodeToRemove.getParent();

            // if node is not root and is terminal node
            if (nodeToRemove.isTerminalNode()) {
                // if node to remove is smaller than parent node
                if (value.compareTo(parent.getValue()) < 0) {
                    parent.setLeft(null);
                }
                // if node to remove is greater than or equal to than parent node
                else {
                    parent.setRight(null);
                }
            }
            // node to remove is not terminal node
            else {
                // if has no right children
                if (nodeToRemove.getRight() == null) {
                    adopt(nodeToRemove.getLeft(), parent);
                }
                // if its right child has no left child
                else if (nodeToRemove.getRight().getLeft() == null) {
                    nodeToRemove.getRight().setLeft(nodeToRemove.getLeft());
                    adopt(nodeToRemove.getRight(), parent);
                }
                // if its right child has a left child
                else {
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
        return true;
    }

//    public boolean delete(E value) {
//        if (size == 1) {
//            root = null;
//            size--;
//            return true;
//        }
//
//        TreeNode<E> treeNode = findNode(value, root);
//
//        if (treeNode == null) {
//            return false;
//        }
//
//        if (treeNode.isTerminalNode()) {
//            unlink(treeNode, null);
//        }
//
//        else if (treeNode.getLeft() == null) {
//            unlink(treeNode, treeNode.getRight());
//        }
//
//        else if (treeNode.getRight() == null) {
//            unlink(treeNode, treeNode.getLeft());
//        }
//
//        else {
//            TreeNode<E> child = treeNode.getLeft();
//            while (child.getRight() != null && child.getLeft() != null) {
//                child = child.getRight();
//            }
//            child.getParent().setRight(null);
//            child.setLeft(treeNode.getLeft());
//            child.setRight(treeNode.getRight());
//
//            unlink(treeNode, child);
//        }
//
//        size--;
//        return true;
//    }
//
//    private void unlink(TreeNode<E> currentNode, TreeNode<E> newNode) {
//        if (currentNode == root) {
//            newNode.setLeft(currentNode.getLeft());
//            newNode.setRight(currentNode.getRight());
//            root = newNode;
//        } else if (currentNode.getParent().getRight() == currentNode) {
//            currentNode.getParent().setRight(newNode);
//        } else {
//            currentNode.getParent().setLeft(newNode);
//        }
//    }

    public boolean contains(E value) {
        return findNode(value, root) != null;
    }

    private TreeNode<E> findNode(E value, TreeNode<E> current) {
        // if current is null that means there is no node with that value
        if (current == null || value.equals(current.getValue())) {
            return current;
        }

        if (value.compareTo(current.getValue()) < 0) {
            return findNode(value, current.getLeft());
        }

        return findNode(value, current.getRight());
    }

//    //same as above but without recursion
//    private TreeNode<E> findNode(E value, TreeNode<E> node) {
//        while (node != null) {
//            if (value.equals(node.getValue())) {
//                return node;
//            }
//
//            if (value.compareTo(node.getValue()) < 0) {
//                node = node.getLeft();
//            }  else {
//                node = node.getRight();
//            }
//        }
//
//        return null;
//    }

    private void adopt(TreeNode<E> child, TreeNode<E> parent) {
        if (parent != null) {
            // if child node is smaller than parent node
            if (child.getValue().compareTo(parent.getValue()) < 0) {
                parent.setLeft(child);
            }
            // if child node is larger or equal to parent node
            else {
                parent.setRight(child);
            }
        }
        child.setParent(parent);
    }

    private TreeNode<E> findLeftMostChild(TreeNode<E> current) {
        if (current.getLeft() == null) {
            return current;
        }

        return findLeftMostChild(current.getLeft());
    }

    private static class TreeNode<E> {

        private TreeNode<E> left;
        private TreeNode<E> right;
        private TreeNode<E> parent;
        private E value;

        private TreeNode(E value) {
            this(value, null, null, null);
        }

        private TreeNode(E value, TreeNode<E> parent, TreeNode<E> left, TreeNode<E> right) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
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
