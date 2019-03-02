package Jar;

import java.util.ArrayDeque;

public class Jar<T> {
    ArrayDeque<T> storage;

    public Jar() {
        this.storage = new ArrayDeque<>();
    }

    public void add(T element) {
        this.storage.push(element);
    }

    public T remove() {
        return this.storage.pop();
    }
}
