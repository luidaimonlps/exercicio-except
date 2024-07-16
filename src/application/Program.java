package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithdrawExcept;

public class Program {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
			System.out.println("***Enter account data*** ");
			System.out.print("Number account: ");
			int number = scan.nextInt();
			System.out.print("Holder name: ");
			scan.nextLine();
			String holder = scan.nextLine();
			System.out.print("Initial balance: R$ ");
			double intialBalance = scan.nextDouble();
			System.out.print("Withdraw limit: R$ ");
			double withdrawLimit = scan.nextDouble();
			
			Account acc = new Account(number, holder, intialBalance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: R$ ");
			double amount = scan.nextDouble();
			try {
				acc.withdraw(amount);
				System.out.print("New Balance: " + String.format("%.2f", acc.getBalance()));
			}
			catch (WithdrawExcept e) {
				System.out.println(e.getMessage());
			}
		
		scan.close();

	}

}
