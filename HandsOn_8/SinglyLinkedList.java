public class SinglyLinkedList {
    private int[] dataArray;
    private int[] nextArray;
    private int head, size, capacity;

    public SinglyLinkedList(int capacity) {
        this.capacity = capacity;
        this.dataArray = new int[capacity];
        this.nextArray = new int[capacity];
        this.head = -1;
        this.size = 0;
    }

    public boolean insertAtHead(int value) {
        if (size == capacity) {
            System.out.println("Insert " + value + ":");
            System.out.println("List is full: true");
            System.out.println("Is overflow: true");
            display();
            return false;
        }
        int newNode = size;
        dataArray[newNode] = value;
        nextArray[newNode] = head;
        head = newNode;
        size++;
        System.out.println("Inserted " + value);
        display();
        return true;
    }

    public boolean removeFromHead() {
        if (head == -1) {
            System.out.println("Cannot remove: linked list is empty.");
            System.out.println("Is underflow: true");
            return false;
        }
        int removedValue = dataArray[head];
        head = nextArray[head];
        size--;
        System.out.println("Removed " + removedValue);
        display();
        return true;
    }

    public boolean peek() {
        if (head == -1) {
            System.out.println("Cannot peek: linked list is empty.");
            return false;
        }
        System.out.println("Peek: " + dataArray[head]);
        return true;
    }

    public void display() {
        if (head == -1) {
            System.out.print("Linked List: Empty : true\n");
            return;
        }
        int current = head;
        System.out.print("Linked List: ");
        while (current != -1) {
            System.out.print(dataArray[current] + " ");
            current = nextArray[current];
        }
        System.out.print(": true\n");
    }

    public boolean isEmpty() {
        boolean empty = (size == 0);
        System.out.println("List is empty: " + empty);
        return empty;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList(3);

        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtHead(30);

        list.insertAtHead(40);

        list.peek();

        list.removeFromHead();
        list.removeFromHead();
        list.removeFromHead();

        list.removeFromHead();

        list.isEmpty();

        if (list.isEmpty()) {
            System.out.println("Final state: Linked list is empty: true");
        } else {
            System.out.println("Final state: Linked list is empty: false");
        }
    }
}
