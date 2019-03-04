package P01_GenerericBox;

public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n"
                , value.getClass().getCanonicalName()
                , value);
    }
}
