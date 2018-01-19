package algs;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class LinkedListQueue<Item> implements Iterable<Item> {

    private Node front;
    private Node end;
    private int size;


    private class Node {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
            next = null;
        }
    }

    public LinkedListQueue() {
        front = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.item;
    }


    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item frontItem = front.item;
        front = front.next;
        size--;
        if (isEmpty()) {
            end = front;
        }
        return frontItem;
    }

    public void enqueue(Item item) {
        Node oldEnd = end;
        end = new Node(item);
        if(isEmpty()){
            front = end;
        }else{
            oldEnd.next = end;
        }
        size++;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node index = front;
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
        LinkedListQueue<String> testQueue = new LinkedListQueue<>();

        testQueue.enqueue("1");
        testQueue.enqueue("2");
        for (String item : testQueue) {
            System.out.println(item);
        }
        System.out.println(testQueue.dequeue());
        testQueue.dequeue();
        System.out.println(testQueue.isEmpty());
    }
}
