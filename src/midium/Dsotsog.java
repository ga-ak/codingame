package midium;

import java.util.*;

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
    }
    public static void main(String[] args) {
		Dsotsog out = new Dsotsog();
	    Dsotsog.Node<String> root = out.new Node<>("1");
	    Node<String> temp;
	    Map<Integer, Node<String>> map = new HashMap<>();
	    map.put(1, root);
	    map.put(2, root.addChild("2"));
	    map.put(3, root.addChild("3"));
	    temp = root.children.get(0);
	    map.put(4, temp.addChild("4"));
	    map.put(5, temp.addChild("5"));
	    temp = root.children.get(1);
	    map.put(6, temp.addChild("6"));
	    temp = temp.children.get(0);
	    map.put(7, temp.addChild("7"));
	    Dsotsog.Node<String> root2 = out.new Node<>("8");
	    map.put(8, root2);
	    temp = root2;
	    map.put(9, temp.addChild("9"));
	    temp = temp.children.get(0);
	    map.put(10, temp.addChild("10"));
	    temp = temp.children.get(0);
	    map.put(11, temp.addChild("11"));
	    temp = temp.children.get(0);
	    map.put(12, temp.addChild("12"));

	    Set<Node<String>> ancestorNodeSet = new HashSet<>();
	    int maxDist = Integer.MIN_VALUE;
	    Iterator<Map.Entry<Integer,Node<String>>> itr = map.entrySet().iterator();
	    while(itr.hasNext()) {
		    Map.Entry<Integer, Node<String>> e = itr.next();
		    Node<String> tempNode = e.getValue();
		    //System.out.println(tempNode.data);
		    while(tempNode.parent != null) {
			    tempNode = tempNode.parent;
		    }
		    //System.out.println(tempNode.data);
		    if(!ancestorNodeSet.contains(tempNode)) {
			    if(maxDist < tempNode.dfs(tempNode)) {
				    maxDist = tempNode.dfs(tempNode);
			    }
			    ancestorNodeSet.add(tempNode);
		    }
	    }

	    System.out.println("가장 깊은 노드의 깊이 : "+maxDist);
    }
}
