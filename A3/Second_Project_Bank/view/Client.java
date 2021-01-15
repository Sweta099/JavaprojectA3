package com.capgemini.view;

import java.util.Scanner;

import com.capgemini.service.ICICIBank;
import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;

public class Client {
	public static void main(String[] args) {
		ICICIBank bank = new ICICIBank();
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("MENU");
		System.out.println("1. Create Account");
		System.out.println("2. Deposit Amount");
		System.out.println("3. Withdraw Amount");
		System.out.println("4. Validate Account");
		System.out.println("5. Fund Transfer");
		System.out.println("6. Exit");
		System.out.println(" Enter the choice");
		int choice= sc.nextInt();
		
		switch(choice) {
		case 1: try {
				System.out.println("Enter Account number");
				int accountNumber = sc.nextInt();
				System.out.println("Enter Amount ");
				int amount = sc.nextInt();
				System.out.println(bank.createAccount(accountNumber, amount));
				}
				catch(InsufficientOpeningAmountException ioae) {
					System.out.println(ioae.getMessage()); 
				}
				break;
				
		case 2:	System.out.println("Enter the account number ");
				int accountNumber = sc.nextInt();
				System.out.println("Enter the amount");
				int amount = sc.nextInt();
				System.out.println("Balance = "+bank.amountDeposit(accountNumber, amount));
				break;
		
		case 3: try {
				System.out.println("Enter the account number  ");
				accountNumber = sc.nextInt();
				System.out.println("Enter the amount");
				amount = sc.nextInt();
				System.out.println("Balance = "+bank.amountWithdraw(accountNumber, amount));
				}
				catch(InsufficientBalanceException ibe) {
					System.out.println(ibe.getMessage());
				}
				break;
			
		case 4: try {
			    System.out.println("Enter account number to be searched");
			    accountNumber = sc.nextInt();
			    bank.searchAccount(accountNumber);
				}
				catch(InvalidAccountNumberException iane) {
					System.out.println(iane.getMessage());
				}	
				break;
				
		case 5 : System.out.println("Enter your account number");
				 accountNumber = sc.nextInt();
				 System.out.println("Enter account number for transfer");
				 int accountNumber1 = sc.nextInt();
				 System.out.println("Enter amount to be transfered");
				 amount = sc.nextInt();
				 bank.fundTransfer(accountNumber1 , accountNumber , amount); 
				 Account sender= new Account();
				 Account receiver = new Account();
				 System.out.println("Transfered to : "+receiver.getAccountNumber());
				 System.out.println("Balance of your account: "+sender.getAmount());
				 System.out.println("Balance of the transferred account : "+receiver.getAmount());
				 break;
				 
		case 6 : System.exit(0);;

	}
		}
		//sc.close();
	}



}
