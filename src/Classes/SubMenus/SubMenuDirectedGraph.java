/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.SubMenus;
import java.util.Scanner;
import Classes.Information;
import Classes.Menus.MenuStructures;
import Classes.DataStructures.DirectedGraph;
import Classes.Enum.*;
/**
 *
 * @author andre
 */
public class SubMenuDirectedGraph {
    public static String Name = "Directed Graph";
    public static Information _Information = new Information();
    public static MenuStructures _ShowMenuStructures = new MenuStructures();
    public static DirectedGraph<Integer> _Items = new DirectedGraph<>();

    public static String[] _Option = _Information.Graph;

    public SubMenuDirectedGraph() { }

    public void Menu(int operation) {
        do {
            operation = 0;
            _ShowMenuStructures.PrintArray(_Option, Name);
            System.out.print("Write the number of one option: ");
            operation = Option(operation);
        } while (operation != _Option.length);
    }

    private int Option(int option) {
        try {
            Scanner scanner = new Scanner(System.in);
            option = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        Methods(EnumOperationsGraph.values()[option]);
        return option;
    }

    private void Methods(EnumOperationsGraph stack) {
        int dataF = 0, dataS = 0;
        switch (stack) {
            case AddVertex:
                System.out.println("Data: ");
                try { dataF = Integer.parseInt(new Scanner(System.in).nextLine()); } catch (Exception e) { }
                _Items.AddVertex(dataF);
                break;

            case AddEdge:
                System.out.println("Data: ");
                try { dataF = Integer.parseInt(new Scanner(System.in).nextLine()); } catch (Exception e) { }
                System.out.println("Second Data: ");
                try { dataS = Integer.parseInt(new Scanner(System.in).nextLine()); } catch (Exception e) { }
                _Items.AddEdge(dataF, dataS);
                break;

            case RemoveVertex:
                System.out.println("Data: ");
                try { dataF = Integer.parseInt(new Scanner(System.in).nextLine()); } catch (Exception e) { }
                _Items.RemoveVertex(dataF);
                break;

            case RemoveEdge:
                System.out.println("Data: ");
                try { dataF = Integer.parseInt(new Scanner(System.in).nextLine()); } catch (Exception e) { }
                System.out.println("Second Data: ");
                try { dataS = Integer.parseInt(new Scanner(System.in).nextLine()); } catch (Exception e) { }
                _Items.RemoveEdge(dataF, dataS);
                break;

            case ExistVertex:
                System.out.println("Data: ");
                try { dataF = Integer.parseInt(new Scanner(System.in).nextLine()); } catch (Exception e) { }
                _Items.VertexExists(dataF);
                new Scanner(System.in).nextLine(); // Read the enter key
                break;

            case ExistEdge:
                System.out.println("Data: ");
                try { dataF = Integer.parseInt(new Scanner(System.in).nextLine()); } catch (Exception e) { }
                System.out.println("Second Data: ");
                try { dataS = Integer.parseInt(new Scanner(System.in).nextLine()); } catch (Exception e) { }
                _Items.EdgeExists(dataF, dataS);
                new Scanner(System.in).nextLine(); // Read the enter key
                break;

            case GetAllVertex:
                System.out.println("Get All Vertex");
                _Items.GetAllVertices();
                new Scanner(System.in).nextLine(); // Read the enter key
                break;

            case GetAllEdge:
                System.out.println("Get All Edges");
                _Items.GetAllEdges();
                new Scanner(System.in).nextLine(); // Read the enter key
                break;

            case Transverse:
                System.out.println("Data: ");
                try { dataF = Integer.parseInt(new Scanner(System.in).nextLine()); } catch (Exception e) { }
                _Items.TraverseBFS(dataF);
                new Scanner(System.in).nextLine(); // Read the enter key
                break;

            case CalculateDegree:
                System.out.println("Insert One data: ");
                try { dataF = Integer.parseInt(new Scanner(System.in).nextLine()); } catch (Exception e) { }
                _Items.CalculateDegree(dataF);
                new Scanner(System.in).nextLine(); // Read the enter key
                break;

            case CalculateBFSLevels:
                System.out.println("Insert One data: ");
                try { dataF = Integer.parseInt(new Scanner(System.in).nextLine()); } catch (Exception e) { }
                _Items.CalculateBFSLevels(dataF);
                new Scanner(System.in).nextLine(); // Read the enter key
                break;
        }
    }
}
