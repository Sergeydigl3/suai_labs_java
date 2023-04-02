package ru.labs.lab10.synchroStacks;

import java.util.NoSuchElementException;

public class SynchroStackFast {
    private Node top;
    private int size;
    private int activeReaders;
    private boolean activeWriter;

    public SynchroStackFast() {
        top = null;
        size = 0;
        activeReaders = 0;
        activeWriter = false;
    }

    public synchronized void push(int value) {
        while (activeReaders > 0 || activeWriter) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        activeWriter = true;
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
        activeWriter = false;
        notifyAll();
    }

    public synchronized int pop() {
        while (activeReaders > 0 || activeWriter) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        activeWriter = true;
        int value = top.value;
        top = top.next;
        size--;
        activeWriter = false;
        notifyAll();
        return value;
    }

    public boolean equals(Object obj) {
        while (activeWriter) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        activeReaders++;

        //

        if (obj instanceof SynchroStackFast) {
            SynchroStackFast other = (SynchroStackFast) obj;
            if (size != other.size) {
                activeReaders--;
                notifyAll();
                return false;
            }

            Node currentNode = top;
            Node otherCurrentNode = other.top;
            while (currentNode != null && otherCurrentNode != null) {
                if (currentNode.value != otherCurrentNode.value) {
                    activeReaders--;
                    notifyAll();
                    return false;
                }
                currentNode = currentNode.next;
                otherCurrentNode = otherCurrentNode.next;
            }

            activeReaders--;
            notifyAll();
            return true;
        }

        activeReaders--;
        notifyAll();
        return false;
    }


    public String toString() {
        synchronized (this) {
            activeReaders++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node currentNode = top;
        while (currentNode != null) {
            Node localNode = currentNode;
            sb.append(localNode.value);
            if (localNode.next != null) {
                sb.append(", ");
            }
            currentNode = localNode.next;
        }
        sb.append(" ");

        synchronized (this) {
            activeReaders--;
            notifyAll();
        }

        return sb.toString();
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }
}
