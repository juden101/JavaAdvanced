package P11_Threeuple;

public class Threeuple<T1, T2, T3> extends Tuple {
    private T3 threeuple;

    public Threeuple(Object key, Object value, T3 threeuple) {
        super(key, value);
        this.threeuple = threeuple;
    }

    public T3 getThreeuple() {
        return threeuple;
    }

    public void setThreeuple(T3 threeuple) {
        this.threeuple = threeuple;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s"
                , this.getKey()
                , this.getValue()
                , this.threeuple);
    }
}
