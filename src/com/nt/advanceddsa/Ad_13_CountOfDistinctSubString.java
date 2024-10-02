package com.nt.advanceddsa;

public class Ad_13_CountOfDistinctSubString {
	static class Node {
		Node children[];
		public Node() {
			children = new Node[26];
		}

	}

	public static int countDistinctSubstring(String st) {
		 if(st.length()==0){
	           return 0;
	       }
	      int c=1;
	      Node root=new Node();
	      for(int i=0;i<st.length();i++){
	          Node curr=root;
	          for(int j=i;j<st.length();j++){
	              int index =st.charAt(j)-'a';
	              Node child=curr.children[index];
	              if(child==null){
	                 c++;
	                 curr.children[index]=new Node();
	              }
	              curr=curr.children[index];
	          }
	      }
	      
	      return  c;
	}

	public static void main(String[] args) {
		String str = "ababa";
		int response = countDistinctSubstring(str);
		System.out.println(":Distinct Substring is :" + response);
	}

}
