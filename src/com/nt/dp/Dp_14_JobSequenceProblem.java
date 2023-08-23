package com.nt.dp;

import java.util.Arrays;

class Job{
	
	int id,deadline,profit;

	public Job(int id, int deadline, int profit) {
		super();
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
    
}
public class Dp_14_JobSequenceProblem {
	
	public static int[] JobScheduling(Job arr[], int n) {
	  //sort the Profit
		 Arrays.sort(arr,(a,b)->b.profit-a.profit);
		 
	  //find max deadline 
		 int max=0;
		 for(int i=0;i<n;i++) {
			 if(arr[i].deadline>max)
				 max=arr[i].deadline;
		 }
		 int result[]=new int[n+1];
		 for(int i=1;i<=max;i++)
			 result[i]=-1;
		 
		 //find free slot
		 int countJobs=0,maxProfit=0;
		 for(int i=0;i<n;i++) 
			 for(int j=arr[i].deadline;j>0;j--)
				 if(result[j]==-1) {
					 result[j]=i;
					 countJobs++;
					 maxProfit+=arr[i].profit;
				 }
		int ans[]=new int[2];
		ans[0]=countJobs;
		ans[1]=maxProfit;
		return ans;	 
	 }

	public static void main(String[] args) {
		Job job1=new Job(1,2,20);
		Job job2=new Job(2,1,10);
		Job job3=new Job(3,1,40);
		Job job4=new Job(4,1,30);
		
		Job arr[]={job1,job2,job3,job4};
		int n=arr.length;
		int response[]=JobScheduling(arr, n);
		System.out.println("The count job is "+response[0]);
		System.out.println("The max profit is "+response[1]);




	}

}
