package com.nt.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ST_02_NumberStartingWithOne {
	
	public static void startWith1String() {
		System.out.println("Start with 1 Function::");
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
		 myList.stream().map(s->s+" ").filter(s->s.startsWith("1")).forEach(System.out::println);
	}
	
	public static void findDuplicateElement() {
		System.out.println("Find Duplicate Element");
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        @SuppressWarnings({ "unchecked", "rawtypes" })
		Set<Integer> set = new HashSet();
        myList.stream().filter(n->!set.add(n)).forEach(System.out::println);
	}
	
	public static void findFirstElementOfheList() {
		System.out.println("Find First element of the List:");
		 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		 myList.stream().findFirst().ifPresent(System.out::println);
	}
	
	public static void totalNumberOfElementOfTheList() {
		System.out.println("total element of the List:");
		 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);	
		 System.out.println(myList.stream().count());
	}
	
	public static void maxvalueInTheList() {
		System.out.println("Max value of the String :");
		 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);	
		 Integer maxValue=myList.stream().max(Integer::compare).get();
		 System.out.println(maxValue);
	}
	
	public static void sortTheValueOfTheListASC() {
		System.out.println("sortTheValueOfTheListASC :");
		 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);	
		 myList.stream().sorted().forEach(System.out::println);
	}
	
	public static void sortTheValueOfTheListDSC() {
		System.out.println("sortTheValueOfTheListDSC :");
		 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);	
		 myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
	}

	public static void cubeOnTheListGreaterThan50() {
		System.out.println("cubeOnTheListGreaterThan50 :");
	       List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
	       integerList.stream().map(i->i*i*i).filter(i->i>50).forEach(System.out::println);
	}
	
	public static void findCountOfChars() {
		System.out.println("Count of the Each Charcater is ::");
		String s="Saifuddin";
		Map<String, Long> map = Arrays.stream(s.split(""))
		                              .map(String::toLowerCase)
		                              .collect(Collectors
		                              .groupingBy(str -> str, 
		                                LinkedHashMap::new, Collectors.counting()));
		System.out.println(map);
		}

	public static void main(String[] args) {
		startWith1String();
		findDuplicateElement();
		findFirstElementOfheList();
		totalNumberOfElementOfTheList();
		maxvalueInTheList();
		sortTheValueOfTheListASC();
		sortTheValueOfTheListDSC();
		cubeOnTheListGreaterThan50();
		findCountOfChars();
		
		//https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
	}

}
