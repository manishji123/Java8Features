/**
 * 
 */
package com.examples.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author manish goel
 *
 */
public class StreamGroupByExample {

	/*
	Name     | City       | Number of Sales |
	+----------+------------+-----------------+
	| Alice    | London     | 200             |
	| Bob      | London     | 150             |
	| Charles  | New York   | 160             |
	| Dorothy  | Hong Kong  | 190  
	
	*/
	
	public static List<Employee> employees= new ArrayList<Employee>();
	
	static {
		employees.add(new Employee("Alice", "London", 200));
		employees.add(new Employee("Bob", "London", 150));
		employees.add(new Employee("Charles", "New York", 160));
		employees.add(new Employee("Dorothy", "Hong Kong", 190));
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(employees);
		
		System.out.println("--------------");

		System.out.println(getEmployeesByCity(employees));

		System.out.println(getEmployeesByCityWithStream(employees));
		
		
		System.out.println(getEmployeesPartitionedBy(employees, 150));
		
		System.out.println(getEmployeesCountPartitionedBy(employees, 150));

		
	}
	
	public static Map<String, List<Employee>> getEmployeesByCityWithStream(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getCity));
	}
	
	
	public static Map<Boolean, List<Employee>> getEmployeesPartitionedBy(List<Employee> employees, int partition) {
		return employees.stream().collect(Collectors.partitioningBy(e->e.getNumOfSale()>partition));
	}
	
	public static Map<Boolean, Map<String, Long>> getEmployeesCountPartitionedBy(List<Employee> employees, int partition) {
		return employees.stream().collect(Collectors.partitioningBy(e->e.getNumOfSale()>partition, 
				Collectors.groupingBy(Employee::getCity, Collectors.counting())));
	}

	

	
	public static Map<String, List<Employee>> getEmployeesByCity(List<Employee> employees) {
		Map<String, List<Employee>> result = new HashMap<>();
		for (Employee e : employees) {
		  String city = e.getCity();
		  List<Employee> empsInCity = result.get(city);
		  if (empsInCity == null) {
		    empsInCity = new ArrayList<>();
		    result.put(city, empsInCity);
		  }
		  empsInCity.add(e);
		}
		
		return result;
	}
	
	
	

}
