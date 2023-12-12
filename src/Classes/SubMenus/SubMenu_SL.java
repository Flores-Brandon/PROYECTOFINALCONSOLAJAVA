/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.SubMenus;
import java.util.Scanner;
import Classes.Information;
import java.util.Random;
import Classes.Menus.MenuStructures;
import Classes.DataStructures.SimpleList;
import Classes.Enum.*;
/**
 *
 * @author andre
 */
public class SubMenu_SL {
    public static String Name = "Simple List";

    public static Random _Random = new Random();
    public static Information _Information = new Information();
    public static MenuStructures _ShowMenuStructures = new MenuStructures();
    public static SimpleList<Integer> _Items = new SimpleList<>();

    public static String[] _OptionList = _Information.List;

    public SubMenu_SL() {
    }

    public void menuOption(int operation) {
        do {
            operation = 0;
            _ShowMenuStructures.PrintArray(_OptionList, Name);
            System.out.print("Write the number of one option: ");
            operation = option(operation);
        } while (operation != _OptionList.length - 1);
    }

    private int option(int option) {
        try {
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
        } catch (Exception e) {
        }
        System.out.println();
        methods(EnumOperationsList.values()[option]);
        return option;
    }

    private void methods(EnumOperationsList lists) {
        int data = 0;
        switch (lists) {
            case Generate -> {
                System.out.print("Generate: ");
                try {
                    Scanner scanner = new Scanner(System.in);
                    data = scanner.nextInt();
                } catch (Exception e) {
                }
                for (int i = 0; i < data; i++) {
                    _Items.add(_Random.nextInt(100000));
                }
                System.out.println("Finish");
                new Scanner(System.in).nextLine(); // Para esperar a que el usuario presione Enter
            }

            case Add -> {
                System.out.print("Insert one data: ");
                try {
                    Scanner scanner = new Scanner(System.in);
                    data = scanner.nextInt();
                } catch (Exception e) {
                }
                _Items.add(data);
            }

            case Delete -> {
                System.out.print("Delete one data: ");
                try {
                    Scanner scanner = new Scanner(System.in);
                    data = scanner.nextInt();
                } catch (Exception e) {
                }
                _Items.delete(data);
            }

            case Search -> {
                System.out.print("Search one data: ");
                try {
                    Scanner scanner = new Scanner(System.in);
                    data = scanner.nextInt();
                } catch (Exception e) {
                }
                _Items.search(data);
            }

            case Show -> {
                _Items.show();
                new Scanner(System.in).nextLine(); // Para esperar a que el usuario presione Enter
            }

            case ShowRevers -> {
                _Items.showRevers();
                new Scanner(System.in).nextLine(); // Para esperar a que el usuario presione Enter
            }

            case Clear -> _Items.clear();
        }
    }
}
