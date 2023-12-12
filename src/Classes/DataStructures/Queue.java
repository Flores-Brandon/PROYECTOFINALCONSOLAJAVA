/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DataStructures;
import Classes.Nodo;
/**
 *
 * @author andre
 */

public class Queue {
    private Nodo Head;
    private Nodo LastNode;

    public Queue() {
        Head = null;
        LastNode = null;
    }

    public void Enqueue(int data) {
        Nodo newNode = new Nodo(data);
        if (isEmpty()) {
            Head = newNode;
            LastNode = newNode;
            return;
        }
        if (exist(newNode.Data)) {
            return;
        }
        if (newNode.Data < Head.Data) {
            newNode.Next = Head;
            Head = newNode;
            return;
        }
        Nodo currentNode = Head;
        while (currentNode.Next != null && currentNode.Next.Data < newNode.Data) {
            currentNode = currentNode.Next;
        }
        newNode.Next = currentNode.Next;
        currentNode.Next = newNode;
        currentNode = Head;
        while (currentNode.Next != null) {
            currentNode = currentNode.Next;
        }
        LastNode = currentNode;
    }

    public void Dequeue() {
        if (isEmpty()) {
            System.out.println("Void Queue");
            return;
        }
        if (Head.Next != null) {
            Head = Head.Next;
            return;
        }
        clear();
    }

    public void Show() {
        if (isEmpty()) {
            System.out.println("Void Queue");
            return;
        }
        int i = 0;
        Nodo currentNode = Head;
        System.out.println("=== My Queue ===");
        while (currentNode != null) {
            System.out.println("- Node[" + i + "] and Data: " + currentNode.Data);
            currentNode = currentNode.Next;
            i++;
        }
    }

    private boolean exist(int data) {
        if (isEmpty()) {
            return false;
        }
        if (Head.Data == data) {
            return true;
        }
        Nodo currentNode = Head;
        while (currentNode.Next != null && currentNode.Next.Data < data) {
            currentNode = currentNode.Next;
        }
        return currentNode.Data == data;
    }

    private boolean isEmpty() {
        return Head == null;
    }

    public void clear() {
        Head = null;
        LastNode = null;
    }
}

