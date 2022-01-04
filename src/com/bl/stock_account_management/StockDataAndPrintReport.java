package com.bl.stock_account_management;

import java.io.BufferedReader;
import java.util.Scanner;

public class StockDataAndPrintReport {
	static MyLinkedList<Stock> list;
	
	
	public static void getStackData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Stocks :");
		int count = sc.nextInt();
		list = new MyLinkedList<Stock>();
		
		for (int i = 0; i < count; i++) {
			System.out.println("Enter stock name, number of shares and share price :");
			String name = sc.next();
			int numberOfShares = sc.nextInt();
			int price = sc.nextInt();
			Stock stock = new Stock(name, numberOfShares, price);
			list.add(stock);	
		}
		sc.close();
	}
	
	public static void printReport() {
		int totalValue = 0;
		System.out.println("\nName\nShares\nPrice\nValues");
		while(!list.isEmpty()) {
			Stock folio = list.pop(0);
			totalValue += folio.getValue();
			System.out.println(folio.getValue() + "\t"
			+ folio.getNumberOfShares() + "\t" + folio.getPrice()+
			" \t" + folio.getValue());
			
		}
		System.out.println("\nTotal value is :"+totalValue);
	}
BufferedReader bufferedReader = null;
}
