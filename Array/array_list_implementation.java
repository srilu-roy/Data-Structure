import java.util.Arrays;

public class array_list_implementation<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] data;
    private int size = 0;

    public array_list_implementation() {
        data = new Object[INITIAL_CAPACITY];
    }

    public void add(T element) {
        ensureCapacity();
        data[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) data[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int newCapacity = data.length * 2;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public static void main(String[] args) {
        array_list_implementation<Integer> list = new array_list_implementation<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Element at index 1: " + list.get(1));
        list.remove(1);
        System.out.println("Size after removal: " + list.size());
    }
}
