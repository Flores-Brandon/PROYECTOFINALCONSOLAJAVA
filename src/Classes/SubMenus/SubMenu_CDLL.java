/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.SubMenus;
import java.util.Random;
import java.util.Scanner;
import Classes.Information;
import Classes.Menus.*;
import Classes.DataStructures.CircularDoublyLinkedList;
import Classes.Enum.*;
/**
 *
 * @author andre
 */
public class SubMenu_CDLL {
    public static String Name = "Circular Doubly Linked List";
    public static Random _Random = new Random();
    public static Information _Information = new Information();
    public static MenuStructures _ShowMenuStructures = new MenuStructures();
    public static CircularDoublyLinkedList<Integer> _Items = new CircularDoublyLinkedList<>();
    public static String[] _OptionList = _Information.List;

    public SubMenu_CDLL() {
    }

    public void MenuOption(int Operation) {
        do {
            Operation = 0;
            _ShowMenuStructures.PrintArray(_OptionList, Name);
            System.out.print("Write the number of one option: ");
            Operation = Option(Operation);
        } while (Operation != _OptionList.length - 1);
        return;
    }

    private int Option(int option) {
        try {
            option = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (Exception e) {
        }
        EnumOperationsList x = EnumOperationsList.values()[option];
        System.out.println();
        Methos(x);
        return option;
    }

    private void Methos(EnumOperationsList Lists) {
        int Data = 0;
        switch (Lists) {
            case Generate:
                System.out.print("Generate: ");
                try {
                    Data = Integer.parseInt(new Scanner(System.in).nextLine());
                } catch (Exception e) {
                }
                for (int i = 0; i < Data; i++) {
                    _Items.add(_Random.nextInt(100000));
                }
                System.out.println("Finish");
                new Scanner(System.in).nextLine();
                break;

            case Add:
                System.out.print("How many numbers would you like to add: ");
                try {
                    Data = Integer.parseInt(new Scanner(System.in).nextLine());
                } catch (Exception e) {
                }
                _Items.add(Data);
                break;

            case Delete:
                System.out.print("Delete one data: ");
                try {
                    Data = Integer.parseInt(new Scanner(System.in).nextLine());
                } catch (Exception e) {
                }
                _Items.delete(Data);
                break;

            case Search:
                System.out.print("Search one data: ");
                try {
                    Data = Integer.parseInt(new Scanner(System.in).nextLine());
                } catch (Exception e) {
                }
                _Items.search(Data);
                break;

            case Show:
                _Items.show();
                new Scanner(System.in).nextLine();
                break;

            case ShowRevers:
                _Items.showRevers();
                new Scanner(System.in).nextLine();
                break;

            case Clear:
                _Items.clear();
                break;
        }
    }
}
