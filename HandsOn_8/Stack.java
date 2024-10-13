public class Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public Stack(int size) {
        this.capacity = size;
        this.stackArray = new int[size];
        this.top = -1;
    }

    public boolean push(int x) {
        if (top == capacity - 1) {
            System.out.println("Pushing " + x + ":");
            System.out.println("Stack is full: true");
            System.out.println("Is overflow: true");
            displayStack();
            return false;
        }
        stackArray[++top] = x;
        System.out.println("Pushed " + x + " to the stack.");
        displayStack();
        return true;
    }

    public boolean pop() {
        if (top == -1) {
            System.out.println("Cannot pop: stack is empty.");
            System.out.println("Is underflow: true");
            return false;
        }
        System.out.println("Popped " + stackArray[top] + " from the stack.");
        top--;
        displayStack();
        return true;
    }

    public boolean peek() {
        if (top == -1) {
            System.out.println("Stack is empty: true");
            return false;
        }
        System.out.println("Top element is: " + stackArray[top]);
        return true;
    }

    public void displayStack() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Current stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(3);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.push(40);

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.pop();

        stack.peek();
    }
}
