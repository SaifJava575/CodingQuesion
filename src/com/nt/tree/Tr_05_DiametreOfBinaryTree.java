package com.nt.tree;

public class Tr_05_DiametreOfBinaryTree {

	public static int diameter(Node root) {
		 if(root == null) return 0;	        
	        int left = diameter(root.left);
	        int right = diameter(root.right);	        
	        int dia = height(root.left) + height(root.right) + 1;	        
	        return Math.max(dia,Math.max(left,right));
	}

	static int height(Node root){
        if(root == null) return 0;    
        return Math.max(height(root.left),height(root.right)) + 1;
    }

	public static void main(String[] args) {
		Node root=new Node(4);
		root.left=new Node(7);
		root.right=new Node(8);
		
		root.right.left=new Node(1);
		root.right.right=new Node(0);
		
		root.right.left.left=new Node(3);
		
		int response=diameter(root);
		System.out.println("Diametre of the binary tree is ::"+response);


		


	}

}
