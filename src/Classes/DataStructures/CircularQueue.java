/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DataStructures;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class CircularQueue {
     int size, front, rear;
     List<Integer> queue;

    public CircularQueue(int size) {
        this.size = size;
        this.front = this.rear = -1;
        this.queue = new ArrayList<>();
    }

    public void enqueue(int value) {
        if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
            System.out.println("Queue is Full");
        } else if (front == -1) {
            front = 0;
            rear = 0;
            queue.add(value);
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            queue.set(rear, value);
        } else {
            rear = (rear + 1) % size;
            if (front <= rear) {
                queue.add(value);
            } else {
                queue.set(rear, value);
            }
        }
    }

    public int dequeue() {
        int temp;
        if (front == -1) {
            System.out.println("Queue is Empty");
            return -1;
        }
        temp = queue.get(front);
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front = (front + 1) % size;
        }
        return temp;
    }

    public void show() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        } else if (queue.size() == 0) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("=== My Circular Queue ===");
        if (rear >= front) {
            for (int i = front; i < rear; i++) {
                System.out.println("- Node[" + i + "] and Data: " + queue.get(i));
            }
        } else {
            for (int i = front; i < size; i++) {
                System.out.println("- Node[" + i + "] and Data: " + queue.get(i));
            }
            for (int i = 0; i <= rear; i++) {
                System.out.println("- Node[" + i + "] and Data: " + queue.get(i));
            }
        }
    }

    public void clear() {
        queue.clear();
    }
}
