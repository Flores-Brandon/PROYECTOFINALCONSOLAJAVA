/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Classes;

/**
 *
 * @author andre
 */
public interface ImethodLists<T> {
    void add(T data);
void delete(T data);
void search(T data);
boolean exist(T data);
void showRevers();
void show();
boolean isEmpty();
void clear();
}
