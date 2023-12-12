/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Menus;
import java.util.Scanner;
import Classes.Information;
import Classes.SubMenus.SubMenuDirectedGraph;
import Classes.SubMenus.SubMenuUndirectedGraph;
import Classes.Enum.*;
/**
 *
 * @author andre
 */
public class MenuGraph {
    public static String Name = "Graph";
    public static Information _Information = new Information();
    public static MenuStructures _ShowMenuStructures = new MenuStructures();
    public static SubMenuDirectedGraph _SubMenuDirectedGraph = new SubMenuDirectedGraph();
    public static SubMenuUndirectedGraph _SubMenuUndirectedGraph = new SubMenuUndirectedGraph();

    public static String[] _TypeGraph = _Information.TypeGraph;

    public MenuGraph() { }

    public void CycleGraph(int operation) {
        do {
            operation = 0;
            _ShowMenuStructures.PrintArray(_TypeGraph, Name);
            System.out.print("Write the number of one option: ");
            operation = Option(operation);
        } while (operation != _TypeGraph.length);
    }

    private int Option(int option) {
        try {
            Scanner scanner = new Scanner(System.in);
            option = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        Methos(option);
        return option;
    }

    private void Methos(int option) {
        EnumTypeGraph graph = EnumTypeGraph.values()[option];
        switch (graph) {
            case DirectedGraph:
                _SubMenuDirectedGraph.Menu(option);
                break;

            case UndirectedGraph:
                _SubMenuUndirectedGraph.Menu(option);
                break;
        }
    }
}
