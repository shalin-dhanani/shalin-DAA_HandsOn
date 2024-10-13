public class Queue {
    private int[] queueArray;
    private int front, rear, size, capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.queueArray = new int[capacity];
        this.front = 0;
        this.size = 0;
        this.rear = capacity - 1;
    }

    public boolean enqueue(int x) {
        if (size == capacity) {
            System.out.println("Enqueue " + x + ":");
            System.out.println("Queue is full: true");
            System.out.println("Is overflow: true");
            displayQueue();
            return false;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = x;
        size++;
        System.out.println("Enqueued " + x);
        displayQueue();
        return true;
    }

    public boolean dequeue() {
        if (size == 0) {
            System.out.println("Cannot dequeue: queue is empty.");
            System.out.println("Is underflow: true");
            return false;
        }
        System.out.println("Dequeued " + queueArray[front]);
        front = (front + 1) % capacity;
        size--;
        displayQueue();
        return true;
    }

    public boolean peek() {
        if (size == 0) {
            System.out.println("Queue is empty: true");
            return false;
        }
        System.out.println("Front element is: " + queueArray[front]);
        return true;
    }

    public void displayQueue() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Current queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queueArray[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.enqueue(40);

        queue.peek();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.dequeue();

        boolean isEmpty = (queue.size == 0);
        System.out.println("Queue is empty: " + isEmpty);
    }
}
