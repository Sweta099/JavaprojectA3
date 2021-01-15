package com.capgemini.service;

import java.util.LinkedList;
import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.module.*;

public class ICICIBank implements Bank {
LinkedList<Account> accountList = new LinkedList<>();
	
	public String createAccount(int accountNumber , int amount) throws InsufficientOpeningAmountException{
		for(Account account: accountList) {
			if(accountNumber == account.getAccountNumber()) {
				return" Account already exist" ;
			}
		}
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		
		if(amount<500) {
			throw new InsufficientOpeningAmountException("Insufficient amount to create a account");
		}
		account.setAmount(amount);
		accountList.add(account);
		return "Account created";
	}
	
	public Account searchAccount(int accountNumber) throws InvalidAccountNumberException  {
		for(Account account: accountList) {
			if(accountNumber == account.getAccountNumber()) {
				return account;
			}			
		}
		throw new InvalidAccountNumberException("Invalid account number");
	}
	
	public int amountWithdraw(int accountNumber,int amount) throws InsufficientBalanceException {
		Account account = new Account();
		try{account = searchAccount(accountNumber);}
		catch(InvalidAccountNumberException iane) {
			System.out.println(iane.getMessage());
		}
		if(account.getAmount()>amount) {
			account.setAmount( account.getAmount()-amount);
			return account.getAmount();
		}
		throw new InsufficientBalanceException("Insufficient balance");
	}
	
	public int amountDeposit(int accountNumber, int amount) {
		Account account = new Account();
		try {
		account = searchAccount(accountNumber);
		}catch(InvalidAccountNumberException iane) {
			System.out.println(iane.getMessage());
		}
		account.setAmount(account.getAmount()+amount);
		System.out.println(" succesfull deposit");
		return account.getAmount();
	}
	
	public void fundTransfer(int accountNumber , int accountNumber2 , int amount) {
		Account sender = new Account();
		try{sender = searchAccount(accountNumber2);}
		catch(InvalidAccountNumberException iane) {
			System.out.println(iane.getMessage());
		}
		if(sender.getAmount() < amount) {
			System.out.println("Insufficient Balance to transfer fund");
		}
		Account receiver = new Account();
		try{receiver = searchAccount(accountNumber);}
		catch(InvalidAccountNumberException iane) {
			System.out.println(iane.getMessage());
		}
		receiver.setAmount(receiver.getAmount()+amount);
		sender.setAmount(sender.getAmount()-amount);
		}
}
