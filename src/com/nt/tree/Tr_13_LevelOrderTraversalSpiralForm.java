package com.nt.tree;

import java.util.ArrayList;
import java.util.Stack;

public class Tr_13_LevelOrderTraversalSpiralForm {

	// T(c)=O(n) and S(C)=O(n)
	public static ArrayList<Integer> findSpiral(Node root) {
		 ArrayList<Integer> temp = new ArrayList<Integer>();
	        if(root == null)
	            return temp;
	        Stack<Node> S1 = new Stack<>();
	        Stack<Node> S2 = new Stack<>();
	        S1.push(root);
	        while(!S1.isEmpty() || !S2.isEmpty()){
	            
	            while(!S1.isEmpty()){
	                Node out = S1.pop();
	                temp.add(out.data);
	                if (out.right!= null)
	                    S2.push(out.right);   
	                
	               if (out.left!= null)
	                    S2.push(out.left);   
	                
	            }
	            while(!S2.isEmpty()){
	                Node out = S2.pop();
	                temp.add(out.data);
	                if (out.left!= null)
	                    S1.push(out.left);  
	                 if (out.right!= null)
	                    S1.push(out.right);                   
	            }
	            
	        }
	        return temp;
	}

	public static void main(String[] args) {
     Node root=new Node(1);
     root.left=new Node(2);
     root.right=new Node(3);
     
     root.left.left=new Node(4);
     root.left.right=new Node(5);
     
     root.right.left=new Node(6);
     root.right.right=new Node(7);
     
     ArrayList<Integer> arr=findSpiral(root);
     System.out.println("The Spiral Node is :"+arr);
	}

}
