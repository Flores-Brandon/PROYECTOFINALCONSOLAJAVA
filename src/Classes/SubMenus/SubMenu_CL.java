/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.SubMenus;
import java.util.Random;
import Classes.Information;
import Classes.Menus.*;
import Classes.DataStructures.*;
import java.util.Scanner;
import Classes.Enum.*;
/**
 *
 * @author andre
 */
public class SubMenu_CL {
    public static String Name = "Circular List";
    public static Random _Random = new Random();
    public static Information _Information = new Information();
    public static MenuStructures _ShowMenuStructures = new MenuStructures();
    public static CircularList<Integer> _Items = new CircularList<>();

    public static String[] _OptionList = _Information.List;

    public SubMenu_CL() {
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
            Scanner scanner = new Scanner(System.in);
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
        }
        System.out.println();
        Methos(EnumOperationsList.values()[option]);
        return option;
    }

    private void Methos(EnumOperationsList Lists) {
        int Data = 0;
        Scanner scanner = new Scanner(System.in);
        switch (Lists) {
            case Generate -> {
                System.out.print("Generate: ");
                try {
                    Data = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                }
                for (int i = 0; i < Data; i++) {
                    _Items.add(_Random.nextInt(100000));
                }
                System.out.println("Finish");
                scanner.nextLine();
            }

            case Add -> {
                System.out.print("Insert data: ");
                try {
                    Data = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                }
                _Items.add(Data);
            }

            case Delete -> {
                System.out.print("Delete one data: ");
                try {
                    Data = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                }
                _Items.delete(Data);
            }

            case Search -> {
                System.out.print("Search one data: ");
                try {
                    Data = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                }
                _Items.search(Data);
            }

            case Show -> {
                _Items.show();
                scanner.nextLine();
            }

            case ShowRevers -> {
                _Items.showRevers();
                scanner.nextLine();
            }

            case Clear -> _Items.clear();
        }
    }
}
