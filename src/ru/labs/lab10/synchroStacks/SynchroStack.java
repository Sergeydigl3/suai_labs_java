package ru.labs.lab10.synchroStacks;

import java.util.NoSuchElementException;

public class SynchroStack {
    private Node top;
    private int size;

    public synchronized void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public synchronized int pop() {
        if (top == null) {
            throw new NoSuchElementException("Stack is empty");
        }
        int val = top.val;
        top = top.next;
        size--;
        return val;
    }

    public synchronized boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SynchroStack)) {
            return false;
        }
        SynchroStack other = (SynchroStack) obj;
        if (size != other.size) {
            return false;
        }
        Node thisTop = top;
        Node otherTop = other.top;
        while (thisTop != null && otherTop != null) {
            if (thisTop.val != otherTop.val) {
                return false;
            }
            thisTop = thisTop.next;
            otherTop = otherTop.next;
        }
        return true;
    }

    public synchronized String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node node = top;
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node {
        private int val;
        private Node next;

        private Node(int val) {
            this.val = val;
        }
    }
}