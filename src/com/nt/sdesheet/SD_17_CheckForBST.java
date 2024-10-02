package com.nt.sdesheet;

import java.util.ArrayList;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}

}

public class SD_17_CheckForBST {

	static boolean isBST(Node root) {
		ArrayList<Integer> arr=new ArrayList<>();
		inroder(root, arr);
		for(int i=1;i<arr.size();i++)
			if(arr.get(i-1)>=arr.get(i))
				return false;
		return true;
	}

	public static void inroder(Node root, ArrayList<Integer> arr) {
     if(root==null)
    	 return;
     inroder(root.left, arr);
     arr.add(root.data);
     inroder(root.right, arr);
	}

	public static void main(String[] args) {

		Node head=new Node(2);
		head.left=new Node(1);
		head.right=new Node(3);
		if(isBST(head))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
