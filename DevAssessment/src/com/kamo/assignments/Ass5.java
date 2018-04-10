package com.kamo.assignments;

import java.text.NumberFormat;
import java.util.ArrayList;

import com.kamo.util.EasyIn;

public class Ass5
{
	static class item
	{
		private double price;
		private String name;
		
		public item(double price, String name)
		{
			this.price = price;
			this.name = name;
		}
		
		public item()
		{
			
		}
		
		public double getPrice()
		{
			return price;
		}
		
		public void setPrice(double price)
		{
			this.price = price;
		}
		
		public String getName()
		{
			return name;
		}
		
		public void setName(String name)
		{
			this.name = name;
		}
		
		public String toString()
		{
			return "Item :" + name + "   Price: " + NumberFormat.getCurrencyInstance().format(price);
		}
		
		public String selectionOutput()
		{
			return "You've selected " + name + " which is " + NumberFormat.getCurrencyInstance().format(price);
		}
		
	}
	
	public static void main(String... args)
	{
		item selectedItem = null;
		
		EasyIn input = new EasyIn();
		
		ArrayList<item> vendingItems = new ArrayList<item>();
		vendingItems.add(new item(5.50, "Chips"));
		vendingItems.add(new item(12.00, "Coke"));
		vendingItems.add(new item(21, "Redbull"));
		vendingItems.add(new item(9, "Chocolate"));
		
		for (int i = 0; i < vendingItems.size(); i++)
			{
				System.out.println(i + ": " + vendingItems.get(i).toString());
			}
		int item = 0;
		
		System.out.print("Enter an item number: ");
		item = input.readInt();
		if (!(item <= vendingItems.size()))
			{
				System.out.println("Sorry, we don't have that item in stock.");
				return;
			} else
			{
				selectedItem = vendingItems.get(item);
			}
			
		System.out.print("Enter the amount paid: ");
		double paid = input.readDouble();
		
		while (paid < (selectedItem.getPrice()))
			{
				System.out.print("You need "
						+ NumberFormat.getCurrencyInstance().format(Math.abs((paid - selectedItem.getPrice())))
						+ " more for item " + item);
				paid += input.readDouble();
			}
		System.out.println("Thank you for buying item " + item + ", your change is "
				+ NumberFormat.getCurrencyInstance().format((paid - selectedItem.getPrice())) + ". Please come again!");
		
	}
}
