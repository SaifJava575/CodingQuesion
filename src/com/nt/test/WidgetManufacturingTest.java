package com.nt.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WidgetManufacturingTest {
	
	 public static int calculateMaxOrders(int productionCapacity, Map<String, Integer> customerOrders) {
	        int totalDemand = 0;
	        for (int quantity : customerOrders.values()) {
	            totalDemand += quantity;
	        }

	        if (totalDemand <= productionCapacity) {
	            return customerOrders.size();
	        }

	        List<Map.Entry<String, Integer>> sortedOrders = new ArrayList<>(customerOrders.entrySet());
	        sortedOrders.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

	        int fulfilledOrders = 0;
	        int remainingCapacity = productionCapacity;

	        for (Map.Entry<String, Integer> entry : sortedOrders) {
	            int quantity = entry.getValue();
	            if (quantity <= remainingCapacity) {
	                fulfilledOrders++;
	                remainingCapacity -= quantity;
	            } else {
	                break;
	            }
	        }

	        return fulfilledOrders;
	    }

	    // Example usage
	    public static void main(String[] args) {
	        int productionCapacity = 100;
	        Map<String, Integer> customerOrders = new HashMap<>();
	        customerOrders.put("Customer1", 30);
	        customerOrders.put("Customer2", 50);
	        customerOrders.put("Customer3", 20);
	        customerOrders.put("Customer4", 40);

	        int maxOrders = calculateMaxOrders(productionCapacity, customerOrders);
	        System.out.println("The maximum number of orders the manufacturer can fulfill in full is: " + maxOrders);
	    }


}
