public class DynamicArray {
    private int[] arr;
    private int size;
    private int capacity;

    public DynamicArray(int initialCapacity) {
        arr = new int[initialCapacity];
        size = 0;
        capacity = initialCapacity;
    }

    public DynamicArray() {
        this(2);
    }

    public void add(int value) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        arr[size++] = value;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == capacity) {
            resize(capacity * 2);
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        if (size <= capacity / 4) {
            resize(capacity / 2);
        }
    }

    public void remove() {
        if (size > 0) {
            size--;
            if (size <= capacity / 4) {
                resize(capacity / 2);
            }
        }
    }

    private void resize(int newCapacity) {
        int[] newArr = new int[newCapacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
        capacity = newCapacity;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return arr[index];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DynamicArray dynArr = new DynamicArray();
        dynArr.add(1);
        dynArr.add(2);
        dynArr.add(3);
        dynArr.add(4);

        System.out.println("Elements: " + dynArr);
        System.out.println("Size: " + dynArr.getSize());
        System.out.println("Capacity: " + dynArr.getCapacity());

        dynArr.insert(2, 99);
        System.out.println("After inserting 99 at index 2: " + dynArr);

        dynArr.delete(3);
        System.out.println("After deleting element at index 3: " + dynArr);

        dynArr.remove();
        System.out.println("After removing last element: " + dynArr);
        System.out.println("Size: " + dynArr.getSize());
        System.out.println("Capacity: " + dynArr.getCapacity());
    }
}
