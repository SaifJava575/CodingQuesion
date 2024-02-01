package com.nt.hard;

public class Hd_43_AVLTree
{
	
	//T(C)=O(log N)  and S(C)= O(height of tree)
	static class Node
	{
	    int data;
	    Node left;
	    Node right;
	    int height;
	    
	    public Node(int data) {
			this.data=data;
		}
	};
    public static int height(Node node){
        if(node==null)
            return 0;
        return Math.max(height(node.left),height(node.right))+1;
    }
    
    public static int balance(Node node){
        if(node==null)
            return 0;
        return height(node.left)-height(node.right);
    }
    
    public static Node leftRotate(Node node){
        Node a=node.right;
        Node b=a.left;
        
        a.left=node;
        node.right=b;
        return a;
    }
    public static Node rightRotate(Node node){
        Node a=node.left;
        Node b=a.right;
        
        a.right=node;
        node.left=b;
        
        return a;
    }
    public static Node insert(Node node,int data){
        if(node==null)
            return new Node(data);
        
        
        if(data<node.data)
            node.left=insert(node.left,data);
        else if(data>node.data)
            node.right=insert(node.right,data);
        else
            return node;  
        node.height=height(node);
       
        int bal=balance(node);
        
        if(bal>1 && data<node.left.data)
            return rightRotate(node);
        
        if(bal<-1 && data>node.right.data)
            return leftRotate(node);
        
        if(bal>1 && data>node.left.data){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        if(bal<-1 && data<node.right.data){
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
        
        
    }
    public  void inOrder(Node node){
        if(node==null)
            return;
        
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    public Node insertToAVL(Node node,int data)
    {
        Node ans=insert(node,data);
        inOrder(ans);
        return ans;
    }
    
    public static void main(String[] args) {
    	Hd_43_AVLTree tree = new Hd_43_AVLTree();
         Node root = null;
         int[] values = { 21,26,30,9,4,14,28 };
         for (int value : values) {
             root = tree.insertToAVL(root, value);
             System.out.println();
         }
	}
}    