package com.nt.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Tr_11_BottomViewOfBinaryTree {

	//T(C)=O(N*logN).  and S(c)=O(n)
	public static ArrayList<Integer> bottomView(Node root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		Queue<Pair> q = new LinkedList<Pair>();
		Map<Integer, Integer> map = new TreeMap<>();
		q.add(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair it = q.poll();
			Node temp = it.node;
			int hd = it.level;
			//if (map.get(hd) == null)
			map.put(hd, temp.data);
			if (temp.left != null)
				q.add(new Pair(temp.left, hd - 1));
			if (temp.right != null)
				q.add(new Pair(temp.right, hd + 1));
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			ans.add(entry.getValue());
		return ans;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		ArrayList<Integer> response=bottomView(root);
		System.out.println("The bottom view of the Binary Tree is ::"+response);

	}

}
