package midium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Dsotsog {
    class Node<T> {
        T data;
        Node<T> parent;
        List<Node<T>> children;

        Node(T data) {
            this.data = data;
            this.children = new LinkedList<Node<T>>();
        }

        Node<T> addChild(T data) {
            Node<T> child = new Node<T>(data);
            child.parent = this;
            this.children.add(child);
            return child;
        }

        void dfs(Node<T> node) {
            int[] dist;
            Stack<Node<T>> stack = new Stack<Node<T>>();
            stack.push(node);
            recursiveStack(stack);
        }

        void recursiveStack(Stack<Node<T>> stack) {
            if (stack.size() == 0) {
                return;
            }else{
                Node<T> tempNode = stack.pop();
                for(int i=0; i<tempNode.children.size(); i++) {
                    stack.push(tempNode.children.get(i));
                }
                recursiveStack(stack);
            }

        }

    }
    public static void main(String[] args) {

    }
}
