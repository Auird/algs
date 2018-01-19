package algs;

import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings {
    private String[] items;
    private int size;

    public FixedCapacityStackOfStrings(int cap){
        items = new String[cap];
        size = 0;
    }

    public String pop(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return items[size--];
    }

    public String peek(){
        return items[size];
    }

    public void push(String item){
        items[size++] = item;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}
