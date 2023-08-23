package com.nt.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tr_02_LeftViewOfTree {

	//T(c)=O(N). and S(C)=O(n)
	public static ArrayList<Integer> leftView(Node root) {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		if (root == null)
			return ans;
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				if (q.peek().left != null)
					q.add(q.peek().left);
				if (q.peek().right != null)
					q.add(q.peek().right);
				if (i == 0)
					ans.add(q.poll().data);
				else
					q.poll();
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Node root=new Node(10);
		
		root.left=new Node(20);
		root.right=new Node(30);
		
		root.left.left=new Node(50);
		root.left.right=new Node(60);
		
		root.left.right.left=new Node(70);
		root.left.right.right=new Node(80);
		
		ArrayList<Integer> response=leftView(root);
		System.out.println("The left view of the Tree is:"+response);
		

	}

}
