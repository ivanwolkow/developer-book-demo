package com.example.demo.algorithms.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepthFirstTraversal {

    @Test
    void traverseInOrder() {
        var treeContent = new ArrayList<Integer>();
        TreeNode<Integer> root = createTree();

        traverseInOrder(treeContent, root);

        assertEquals(List.of(3, 6, 8, 10, 11, 14, 17), treeContent);
    }

    private <T> void traverseInOrder(List<T> l, TreeNode<T> node) {
        if (node == null) return;
        traverseInOrder(l, node.left);
        l.add(node.val);
        traverseInOrder(l, node.right);
    }


    @Test
    void traversePreOrder() {
        var treeContent = new ArrayList<Integer>();
        TreeNode<Integer> root = createTree();

        traversePreOrder(treeContent, root);

        assertEquals(List.of(3, 8, 6, 11, 17, 14, 10), treeContent);
    }

    private <T> void traversePreOrder(List<T> l, TreeNode<T> node) {
        if (node == null) return;
        traversePreOrder(l, node.left);
        traversePreOrder(l, node.right);
        l.add(node.val);
    }


    @Test
    void traversePostOrder() {
        var treeContent = new ArrayList<Integer>();
        TreeNode<Integer> root = createTree();

        traversePostOrder(treeContent, root);

        assertEquals(List.of(10,6,3,8,14,11,17), treeContent);
    }

    private <T> void traversePostOrder(List<T> l, TreeNode<T> node) {
        if (node == null) return;
        l.add(node.val);
        traversePostOrder(l, node.left);
        traversePostOrder(l, node.right);
    }


    private static TreeNode<Integer> createTree() {
        return new TreeNode<>(10,
                new TreeNode<>(6,
                        new TreeNode<>(3),
                        new TreeNode<>(8)),
                new TreeNode<>(14,
                        new TreeNode<>(11),
                        new TreeNode<>(17)));
    }
}
