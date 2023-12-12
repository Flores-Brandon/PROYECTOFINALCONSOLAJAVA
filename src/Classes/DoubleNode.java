/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.math.BigDecimal;

/**
 *
 * @author andre
 * @param <T>
 */
public class DoubleNode<T> implements Comparable<DoubleNode<T>> {
    public DoubleNode<T> Back;
    public DoubleNode<T> Next;
    public T Data;

    public DoubleNode(T data) {
        Data = data;
        Next = null;
        Back = null;
    }

    @Override
    public int compareTo(DoubleNode<T> anotherData) {
        // Caso 1: Ambos tipos son numéricos
        if (esNumero(Data) && esNumero(anotherData.getData())) {
            long value1 = Long.parseLong(Data.toString());
            long value2 = Long.parseLong(anotherData.getData().toString());
            return Long.compare(value1, value2);
        }

        // Caso 2: Solo el dato del nodo que está comparando es numérico
        if (esNumero(Data) && (anotherData.getData() instanceof String || anotherData.getData() instanceof Character)) {
            long value1 = Long.parseLong(Data.toString());
            long value2 = Long.parseLong(anotherData.getData().toString());
            return Long.compare(value1, value2);
        }

        // Caso 3: Solo el dato del nodo a comparar es numérico
        if (esNumero(anotherData.getData()) && (Data instanceof String || Data instanceof Character)) {
            long value1 = Long.parseLong(Data.toString());
            long value2 = Long.parseLong(anotherData.getData().toString());
            return Long.compare(value1, value2);
        }

        // Caso 4: Son diferentes tipos que se pueden comparar
        if (Data instanceof Comparable && anotherData.getData() instanceof Comparable) {
            return Integer.compare(Data.toString().length(), anotherData.getData().toString().length());
        }

        return 0;
    }

    public int CompareTo(T anotherData) {
        // Caso 1: Ambos tipos son numéricos
        if (esNumero(Data) && esNumero(anotherData)) {
            long value1 = Long.parseLong(Data.toString());
            long value2 = Long.parseLong(anotherData.toString());
            return Long.compare(value1, value2);
        }

        // Caso 2: Solo el dato del nodo que está comparando es numérico
        if (esNumero(Data) && (anotherData instanceof String || anotherData instanceof Character)) {
            long value1 = Long.parseLong(Data.toString());
            long value2 = Long.parseLong(anotherData.toString());
            return Long.compare(value1, value2);
        }

        // Caso 3: Solo el dato del nodo a comparar es numérico
        if (esNumero(anotherData) && (Data instanceof String || Data instanceof Character)) {
            long value1 = Long.parseLong(Data.toString());
            long value2 = Long.parseLong(anotherData.toString());
            return Long.compare(value1, value2);
        }

        // Caso 4: Son diferentes tipos que se pueden comparar
        if (Data instanceof Comparable && anotherData instanceof Comparable) {
            return Integer.compare(Data.toString().length(), anotherData.toString().length());
        }
        return 0;
    }

    private boolean esNumero(Object value) {
        return value instanceof Byte || value instanceof Short || value instanceof Integer || value instanceof Long
                || value instanceof Float || value instanceof Double || value instanceof BigDecimal;
    }

    public T getData() {
        return Data;
    }

    public DoubleNode<T> getBack() {
        return Back;
    }

    public void setBack(DoubleNode<T> back) {
        Back = back;
    }

    public DoubleNode<T> getNext() {
        return Next;
    }

    public void setNext(DoubleNode<T> next) {
        Next = next;
    }
}
