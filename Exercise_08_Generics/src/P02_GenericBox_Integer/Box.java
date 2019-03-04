package P02_GenericBox_Integer;

public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %d\n"
                , value.getClass().getCanonicalName()
                , value);
    }
}
