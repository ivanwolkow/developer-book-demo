package com.example.demo.algorithms.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BreadthFirstTraversal {


    @Test
    void breadthFirstTraversal() {
        ArrayList<Integer> treeContent = new ArrayList<>();
        TreeNode<Integer> root = createTree();
        var queue = new LinkedBlockingQueue<TreeNode<Integer>>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> next = queue.poll();
            treeContent.add(next.val);
            if (next.left != null) queue.add(next.left);
            if (next.right != null) queue.add(next.right);
        }

        assertEquals(List.of(10, 6, 14, 3, 8, 11, 17), treeContent);
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
