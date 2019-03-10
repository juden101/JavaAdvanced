package repository;

import java.util.NoSuchElementException;
import java.util.TreeMap;

public class Repository {
    private TreeMap<Integer, Person> data;
    private int id = 0;


    public Repository() {
        this.data = new TreeMap<>();
    }

    public void add(Person person) {
        //Use Try Catch , with id = this.data.lastKey();
        this.data.put(id, person);
        id++;
    }

    public Person get(int id) {
        return this.data.get(id);
    }

    public boolean update(int id, Person newPerson) {
        if (this.data.get(id) == null) {
            return false;
        } else {
            this.data.put(id, newPerson);
            return true;
        }
    }

    public boolean delete(int id) {
        if (this.data.get(id) == null) {
            return false;
        } else {
            this.data.remove(id);
            return true;
        }
    }

    public int getCount() {
        return this.data.size();
    }


}
