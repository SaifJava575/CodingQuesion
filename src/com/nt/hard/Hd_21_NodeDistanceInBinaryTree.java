package com.nt.hard;

import java.util.ArrayList;
import java.util.Collections;

public class Hd_21_NodeDistanceInBinaryTree {

	// T(C)=O(n*logn) and S(c)=O(H) H=height of the tree
	public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {

		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<Node> list = ntrp(root, target);

		if (list.size() == 0)
			return ans;

		kdis(list.get(0), null, k, ans);
		for (int i = 1; i <= k && i < list.size(); i++) {
			kdis(list.get(i), list.get(i - 1), k - i, ans);
		}
		Collections.sort(ans);
		return ans;
	}

	public static void kdis(Node root, Node blocker, int k, ArrayList<Integer> ans) {
		if (k < 0 || root == null || root == blocker)
			return;

		if (k == 0) {
			// reached
			ans.add(root.data);
			return;
		}

		kdis(root.left, blocker, k - 1, ans);
		kdis(root.right, blocker, k - 1, ans);
	}

	public static ArrayList<Node> ntrp(Node root, int tar) {
		if (root == null)
			return new ArrayList<>();

		if (root.data == tar) {
			ArrayList<Node> ans = new ArrayList<>();
			ans.add(root);
			return ans;
		}

		ArrayList<Node> l = ntrp(root.left, tar);
		if (l.size() > 0) {
			l.add(root);
			return l;
		}

		ArrayList<Node> r = ntrp(root.right, tar);
		if (r.size() > 0) {
			r.add(root);
			return r;
		}

		return new ArrayList<>();

	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		ArrayList<Integer> response = KDistanceNodes(root, 8, 2);
		System.out.println("The Target Node is ::" + response);

	}

}
