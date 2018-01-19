package algs;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListStack<Item> implements Iterable<Item> {
    private Node top;
    private int size;

    private class Node {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
        }

    }

    public LinkedListStack() {
        top = null;
        size = 0;
    }

    public Item pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        Item topItem = top.item;
        top = top.next;
        size--;
        return topItem;
    }

    public Item peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.item;
    }

    public void push(Item item) {
        Node newTop = new Node(item);
        newTop.next = top;
        top = newTop;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node index = top;

            @Override
            public boolean hasNext() {
                return index != null;
            }

            @Override
            public Item next() {
                Item item = index.item;
                index = index.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        LinkedListStack<String> testStack = new LinkedListStack<>();

        testStack.push("1");
        testStack.push("2");
        for (String item : testStack) {
            System.out.println(item);
        }
    }
}
