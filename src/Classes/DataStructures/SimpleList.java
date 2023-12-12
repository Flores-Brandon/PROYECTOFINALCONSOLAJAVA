/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DataStructures;
import Classes.ImethodLists;
import Classes.Node;
/**
 *
 * @author andre
 * @param <T>
 */
public class SimpleList<T extends Comparable<T>> implements ImethodLists<T> {
    private Node<T> head;

    public int length;

    public SimpleList() {
        head = null;
    }

    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            length++;
            return;
        }
        if (exist(newNode.getData())) {
            return;
        }
        if (newNode.compareTo(head) <= 0) {
            newNode.setNext(head);
            head = newNode;
            length++;
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.getNext() != null && currentNode.getNext().compareTo(newNode) < 0) {
            currentNode = currentNode.getNext();
        }
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        length++;
    }

    @Override
    public void delete(T data) {
        if (isEmpty()) {
            return;
        }
        if (head.getData().equals(data)) {
            head = head.getNext();
            System.out.println("- Data [" + data + "] removed from List...");
            length--;
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.getNext() != null && !currentNode.getNext().getData().equals(data)) {
            currentNode = currentNode.getNext();
        }
        if (currentNode.getNext() != null && currentNode.getNext().getData().equals(data)) {
            currentNode.setNext(currentNode.getNext().getNext());
            System.out.println("- Data [" + data + "] removed from List...");
            length--;
            return;
        }
        System.out.println("- Data [" + data + "] not removed from List...");
    }

    @Override
    public void search(T data) {
        if (isEmpty()) {
            return;
        }
        if (head.getData().equals(data)) {
            System.out.println("- Data [" + data + "] exists in List...");
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.getNext() != null && currentNode.compareTo((Node<T>) data) < 0) {
            currentNode = currentNode.getNext();
        }
        if (currentNode.getData().equals(data)) {
            System.out.println("- Data [" + data + "] exists in List...");
            return;
        }
        System.out.println("- Data [" + data + "] doesn't exist in List...");
    }

    @Override
    public void show() {
    if (isEmpty()) {
        System.out.println("Void List");
        return;
    }
    int i = 0;
    Node<T> currentNode = head;
    System.out.println("=== My Simple List ===");
    while (currentNode != null) {
        System.out.println("- Node [" + i + "] and Data: " + (currentNode.getData() != null ? currentNode.getData() : "null"));
        currentNode = currentNode.getNext();
        i++;
    }
}

    @Override
    public void showRevers() {
        if (isEmpty()) {
            System.out.println("Void List");
            return;
        }
        Node<T> currentNode = head;
        int x;
        System.out.println("=== My Simple List Reversed ===");
        for (int i = length - 1; i > -1; i--) {
            currentNode = head;
            x = 0;
            while (currentNode != null && x != i) {
                currentNode = currentNode.getNext();
                x++;
            }
            System.out.println("- Node [" + i + "] and Data: " + currentNode.getData());
        }
    }

    @Override
    public boolean exist(T data) {
        if (isEmpty()) {
            return false;
        }
        if (head.getData().equals(data)) {
            return true;
        }
        Node<T> currentNode = head;
        while (currentNode.getNext() != null && currentNode.compareTo((Node<T>) data) < 0) {
            currentNode = currentNode.getNext();
        }
        if (currentNode.getData().equals(data)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public void clear() {
        head = null;
    }
}
