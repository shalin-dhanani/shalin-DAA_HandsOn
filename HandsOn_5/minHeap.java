import java.util.ArrayList;

public class minHeap<T extends Comparable<T>> {
    private ArrayList<T> data;

    public minHeap() {
        this.data = new ArrayList<>();
    }

    private int getParent(int idx) {
        return (idx - 1) >> 1;
    }

    private int getLeft(int idx) {
        return (idx << 1) + 1;
    }

    private int getRight(int idx) {
        return (idx << 1) + 2;
    }

    private void exchange(int i, int j) {
        T temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    private void siftDown(int idx) {
        int smallest = idx;
        int left = getLeft(idx);
        int right = getRight(idx);

        if (left < data.size() && data.get(left).compareTo(data.get(smallest)) < 0) {
            smallest = left;
        }

        if (right < data.size() && data.get(right).compareTo(data.get(smallest)) < 0) {
            smallest = right;
        }

        if (smallest != idx) {
            exchange(idx, smallest);
            siftDown(smallest);
        }
    }

    private void siftUp(int idx) {
        int parentIdx = getParent(idx);
        if (idx > 0 && data.get(idx).compareTo(data.get(parentIdx)) < 0) {
            exchange(idx, parentIdx);
            siftUp(parentIdx);
        }
    }

    public void insert(T value) {
        data.add(value);
        siftUp(data.size() - 1);
    }

    public T pop() {
        if (data.isEmpty()) {
            return null;
        }

        T root = data.get(0);
        T last = data.remove(data.size() - 1);

        if (!data.isEmpty()) {
            data.set(0, last);
            siftDown(0);
        }

        return root;
    }

    public void buildMinHeap(ArrayList<T> arr) {
        this.data = arr;
        for (int i = getParent(data.size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public void displayHeap() {
        for (T element : data) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public int getSize() {
        return data.size();
    }

    public static void main(String[] args) {
        minHeap<Integer> intHeap = new minHeap<>();
        System.out.println("Adding Integer elements:");
        intHeap.insert(10);
        intHeap.insert(20);
        intHeap.insert(5);
        intHeap.insert(15);
        intHeap.insert(1);
        intHeap.displayHeap();

        System.out.println("Removing the minimum element from Integer heap:");
        System.out.println("Removed element: " + intHeap.pop());
        intHeap.displayHeap();

        ArrayList<Integer> intArr = new ArrayList<>();
        intArr.add(40);
        intArr.add(25);
        intArr.add(30);
        intArr.add(35);
        intArr.add(50);

        System.out.println("Building Integer heap from array:");
        intHeap.buildMinHeap(intArr);
        intHeap.displayHeap();

        minHeap<Float> floatHeap = new minHeap<>();
        System.out.println("\nAdding Float elements:");
        floatHeap.insert(10.5f);
        floatHeap.insert(20.1f);
        floatHeap.insert(5.2f);
        floatHeap.insert(15.6f);
        floatHeap.insert(1.3f);
        floatHeap.displayHeap();

        System.out.println("Removing the minimum element from Float heap:");
        System.out.println("Removed element: " + floatHeap.pop());
        floatHeap.displayHeap();

        ArrayList<Float> floatArr = new ArrayList<>();
        floatArr.add(40.7f);
        floatArr.add(25.9f);
        floatArr.add(30.4f);
        floatArr.add(35.2f);
        floatArr.add(50.8f);

        System.out.println("Building Float heap from array:");
        floatHeap.buildMinHeap(floatArr);
        floatHeap.displayHeap();
    }
}
