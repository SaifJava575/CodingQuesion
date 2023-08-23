package com.nt.test;

import java.util.ArrayList;
import java.util.List;

public class WidgetManufacturer {

	public static int calculateMaxFulfilledOrders(int availableWidgets, List<Integer> customerOrders) {
		int toalDemand = 0;
		for (int quantity : customerOrders)
			toalDemand += quantity;
		if (toalDemand <= availableWidgets)
			return customerOrders.size();

		int maxFulfilledOrders = 0;
		for (int order : customerOrders) {
			if (order <= availableWidgets) {
				maxFulfilledOrders++;
				availableWidgets -= order;
			} else {
				break; // Stop processing orders if there are not enough widgets available
			}
		}
		return maxFulfilledOrders;
	}

	public static void main(String[] args) {
		int availableWidgets = 20; // Number of widgets available
		List<Integer> customerOrders = new ArrayList<>();
		customerOrders.add(5); // Customer 1 order
		customerOrders.add(5); // Customer 2 order
		customerOrders.add(8); // Customer 3 order

		int maxFulfilledOrders = calculateMaxFulfilledOrders(availableWidgets, customerOrders);
		System.out.println("Maximum number of orders fulfilled: " + maxFulfilledOrders);
	}

}
