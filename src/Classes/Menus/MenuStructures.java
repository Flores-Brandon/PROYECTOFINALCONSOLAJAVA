/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Menus;
import Classes.Enum.EnumDataStructures;
import Classes.Information;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class MenuStructures {
    public String Name = "None";

    public static Information _Information = new Information();
    public static MenuStack _ShowMenuStack = new MenuStack();
    public static MenuQueue _ShowMenuQueue = new MenuQueue();
    public static MenuList _ShowMenuList = new MenuList();
    public static MenuTree _ShowMenuTree = new MenuTree();
    public static MenuGraph _ShowMenuGraph = new MenuGraph();
    public static MenuAlgorithm _ShowMenuAlgorithm = new MenuAlgorithm();

    public String[] _TypeDataStructures = _Information.TypeDataStructures;

    public MenuStructures() { }

    public void PrintArray(Object[] array, String Name) {
        System.out.println("\t@Andres Vazquez I22050385 Data Structures: " + Name);
        for (Object item : array) {
            System.out.println(item.toString());
        }
    }

    public int Option(int option) {
        try {
            Scanner scanner = new Scanner(System.in);
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) { }
        EnumDataStructures x = EnumDataStructures.values()[option];
        System.out.println("\033[H\033[2J");
        Menu(option, x);
        return option;
    }

    private void Menu(int Numer, EnumDataStructures DataType) {
        System.out.println("\033[H\033[2J");
        switch (DataType) {
            case Stack -> {
                _ShowMenuStack.CycleStack(Numer);
                Name = "None";
            }

            case Queues -> _ShowMenuQueue.CycleQueue(Numer);

            case List -> _ShowMenuList.cycleList(Numer);

            case Tree -> _ShowMenuTree.CycleTree(Numer);

            case Graph -> _ShowMenuGraph.CycleGraph(Numer);

            case Algorithm -> _ShowMenuAlgorithm.CycleAlgorithm(Numer);

            case Exit -> {
                System.out.println("Bye :)");
                new Scanner(System.in).nextLine();
            }
        }
    }
}
