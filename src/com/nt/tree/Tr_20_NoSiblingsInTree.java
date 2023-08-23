package com.nt.tree;

import java.util.ArrayList;
import java.util.Collections;

public class Tr_20_NoSiblingsInTree {

	public static ArrayList<Integer> noSibling(Node node) {
		ArrayList<Integer> ans = new ArrayList<>();
		solve(node, ans);
		if (ans.size() == 0) {
			ans.add(-1);
			return ans;
		}
		Collections.sort(ans);
		return ans;
	}

	public static Node solve(Node node, ArrayList<Integer> ans) {
		if (node == null)
			return null;
		Node left = solve(node.left, ans);
		Node right = solve(node.right, ans);
		if (left != null && right == null)
			ans.add(left.data);
		if (left == null && right != null)
			ans.add(right.data);
		return node;

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(3);
		
		ArrayList<Integer> arr=noSibling(root);
		System.out.println("Print Sibling node of the tree ::"+arr);
	}

}
