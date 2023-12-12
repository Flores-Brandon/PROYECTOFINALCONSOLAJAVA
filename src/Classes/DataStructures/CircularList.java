/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DataStructures;
import Classes.ImethodLists;
import Classes.*;
import java.util.Objects;
/**
 *
 * @author andre
 */
public class CircularList<T> implements ImethodLists<T> {
    private Node<T> Head;
    private Node<T> LastNode;
    public int Lenght;

    public CircularList() {
        Head = null;
        LastNode = null;
    }

    @Override
    public void add(T data) {
        Node<T> NewNode = new Node<>(data);
        if (isEmpty()) {
            Head = NewNode;
            Head.next = Head;
            LastNode = NewNode;
            Lenght++;
            return;
        }
        if (exist(NewNode.data)) {
            return;
        }
        if (NewNode.compareTo(Head) <= 0) {
            NewNode.next = Head;
            Head = NewNode;
            LastNode.next = Head;
            Lenght++;
            return;
        }
        if (NewNode.compareTo(LastNode) >= 0) {
            LastNode.next = NewNode;
            NewNode.next = Head;
            LastNode = NewNode;
            Lenght++;
            return;
        }
        Node<T> CurrentNode = Head;
        while (CurrentNode.next != Head && CurrentNode.next.compareTo(NewNode) <= 0) {
            CurrentNode = CurrentNode.next;
        }
        NewNode.next = CurrentNode.next;
        CurrentNode.next = NewNode;
        Lenght++;
    }

    @Override
    public void delete(T data) {
        if (isEmpty()) {
            return;
        }
        if (Objects.equals(Head.data, data)) {
            Head = Head.next;
            LastNode.next = Head;
            System.out.println("- Data [" + data + "] remove form List...");
            Lenght--;
            return;
        }

        Node<T> CurrentNode = Head;
        while (CurrentNode.next != Head && CurrentNode.next.compareTo((Node<T>) data) < 0) {
            CurrentNode = CurrentNode.next;
        }
        if (CurrentNode.next == LastNode && Objects.equals(LastNode.data, data)) {
            CurrentNode.next = CurrentNode.next.next;
            LastNode = CurrentNode;
            LastNode.next = Head;
            System.out.println("- Data [" + data + "] remove form List...");
            Lenght--;
            return;
        }
        if (Objects.equals(CurrentNode.next.data, data)) {
            CurrentNode.next = CurrentNode.next.next;
            System.out.println("- Data [" + data + "] remove form List...");
            Lenght--;
            return;
        }
        System.out.println("- Data [" + data + "] no remove form List...");
    }
@Override
    public void search(T data) {
        if (isEmpty()) {
            return;
        }
        if (Objects.equals(Head.data, data)) {
            System.out.println("- Data [" + data + "] exist form List...");
            return;
        }
        Node<T> CurrentNode = Head;
        while (CurrentNode.next != Head && CurrentNode.next.compareTo((Node<T>) data) < 0) {
            CurrentNode = CurrentNode.next;
        }
        if (Objects.equals(CurrentNode.next.data, data)) {
            System.out.println("- Data [" + data + "] exist form List...");
            return;
        }
        System.out.println("- Data [" + data + "] no exist form List...");
    }
@Override
    public void show() {
        if (isEmpty()) {
            System.out.println("Void List");
            return;
        }
        Node<T> CurrentNode = Head;
        int i = 0;
        System.out.println("=== My Circular List ===");
        do {
            System.out.println("- Node [" + i + "] and Data: " + CurrentNode.data);
            CurrentNode = CurrentNode.next;
            i++;
        } while (CurrentNode != Head);
    }
@Override
    public void showRevers() {
        if (isEmpty()) {
            System.out.println("Void List");
            return;
        }
        Node<T> CurrentNode = Head;
        int x = 0;
        System.out.println("=== My Circular List Revers ===");
        for (int i = Lenght - 1; i > -1; i--) {
            CurrentNode = Head;
            x = 0;
            while (CurrentNode != null && x != i) {
                CurrentNode = CurrentNode.next;
                x++;
            }
            System.out.println("- Node [" + i + "] and Data: " + CurrentNode.data);
        }
    }

    @Override
    public boolean exist(T data) {
        if (isEmpty()) {
            return false;
        }
        if (Objects.equals(Head.data, data)) {
            return true;
        }
        Node<T> CurrentNode = Head;
        while (CurrentNode.next != Head && !Objects.equals(CurrentNode.data, data)) {
            CurrentNode = CurrentNode.next;
        }
        if (Objects.equals(CurrentNode.data, data)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return Head == null;
    }

    
    @Override
    public void clear() {
        Head = null;
        LastNode = null;
    }
}
