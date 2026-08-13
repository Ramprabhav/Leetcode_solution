import java.util.*;

class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {

        // Move q1 elements to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Add new element to q1
        q1.add(x);

        // Move q2 elements back to q1
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}