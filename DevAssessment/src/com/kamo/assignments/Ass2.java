package com.kamo.assignments;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.kamo.util.EasyIn;

public class Ass2
{
	static class Order implements Comparable<Order>
	{
		int Ai, Bi;
		
		Order()
		{
			Ai = 0;
			Bi = 0;
		}
		
		public int compareTo(Order a)
		{
			return Math.abs(a.Ai - a.Bi) - Math.abs(this.Ai - this.Bi);
		}
		
		void setTipb(int b)
		{
			Bi = b;
		}
		
		void setTipa(int a)
		{
			Ai = a;
		}
		
		public String toString()
		{
			return "(" + Ai + ", " + Bi + " )";
		}
	}
	
	static int getMaxTip(Order orders[], int x, int y)
	{
		Arrays.sort(orders);
		int tip = 0;
		
		for (Order o : orders)
			{
				if (o.Ai > o.Bi)
					{
						if (x > 0)
							{
								tip += o.Ai;
								x--;
							} else
							{
								tip += o.Bi;
								y--;
							}
					} else
					{
						if (y > 0)
							{
								tip += o.Bi;
								y--;
							} else
							{
								tip += o.Bi;
								x--;
							}
					}
			}
			
		return tip;
	}
	
	public static void main(String[] args) throws IOException
	{
		int t = new EasyIn().readInt();
		ArrayList<Integer> results = new ArrayList<Integer>();
		while (t-- > 0)
			{
				String arr[] = EasyIn.br.readLine().split(" ");
				
				int n = Integer.parseInt(arr[0]);
				int x = Integer.parseInt(arr[1]);
				int y = Integer.parseInt(arr[2]);
				
				Order orders[] = new Order[n];
				
				for (int i = 0; i < n; i++)
					orders[i] = new Order();
				
				arr = EasyIn.br.readLine().split(" ");
				for (int i = 0; i < n; i++)
					orders[i].setTipa(Integer.parseInt(arr[i]));
				
				arr = EasyIn.br.readLine().split(" ");
				for (int i = 0; i < n; i++)
					orders[i].setTipb(Integer.parseInt(arr[i]));
				
				int result = getMaxTip(orders, x, y);
				
				results.add(result);
			}
		System.out.println("==============Results==============");
		for (Integer item : results)
			{
				System.out.println(item);
			}
		try
			{
				EasyIn.br.close();
			} catch (Exception e)
			{
				return;
			}
	}
}
