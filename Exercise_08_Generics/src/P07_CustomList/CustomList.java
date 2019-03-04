package P07_CustomList;


import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int index, int secondIndex) {
        T firstElement = list.get(index);
        T secondElement = list.get(secondIndex);
        list.set(index, secondElement);
        list.set(secondIndex, firstElement);
    }

    public long countGreaterNumber(T element) {
        return this.list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return this.list.stream().max(T::compareTo).get();
    }

    public T getMin() {
        return this.list.stream().min(T::compareTo).get();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < this.list.size(); i++) {
            output.append(this.list.get(i)).append("\n");
        }
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }
}
