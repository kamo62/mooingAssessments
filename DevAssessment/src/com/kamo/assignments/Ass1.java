package com.kamo;

import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class Ass1
{
	static boolean check(String str)
	{
		int numValue = 0;
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
