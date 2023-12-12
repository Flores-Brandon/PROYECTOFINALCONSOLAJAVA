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
 * @param <T>
 */
public class StackDinamic<T> {
     List<T> stack;
     public int count;

    public T get(int index) {
        return stack.get(index);
    }

    public StackDinamic() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
        count++;
    }

    public T pop() {
        if (stack.isEmpty()) {
            System.out.println("Void Stack");
            return null; // You may want to return a sentinel value or throw an exception here
        }

        int lastIndex = stack.size() - 1;
        T poppedItem = stack.remove(lastIndex);
        count--;

        return poppedItem;
    }

    public T peek() {
        if (stack.isEmpty()) {
            System.out.println("Void Stack");
            return null; // You may want to return a sentinel value or throw an exception here
        }
        System.out.println(stack.get(stack.size() - 1));
        return stack.get(stack.size() - 1);
    }

    public void show(StackDinamic<T> stack) {
        if (stack.count == 0) {
            System.out.println("Void Stack");
            return;
        }
        System.out.println("=== My Stack Dinamic ===");
        do {
            stack.count--;
            System.out.println(stack.pop());
        } while (stack.count > 0);
    }
}
