package com.example.demo.algorithms.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    @Test
    void testHappyPath() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

        ListNode reversed = reverseList(head);
        Assertions.assertNotNull(reversed);
        Assertions.assertEquals(3, reversed.val);
        Assertions.assertEquals(2, reversed.next.val);
        Assertions.assertEquals(1, reversed.next.next.val);
        Assertions.assertNull(reversed.next.next.next);
    }

    @Test
    void testEmptyList() {
        Assertions.assertNull(reverseList(null));
    }

}
