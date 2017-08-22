import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class myMap<Integer, String> {
    private int size;
    private int DEFAULT_CAPACITY = 16;
    @SuppressWarnings("unchecked")
    private myEntry<Integer, String>[] values = new myEntry[DEFAULT_CAPACITY];


    public String get(Integer key) {
        for (int i = 0; i < size; i++) {
            if (values[i] != null) {
                if (values[i].getKey().equals(key)) {
                    return values[i].getValue();
                }
            }
        }
        return null;
    }

    public void put(Integer key, String value) {
        boolean insert = true;
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)) {
                values[i].setValue(value);
                insert = false;
            }
        }
        if (insert) {
            ensureCapa();
            values[size++] = new myEntry<Integer, String>(key, value);
        }
    }

    private void ensureCapa() {
        if (size == values.length) {
            int newSize = values.length * 2;
            values = Arrays.copyOf(values, newSize);
        }
    }

    public int size() {
        return size;
    }

    public void remove(Integer key) {
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)) {
                values[i] = null;
                size--;
                condenseArray(i);
            }
        }
    }

    private void condenseArray(int start) {
        for (int i = start; i < size; i++) {
            values[i] = values[i + 1];
        }
    }

    public Set<Integer> keySet() {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < size; i++) {
            set.add(values[i].getKey());
        }
        return set;
    }
}