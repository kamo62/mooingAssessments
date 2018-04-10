package com.kamo.assignments;

import com.kamo.util.EasyIn;

public class Ass1
{
	static boolean check(String str)
	{
		if (str.length() == 0)
			return false;
		try
			{
				return ((Integer.parseInt(str)) % 8 == 0);
			} catch (Exception e)
			{
				return false;
			}
	}
	
	public static void main(String[] args)
	{
		EasyIn input = new EasyIn();
		System.out.println("Please input the number you would like to check.");
		if (check(input.readString()))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
