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
public class DoublyListLinked<T> implements ImethodLists<T> {
    private DoubleNode<T> Head;
    private DoubleNode<T> LastNode;

    public DoublyListLinked() {
         Head = null;
        LastNode = null;        
    }

    public void add(T data) {
        DoubleNode<T> NewNode = new DoubleNode<>(data);
        if (isEmpty()) {
            Head = NewNode;
            LastNode = NewNode;
            return;
        }
        if (exist(NewNode.getData())) {
            return;
        }
        if (NewNode.compareTo(Head) <= 0) {
            Head.setBack(NewNode);
            NewNode.setNext(Head);
            Head = NewNode;
            return;
        }
        if (NewNode.compareTo(LastNode) >= 0) {
            LastNode.setNext(NewNode);
            NewNode.setBack(LastNode);
            LastNode = NewNode;
            return;
        }
        DoubleNode<T> CurrentNode = Head;
        while (CurrentNode.getNext() != null && CurrentNode.getNext().compareTo(NewNode) <= 0) {
            CurrentNode = CurrentNode.getNext();
        }
        NewNode.setNext(CurrentNode.getNext());
        NewNode.setBack(CurrentNode);
        if (CurrentNode.getNext() != null) {
            CurrentNode.getNext().setBack(NewNode);
        }
        CurrentNode.setNext(NewNode);
    }

    public void delete(T data) {
        if (isEmpty()) {
            return;
        }
        if (Head.getData().equals(data)) {
            Head = Head.getNext();
            if (Head != null) {
                Head.setBack(null);
            }
            System.out.println("- Data [" + data + "] remove form List...");
            return;
        }
        if (LastNode.getData().equals(data)) {
            LastNode = LastNode.getBack();
            if (LastNode != null) {
                LastNode.setNext(null);
            }
            System.out.println("- Data [" + data + "] remove form List...");
            return;
        }
        DoubleNode<T> CurrentNode = Head;
        while (CurrentNode.getNext() != null && CurrentNode.getNext().compareTo((DoubleNode<T>) data) <= 0) {
            CurrentNode = CurrentNode.getNext();
        }
        if (CurrentNode.getData().equals(data)) {
            CurrentNode.getBack().setNext(CurrentNode.getNext());
            if (CurrentNode.getNext() != null) {
                CurrentNode.getNext().setBack(CurrentNode.getBack());
            }
            System.out.println("- Data [" + data + "] remove form List...");
            return;
        }
        System.out.println("- Data [" + data + "] no remove form List...");
    }

    public void search(T data) {
        if (isEmpty()) {
            return;
        }
        if (Head.getData().equals(data)) {
            System.out.println("- Data [" + data + "] exist form List...");
            return;
        }
        if (LastNode.getData().equals(data)) {
            System.out.println("- Data [" + data + "] exist form List...");
            return;
        }
        DoubleNode<T> CurrentNode = Head;
        while (CurrentNode.getNext() != null && CurrentNode.compareTo((DoubleNode<T>) data) < 0) {
            CurrentNode = CurrentNode.getNext();
        }
        if (CurrentNode.getData().equals(data)) {
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
        System.out.println("=== My Doubly Linked List ===");
        while (CurrentNode != null) {
            System.out.println("- Node [" + i + "] and Data: " + CurrentNode.getData());
            CurrentNode = CurrentNode.getNext();
            i++;
        }
    }

    public void showRevers() {
        if (isEmpty()) {
            System.out.println("Void List");
            return;
        }
        DoubleNode<T> CurrentNode = LastNode;
        int i = 0;
        System.out.println("=== My Doubly Linked List Revers ===");
        do {
            System.out.println("- Node [" + i + "] and Data: " + CurrentNode.getData());
            CurrentNode = CurrentNode.getBack();
            i++;
        } while (CurrentNode != null);
    }

    public boolean exist(T data) {
        if (isEmpty()) {
            return false;
        }
        if (Head.getData().equals(data)) {
            return true;
        }
        if (LastNode.getData().equals(data)) {
            return true;
        }
        DoubleNode<T> CurrentNode = Head;
        while (CurrentNode.getNext() != null && CurrentNode.compareTo((DoubleNode<T>) data) < 0) {
            CurrentNode = CurrentNode.getNext();
        }
        if (CurrentNode.getData().equals(data)) {
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
}
