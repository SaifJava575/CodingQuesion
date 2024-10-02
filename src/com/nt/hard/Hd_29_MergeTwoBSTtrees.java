package com.nt.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hd_29_MergeTwoBSTtrees {

	public static List<Integer> merge(Node root1, Node root2) {
		List<Integer> t1 = new ArrayList<>();
		inorder(root1, t1);
		inorder(root2, t1);
		Collections.sort(t1);
		return t1;
	}

	public static void inorder(Node r, List<Integer> l) {
		if (r == null)
			return;
		inorder(r.left, l);
		l.add(r.data);
		inorder(r.right, l);
		return;
	}

	public static void main(String[] args) {
		Node root1 = new Node(5);
		root1.left = new Node(3);
		root1.right = new Node(6);
		root1.left.left = new Node(2);
		root1.left.right = new Node(4);

		Node root2 = new Node(2);
		root2.left = new Node(1);
		root2.right = new Node(3);
		root2.right.left = new Node(7);
		root2.right.left.left = new Node(6);

		List<Integer> response = merge(root1, root2);
		System.out.println("Two BST after merge the tree " + response);

	}

}
