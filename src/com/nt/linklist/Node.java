package com.nt.linklist;

public class Node {
	int data;
	Node next;

	public Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	} 
	
	public Node(int data) {
		this.data = data;
	}
	
	public static void frontoftheLinkList(Node head, int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}

	public void append(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = new Node(data);
			return;
		}
		newNode.next = null;
		Node last = head;
		while (last.next != null)
			last = last.next;
		last = newNode;
		return;

	}

	public static void printData(Node node) {
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		Node head=null;
		frontoftheLinkList(head, 1);
		frontoftheLinkList(head, 2);
		frontoftheLinkList(head, 3);
		frontoftheLinkList(head, 4);
        printData(head);


		
	}

}
