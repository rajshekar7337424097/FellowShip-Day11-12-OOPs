package com.bl.stock_account_management;

public class StockReport {
	MyLinkedList<Stock> list;
	StockDataAndPrintReport stockDataAndPrintReport = new StockDataAndPrintReport();
	
	public static void main(String[] args) {
		StockDataAndPrintReport.getStackData();
		StockDataAndPrintReport.printReport();
		
	}

}
