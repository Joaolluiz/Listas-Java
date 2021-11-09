package application;

import java.util.Scanner;
import java.util.Locale;
import entities.employer;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<employer> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int N = sc.nextInt();

		System.out.println();

		for (int i = 0; i < N; i++) {
			sc.nextLine();
			System.out.println("Employee #" + (i + 1) + ": ");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while(hasId(list,id)) {
				System.out.print("Id already taken!Try again: ");
				id = sc.nextInt();
			}
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			System.out.println(" ");

			employer emp = new employer(id, name, salary);

			list.add(emp);

		}

		System.out.print("Enter the employee id that will have salary increase: ");
		int increaseId = sc.nextInt();
		
		employer emp = list.stream().filter(x -> x.getId() == increaseId).findFirst().orElse(null);
		
		//Integer find = findId(list, increaseId);
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}
		System.out.println();
		System.out.println("List of employees: ");
		for (employer e : list) {
			System.out.println(e);
		}

		sc.close();
	}
	
	//método alternativo para achar um ID.
	/*
	public static Integer findId(List<employer> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	*/
	//função para validar se o id do funcionário existe na lista.
	public static boolean hasId(List<employer> list,int id) {
		employer emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
