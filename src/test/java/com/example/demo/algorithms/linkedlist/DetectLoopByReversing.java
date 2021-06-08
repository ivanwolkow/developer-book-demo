package com.example.demo.algorithms.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DetectLoopByReversing {

    public boolean hasLoop(ListNode node) {
        if (node == null || node.next == null) return false;

        ListNode prev = null;
        ListNode current = node;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return node == prev;
    }

    @Test
    void emptyListTest() {
        assertFalse(hasLoop(null));
    }

    @Test
    void singleElementListTest() {
        assertFalse(hasLoop(new ListNode(1)));
    }

    @Test
    void hasLoopTest() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        Assertions.assertTrue(hasLoop(n1));
    }

    @Test
    void hasNoLoopTest() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        assertFalse(hasLoop(n1));
    }
}
