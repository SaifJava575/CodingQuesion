package com.nt.string;

import java.util.Stack;

public class St_17_LongestValidSubString {
	
	//T(c)=O(N)   and S(C)=O(n)
	public static int findMaxLen(String S) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int res=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                st.push(i);
            }else{
                st.pop();
                if(st.empty())
                    st.push(i);
                else
                    res = Math.max(res, i-st.peek());
            }
        }
        return res;
    }
	
	

	public static void main(String[] args) {
		
      String str="()(())";
      int res=findMaxLen(str);
      System.out.println("Maximum Valid SubString length is ::"+res);
	}

}
