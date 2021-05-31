package com.example.demo.algorithms.tree;

public class TreeNode<T> {

    TreeNode<T> left;
    TreeNode<T> right;
    T val;

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}


