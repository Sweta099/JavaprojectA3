package com.capgemini.module;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningAmountException;
import com.capgemini.exceptions.InvalidAccountNumberException;
//import com.capgemini.service.*;

public interface Bank {
	public String createAccount(int accountNumber , int amount) throws InsufficientOpeningAmountException;
	public Account searchAccount(int accountNumber) throws InvalidAccountNumberException;
	public int amountWithdraw(int accountNumber,int amount) throws InsufficientBalanceException;
	public void fundTransfer(int accountNumber , int accountNumber2 , int amount);

}
