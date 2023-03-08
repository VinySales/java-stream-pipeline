package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee("Maria","maria@gmail.com",3200.00));
		list.add(new Employee("Alex","alex@gmail.com",1900.00));
		list.add(new Employee("Marco","marco@gmail.com",1700.00));
		list.add(new Employee("Bob","bob@gmail.com",3500.00));
		list.add(new Employee("Anna","anna@gmail.com",2800.00));
		
		System.out.print("Insira um valor: ");
		Double value = scan.nextDouble();
		
		System.out.println();
		
		System.out.println("Empregados com o salário acima do informado:");
		
		List<String> names = list.stream()
				.filter(a -> a.getSalary() > value)
				.map(a -> a.getName())
				.sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
				.collect(Collectors.toList());
				
		names.forEach(System.out::println);
		
		System.out.println();
		
		Double sum = list.stream()
				.filter(a -> a.getName().charAt(0) == 'M')
				.map(a -> a.getSalary())
				.reduce(0.0, (x, y) -> x + y);
		
		System.out.print("Soma dos salários de empregados que começam com 'M': " + sum);
		
	}
	
}
