package algs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayFixedCapacityStack<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;

    public ResizingArrayFixedCapacityStack(int cap) {
        items = (Item[]) new Object[cap];
        size = 0;
    }

    public Item pop() {
        //return items[size--];
        Item item = items[--size];
        items[size] = null;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    public Item peek() {
        return items[size - 1];
    }

    public void push(Item item) {
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size++] = item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int max) {
        Item[] temps = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temps[i] = items[i];
        }
        items = temps;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            int i = size;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                if (i == 0) {
                    throw new NoSuchElementException();
                }
                return items[--i];
                //return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        ResizingArrayFixedCapacityStack<String> testStack = new ResizingArrayFixedCapacityStack<>(2);

        testStack.push("1");
        testStack.push("2");
        for(String item:testStack){
            System.out.println(item);
        }
    }
}
