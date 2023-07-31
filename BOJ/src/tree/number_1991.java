package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char data;
	Node left;
	Node right;
	
	Node(char data) {
		this.data = data;
	}
}

class Tree {
	
	public Node root;
	
	public void createNode(char data, char leftData, char rightData) {
		if (root == null) {
			root = new Node(data);
			root.left = leftData == '.' ? null : new Node(leftData);
			root.right = rightData == '.' ? null : new Node(rightData);
			return;
		}
		searchNode(root, data, leftData, rightData);
	}
	
	public void searchNode(Node node, char data, char leftData, char rightData) {
		if (node == null) return;
		
		if (node.data == data) {
			node.left = leftData == '.' ? null : new Node(leftData);
			node.right = rightData == '.' ? null : new Node(rightData);
		} else {
			searchNode(node.left, data, leftData, rightData);
			searchNode(node.right, data, leftData, rightData);
		}
	}
	
	public void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data);
			if (node.left != null) {
				preOrder(node.left);
			}
			if (node.right != null) {
				preOrder(node.right);
			}
		}
	}
	
	public void inOrder(Node node) {
		if (node != null) {
			if (node.left != null) {
				inOrder(node.left);
			}
			System.out.print(node.data);
			if (node.right != null) {
				inOrder(node.right);
			}
		}
	}
	
	public void postOrder(Node node) {
		if (node != null) {
			if (node.left != null) {
				postOrder(node.left);
			}
			if (node.right != null) {
				postOrder(node.right);
			}
			System.out.print(node.data);
		}
	}
}
public class number_1991 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Tree t = new Tree();
		StringTokenizer st;
		while(N --> 0) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			t.createNode(root, left, right);
		}
		t.preOrder(t.root);
		System.out.println();
		t.inOrder(t.root);
		System.out.println();
		t.postOrder(t.root);

	}

}
