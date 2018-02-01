package midium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Dsotsog {
    class Node<T> {
        T data;
        Node<T> parent;
        List<Node<T>> children;
	    int count = 0;
	    int depth = 0;
        Node(T data) {
            this.data = data;
            this.children = new LinkedList<>();
        }

        Node<T> addChild(T data) {
            Node<T> child = new Node<>(data);
            child.parent = this;
            this.children.add(child);
            return child;
        }

        int dfs(Node<T> node) {
            int max = Integer.MIN_VALUE;
            Stack<Node<T>> stack = new Stack<>();
	        Node<T> deepestNode = node;
            Node<T> tempNode;
            stack.push(node);
	        while (stack.size() != 0) {
		        tempNode = stack.pop();
		        for(int i=0; i<tempNode.children.size(); i++) {
			        stack.push(tempNode.children.get(tempNode.children.size()-1-i));
			        tempNode.children.get(tempNode.children.size()-1-i).depth = tempNode.depth+1;
		        }
		        if (deepestNode.depth < tempNode.depth) {
			        deepestNode = tempNode;
		        }
	        }
	        return deepestNode.depth;
        }

        /*Node<T> recursiveStack(Stack<Node<T>> stack, Node<T> node) {
            if (stack.size() == 0) {
                 return null;
            }else{
				Node<T> deepestNode = node;
                Node<T> tempNode = stack.pop();
	            System.out.print(count+++" : ");
                System.out.println(tempNode.depth+" "+tempNode.data);

                for(int i=0; i<tempNode.children.size(); i++) {
                    stack.push(tempNode.children.get(tempNode.children.size()-1-i));
                    tempNode.children.get(tempNode.children.size()-1-i).depth = tempNode.depth+1;
                }
				if (deepestNode.depth < tempNode.depth) {
                	deepestNode = tempNode;
				}

                recursiveStack(stack, deepestNode);
                return deepestNode;

            }

        }*/
    }
    public static void main(String[] args) {
		Dsotsog out = new Dsotsog();
	    Dsotsog.Node<String> root = out.new Node<>("1");
	    Node<String> temp;
	    root.addChild("2");
	    root.addChild("3");
	    temp = root.children.get(0);
	    temp.addChild("4");
	    temp.addChild("5");
	    temp = root.children.get(1);
	    temp.addChild("6");
	    temp = temp.children.get(0);
	    temp.addChild("7");

	    System.out.println("가장 깊은 노드의 깊이 : "+root.dfs(root));
    }
}
