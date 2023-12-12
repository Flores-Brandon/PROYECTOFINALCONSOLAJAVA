/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DataStructures;
import Classes.DoubleNode;
import Classes.ImethodLists;
/**
 *
 * @author andre
 */
public class CircularDoublyLinkedList<T> implements ImethodLists<T> {
    private DoubleNode<T> Head;
    private DoubleNode<T> LastNode;

    public CircularDoublyLinkedList() {
        Head = null;
        LastNode = null;
    }

    public void add(T data) {
        DoubleNode<T> NewNode = new DoubleNode<>(data);
        if (isEmpty()) {
            Head = NewNode;
            LastNode = NewNode;
            Head.Back = LastNode;
            LastNode.Next = Head;
            return;
        }
        if (exist(NewNode.Data)) {
            return;
        }
        if (NewNode.CompareTo((T) Head) <= 0) {
            NewNode.Next = Head;
            NewNode.Back = LastNode;
            Head.Back = NewNode;
            Head = NewNode;
            LastNode.Next = Head;
            return;
        }
        if (NewNode.CompareTo((T) LastNode) >= 0) {
            LastNode.Next = NewNode;
            NewNode.Back = LastNode;
            NewNode.Next = Head;
            LastNode = NewNode;
            Head.Back = LastNode;
            return;
        }
        DoubleNode<T> CurrentNode = Head;
        while (CurrentNode.Next != Head && CurrentNode.Next.CompareTo((T) NewNode) <= 0) {
            CurrentNode = CurrentNode.Next;
        }
        NewNode.Next = CurrentNode.Next;
        NewNode.Back = CurrentNode;
        CurrentNode.Next.Back = NewNode;
        CurrentNode.Next = NewNode;
    }

    public void delete(T data) {
        if (isEmpty()) {
            return;
        }
        if (objectEquals(Head.Data, LastNode.Data)) {
            clear();
            System.out.println("- Data [" + data + "] remove form List...");
            return;
        }
        if (objectEquals(Head.Data, data)) {
            Head = Head.Next;
            Head.Back = LastNode;
            LastNode.Next = Head;
            System.out.println("- Data [" + data + "] remove form List...");
            return;
        }
        if (objectEquals(LastNode.Data, data)) {
            LastNode = LastNode.Back;
            LastNode.Next = Head;
            Head.Back = LastNode;
            System.out.println("- Data [" + data + "] remove form List...");
            return;
        }
        DoubleNode<T> CurrentNode = Head;
        while (CurrentNode.Next != Head && !objectEquals(CurrentNode.Next.Data, data)) {
            CurrentNode = CurrentNode.Next;
        }
        if (objectEquals(CurrentNode.Next.Data, data)) {
            CurrentNode.Next.Next.Back = CurrentNode;
            CurrentNode.Next = CurrentNode.Next.Next;
            System.out.println("- Data [" + data + "] remove form List...");
            return;
        }
        System.out.println("- Data [" + data + "] no remove form List...");
    }

    public void search(T data) {
        if (isEmpty()) {
            return;
        }
        if (objectEquals(Head.Data, data)) {
            System.out.println("- Data [" + data + "] exist form List...");
            return;
        }
        if (objectEquals(LastNode.Data, data)) {
            System.out.println("- Data [" + data + "] exist form List...");
            return;
        }
        DoubleNode<T> CurrentNode = Head;
        while (CurrentNode.Next != Head && !objectEquals(CurrentNode.Next.Data, data)) {
            CurrentNode = CurrentNode.Next;
        }
        if (objectEquals(CurrentNode.Data, data)) {
            System.out.println("- Data [" + data + "] exist form List...");
            return;
        }
        System.out.println("- Data [" + data + "] no exist form List...");
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("Void List");
            return;
        }
        DoubleNode<T> CurrentNode = Head;
        int i = 0;
        System.out.println("=== My Cicular Doubly Linked List ===");
        do {
            System.out.println("- Node [" + i + "] and Data: " + CurrentNode.Data);
            CurrentNode = CurrentNode.Next;
            i++;
        } while (CurrentNode != Head);
    }

    public void showRevers() {
        if (isEmpty()) {
            System.out.println("Void List");
            return;
        }
        DoubleNode<T> CurrentNode = LastNode;
        int i = 0;
        System.out.println("=== My Cicular Doubly Linked List Revers ===");
        do {
            System.out.println("- Node [" + i + "] and Data: " + CurrentNode.Data);
            CurrentNode = CurrentNode.Back;
            i++;
        } while (CurrentNode != LastNode);
    }

    public boolean exist(T data) {
        if (isEmpty()) {
            return false;
        }
        if (objectEquals(Head.Data, data)) {
            return true;
        }
        if (objectEquals(LastNode.Data, data)) {
            return true;
        }
        DoubleNode<T> CurrentNode = Head;
        while (CurrentNode.Next != Head && !objectEquals(CurrentNode.Data, data)) {
            CurrentNode = CurrentNode.Next;
        }
        if (objectEquals(CurrentNode.Data, data)) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return Head == null;
    }

    public void clear() {
        Head = null;
        LastNode = null;
    }

    private boolean objectEquals(T obj1, T obj2) {
        if (obj1 == null || obj2 == null) {
            return obj1 == obj2;
        }
        return obj1.equals(obj2);
    }
}
