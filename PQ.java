package pq;

import java.util.ArrayList;

public class PQ<E extends Comparable<? super E>> {
    private ArrayList<E> elements;

    public PQ() {
        elements = new ArrayList<>();
    }

    public void insert(E item) {
        elements.add(item);
    }

    public E min() {
        if (isEmpty()) {
            return null; // Handle empty scenario better in real-world scenarios.
        }
        return elements.stream().min(E::compareTo).orElse(null);
    }

    public E removeMin() {
        E minimum = min();
        if (minimum != null) {
            elements.remove(minimum);
        }
        return minimum;
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
