/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DataStructures;

/**
 *
 * @author andre
 */
class Node{
    public Node Left ;
public Node Right ;
public int Data;

public Node(int Data)
{
    this.Data = Data;
    Left = null;
    Right = null;
}
}
public class BinaryTree {
    private Node Root;

    public BinaryTree() {
        Root = null;
    }

    public void Add(int value) {
        Root = _Add(Root, value);
    }

    public void Delete(int value) {
        Root = _Delete(Root, value);
    }

    public boolean Search(int value) {
        return _Search(Root, value);
    }

    public void PreOrder() {
        _PreOrder(Root);
        System.out.println();
    }

    public void PostOrder() {
        _PostOrder(Root);
        System.out.println();
    }

    public void InOrder() {
        _InOrder(Root);
        System.out.println();
    }

    private Node _Add(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.Data) {
            node.Left = _Add(node.Left, value);
        } else if (value > node.Data) {
            node.Right = _Add(node.Right, value);
        }
        return node;
    }

    private Node _Delete(Node node, int value) {
        if (node == null) {
            return node;
        }
        if (value < node.Data) {
            node.Left = _Delete(node.Left, value);
        } else if (value > node.Data) {
            node.Right = _Delete(node.Right, value);
        } else {
            if (node.Left == null) {
                return node.Right;
            } else if (node.Right == null) {
                return node.Left;
            }
            node.Data = MinValue(node.Right);
            node.Right = _Delete(node.Right, node.Data);
        }
        return node;
    }

    private int MinValue(Node node) {
        int min = node.Data;
        while (node.Left != null) {
            min = node.Left.Data;
            node = node.Left;
        }
        return min;
    }

    private boolean _Search(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value == node.Data) {
            return true;
        }

        if (value < node.Data) {
            return _Search(node.Left, value);
        } else {
            return _Search(node.Right, value);
        }
    }

    private void _PreOrder(Node tree) {
        if (tree != null) {
            System.out.print(tree.Data + " ");
            _PreOrder(tree.Left);
            _PreOrder(tree.Right);
        }
    }

    private void _PostOrder(Node tree) {
        if (tree != null) {
            _PostOrder(tree.Left);
            _PostOrder(tree.Right);
            System.out.print(tree.Data + " ");
        }
    }

    private void _InOrder(Node tree) {
        if (tree != null) {
            _InOrder(tree.Left);
            System.out.print(tree.Data + " ");
            _InOrder(tree.Right);
        }
    }
}
