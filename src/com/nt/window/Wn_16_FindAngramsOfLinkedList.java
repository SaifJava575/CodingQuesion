package com.nt.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Node {
	char data;
	Node next;

	Node(char x) {
		data = x;
		next = null;
	}
}

public class Wn_16_FindAngramsOfLinkedList {

	//T(c)=O(N)  and S(n)
	public static ArrayList<Node> findAnagrams(Node head, String s) {
		ArrayList<Node> ans = new ArrayList<>();

		Node prev = null;

		HashMap<Character, Integer> smp = new HashMap<>();
		HashMap<Character, Integer> cmp = new HashMap<>();

		Node curr = head;
		int n = s.length();

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			smp.put(c, smp.getOrDefault(c, 0) + 1);
		}

		while (curr != null) {
			Node temp = curr;
			for (int i = 0; i < n && temp != null; i++) {
				char c = temp.data;
				cmp.put(c, cmp.getOrDefault(c, 0) + 1);
				prev = temp;
				temp = temp.next;
			}
			if (anagram(smp, cmp)) {
				prev.next = null;
				ans.add(curr);
				curr = temp;
			} else {
				curr = curr.next;
			}
			cmp.clear();
		}
		return ans;
	}

	static boolean anagram(HashMap<Character, Integer> smp, HashMap<Character, Integer> cmp) {
		if (smp.size() != cmp.size())
			return false;
		for (Map.Entry<Character, Integer> entry : smp.entrySet()) {
			char key = entry.getKey();
			int value = entry.getValue();

			if (!cmp.containsKey(key) || cmp.get(key) != value) {
				return false;
			}
		}

		return true;
	}

	static void PrintList(Node head) {
		Node curr = head;
		for (; curr != null; curr = curr.next)
			System.out.print(curr.data + "->");
		System.out.println("null");
	}

	static void PrintList1(ArrayList<Node> head) {
		ArrayList<Node> curr = head;

		for (Node val : curr) {
			System.out.println(val.data + "->");
			val = val.next;
		}

	}

	static Node InsertatFirst(char value, Node head) {
		// Step1 : creating a new Node with the given val
		Node newnode = new Node(value);
		// Step2 : Making next of newly created Node to point the head of LinkedList
		newnode.next = head;
		// Making the newly created Node as head
		head = newnode;
		return head;
	}

	public static void main(String[] args) {
		// a -> b -> c -> a -> d -> b -> c -> a
		Node head = null; // head of the LinkedList
		head = InsertatFirst('a', head);
		head = InsertatFirst('b', head);
		head = InsertatFirst('c', head);
		head = InsertatFirst('a', head);
		head = InsertatFirst('d', head);
		head = InsertatFirst('b', head);
		head = InsertatFirst('c', head);
		head = InsertatFirst('a', head);
		PrintList(head);
		ArrayList<Node> res = findAnagrams(head, "bac");
		PrintList1(res);
	}

}
