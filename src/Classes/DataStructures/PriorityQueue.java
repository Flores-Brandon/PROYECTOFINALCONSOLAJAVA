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
public class PriorityQueue<T> {
    public class Element {
        public T Value;
        public int Priority;

        public Element(T value, int priority) {
            Value = value;
            Priority = priority;
        }
    }

     List<Element> Items;
    public int Count;

    public PriorityQueue() {
        Items = new ArrayList<>();
    }

    public void Enqueue(T value, int priority) {
        Element element = new Element(value, priority);
        Items.add(element);
        heapifyUp(Items.size() - 1);
    }

    public T Dequeue() {
        if (Items.isEmpty()) {
            System.out.println("Void Queue");
            return null; // Cambia esto según tus necesidades
        }
        T result = Items.get(0).Value;
        Items.set(0, Items.get(Items.size() - 1));
        Items.remove(Items.size() - 1);
        heapifyDown(0);
        return result;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (Items.get(index).Priority < Items.get(parentIndex).Priority) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < Items.size() && Items.get(leftChild).Priority < Items.get(smallest).Priority) {
            smallest = leftChild;
        }

        if (rightChild < Items.size() && Items.get(rightChild).Priority < Items.get(smallest).Priority) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int index1, int index2) {
        Element temp = Items.get(index1);
        Items.set(index1, Items.get(index2));
        Items.set(index2, temp);
    }

    public void show() {
        if (Items.isEmpty()) {
            System.out.println("Void Queue");
            return;
        }
        System.out.println("=== My Priority Queue ===");
        for (Element element : Items) {
            System.out.println("Data: " + element.Value + " Priority: " + element.Priority);
        }
        System.out.println();
    }

    public void clear() {
        Items.clear();
    }
}
