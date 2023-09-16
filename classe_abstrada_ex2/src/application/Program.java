package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number if tax payers: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + "data: ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual Income: ");
			double income = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, income, healthExpenditures));
			}
			else {
				System.out.print("Number of employees: ");
				int employees = sc.nextInt();
				list.add(new Company(name, income, employees));				
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		
		for (TaxPayer taxes : list) {
			System.out.println(taxes.getName() + ": $ " + String.format("%.2f", taxes.tax()));
		}
		
		System.out.println();
		
		double total = 0;
		
		for (TaxPayer taxes : list) {
			total += taxes.tax();		
		}
		
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", total));
				
		
		sc.close();

	}

}
