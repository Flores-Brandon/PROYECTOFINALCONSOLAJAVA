/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Menus;
import java.util.Scanner;
import Classes.Information;
import Classes.DataStructures.BinaryTree;
import Classes.Enum.*;

/**
 *
 * @author andre
 */
public class MenuTree {
    public static String Name = "Tree";

    public static Information _Information = new Information();
    public static MenuStructures _ShowMenuStructures = new MenuStructures();
    public static BinaryTree _Items = new BinaryTree();

    public static String[] _OptionTree = _Information.Tree;

    public MenuTree() {
    }

    public void CycleTree(int Operation) {
        do {
            Operation = 0;
            _ShowMenuStructures.PrintArray(_OptionTree, Name);
            System.out.print("Write the number of one option: ");
            Operation = OptionTree(Operation);
        } while (Operation != _OptionTree.length);
        return;
    }

    public int OptionTree(int option) {
        try {
            Scanner scanner = new Scanner(System.in);
            option = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
        }
        EnumOperationsTree x = EnumOperationsTree.values()[option];
        System.out.println("");
        MethosTree(x);
        return option;
    }

    public void MethosTree(EnumOperationsTree Tree) {
        int Data = 0;
        switch (Tree) {
            case Add:
                System.out.print("Data: ");
                try {
                    Scanner scanner = new Scanner(System.in);
                    Data = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                }
                _Items.Add(Data);
                break;

            case Delete:
                System.out.print("Data: ");
                try {
                    Scanner scanner = new Scanner(System.in);
                    Data = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                }
                _Items.Delete(Data);
                break;

            case Search:
                System.out.print("Data: ");
                try {
                    Scanner scanner = new Scanner(System.in);
                    Data = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                }
                _Items.Search(Data);
                break;

            case InOrder:
                _Items.InOrder();
                new Scanner(System.in).nextLine();
                break;

            case PosOrder:
                _Items.PostOrder();
                new Scanner(System.in).nextLine();
                break;

            case PreOrder:
                _Items.PreOrder();
                new Scanner(System.in).nextLine();
                break;
        }
    }
}
