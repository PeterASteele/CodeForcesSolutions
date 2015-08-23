import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * B. Order Book
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
In this task you need to process a set of stock exchange orders and use them to create order book.

An order is an instruction of some participant to buy or sell stocks on stock exchange. The order number i has price pi, direction di — buy or sell, and integer qi. This means that the participant is ready to buy or sell qi stocks at price pi for one stock. A value qi is also known as a volume of an order.

All orders with the same price p and direction d are merged into one aggregated order with price p and direction d. The volume of such order is a sum of volumes of the initial orders.

An order book is a list of aggregated orders, the first part of which contains sell orders sorted by price in descending order, the second contains buy orders also sorted by price in descending order.

An order book of depth s contains s best aggregated orders for each direction. A buy order is better if it has higher price and a sell order is better if it has lower price. If there are less than s aggregated orders for some direction then all of them will be in the final order book.

You are given n stock exhange orders. Your task is to print order book of depth s for these orders.

Input
The input starts with two positive integers n and s (1 ≤ n ≤ 1000, 1 ≤ s ≤ 50), the number of orders and the book depth.

Next n lines contains a letter di (either 'B' or 'S'), an integer pi (0 ≤ pi ≤ 10^5) and an integer qi (1 ≤ qi ≤ 10^4) — direction, price and volume respectively. The letter 'B' means buy, 'S' means sell. The price of any sell order is higher than the price of any buy order.

Output
Print no more than 2s lines with aggregated orders from order book of depth s. The output format for orders should be the same as in input.
 */
public class OrderBook {

	public static void main(String[] args) {
		// Input
		Scanner input = new Scanner(System.in);
		int numberOfOrders = input.nextInt();
		int bookDepth = input.nextInt();
		input.nextLine();
		String[] ordersDirection = new String[numberOfOrders];
		int[] priceArray = new int[numberOfOrders];
		int[] volumeArray = new int[numberOfOrders];
		for(int a = 0; a < numberOfOrders; a++){
			ordersDirection[a] = input.next();
			priceArray[a] = input.nextInt();
			volumeArray[a] = input.nextInt();
			input.nextLine();
		}		
		// make the book
		int[] buyArray = new int[100002];
		int[] sellArray = new int[100002];
		for(int a = 0; a < numberOfOrders; a++){
			if(ordersDirection[a].charAt(0) == 'B'){
				buyArray[priceArray[a]] += volumeArray[a];
			}
			else{
				sellArray[priceArray[a]] += volumeArray[a];
			}
		}
		//we have a complete book; now to print
		//print sales
		int countS = 0;
		int indexS = 0;
		int tempIndexS = -1;
		while(countS < bookDepth && indexS <= 100001){
			if(sellArray[indexS] != 0){
				countS++;
			}
			indexS++;
		}
		if(indexS != 0){
			indexS--;
		}
		
		//we found the lowest one to print.
		
		while(indexS >= 0){
			if(sellArray[indexS] != 0){
				System.out.println("S " + indexS + " " + sellArray[indexS]);
			}
			indexS--;
		}
		
		
		//print buys		
		int count = 0;
		int index = 100001;
		int tempIndex = -1;
		while(count < bookDepth && index >= 0){
			if(buyArray[index] != 0){
				count++;
			}
			index--;
		}
		if(index != 100001){
			index++;
		}
		tempIndex = index;
		index = 100001;
		//we found the lowest one to print.
		while(tempIndex <= index){
			if(buyArray[index] != 0){
				System.out.println("B " + index + " " + buyArray[index]);
			}
			index--;
		}		
		
	}
}
