package com.cg.mypaymentapp.services;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exceptions.InsufficientBalanceException;
import com.cg.mypaymentapp.exceptions.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;

@Service(value="appServices")
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepo repo;
	BigDecimal minBalance = new BigDecimal("500");
	BigDecimal tempBalance;
	
	@Transactional
	@Override
	public Customer createAccount(Customer customer) {
		while (true) {
			if (validateName(customer.getName())) {
				break;
			} else {
				throw new InvalidInputException("Invalid Name");
			}
		}
		while (true) {
			if (validateMobileNumber(customer.getMobileNo())) {
				break;
			} else {
				throw new InvalidInputException("Invalid Mobile Number");
			}
		}
		while (true) {
		if (validateAmount(customer.getWallet().getBalance().toString())) {
				break;
			} else {
				throw new InvalidInputException("Invalid Amount");
			}
		}
		return repo.save(customer);
	}

	@Transactional
	@Override
	public Customer showBalance(String mobileno) {
		return repo.findOne(mobileno);
	}

	@Transactional
	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo,
			BigDecimal amount) {
		if (repo.findOne(sourceMobileNo) == null) {
			throw new InvalidInputException("Invalid source mobile number ");
		} else if (repo.findOne(targetMobileNo) == null) {
			throw new InvalidInputException("Invalid target mobile number ");
		} else {
			Customer sourceCustomer = repo.findOne(sourceMobileNo);
			Customer targetCustomer = repo.findOne(targetMobileNo);
			tempBalance = sourceCustomer.getWallet().getBalance();
			BigDecimal tempBalance = sourceCustomer.getWallet().getBalance();
			if (tempBalance.max(minBalance).equals(new BigDecimal("500"))) {
				throw new InsufficientBalanceException("Insufficient Balance.");
			} else if (tempBalance.subtract(amount).max(minBalance)
					.equals(minBalance)) {
				throw new InsufficientBalanceException("Overdraft limit error.");
			} else {
				Wallet sourceWallet = new Wallet(sourceCustomer.getWallet()
						.getBalance().subtract(amount));
				Wallet targetWallet = new Wallet(targetCustomer.getWallet()
						.getBalance().add(amount));
				sourceCustomer.setWallet(sourceWallet);
				targetCustomer.setWallet(targetWallet);
				if (repo.save(sourceCustomer)!=null && repo.save(targetCustomer)!=null) {
					return sourceCustomer;
				} else {
					return null;
				}
			}
		}
	}

	@Transactional
	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		Customer customer = repo.findOne(mobileNo);
		if (customer != null) {

			Wallet wallet = new Wallet(customer.getWallet().getBalance()
					.add(amount));
			customer.setWallet(wallet);
			if (repo.save(customer)!=null) {
				return customer;
			} else {
				return null;
			}
		} else
			throw new InvalidInputException("Invalid mobile no ");
	}

	@Transactional
	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		Customer customer = repo.findOne(mobileNo);
		if (customer != null) {
			BigDecimal tempBalance = customer.getWallet().getBalance();
			if (tempBalance.max(minBalance).equals(new BigDecimal("500"))) {
				throw new InsufficientBalanceException("Insufficient Balance.");
			} else if (tempBalance.subtract(amount).max(minBalance)
					.equals(minBalance)) {
				throw new InsufficientBalanceException("Overdraft limit error.");
			} else {
				Wallet wallet = new Wallet(customer.getWallet().getBalance()
						.subtract(amount));
				customer.setWallet(wallet);
				if (repo.save(customer)!=null) {
					return customer;
				} else {
					return null;
				}
			}
		} else
			throw new InvalidInputException("Invalid mobile no ");
	}
	
	private boolean validateName(String str) {
		String pattern = "[A-Z][a-z]{3,50}";

		if (str.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validateMobileNumber(String str) {
		String pattern = "[1-9][0-9]{9,9}";

		if (str.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validateAmount(String str) {
		String pattern = "[1-9][0-9]{1,9}";

		if (str.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

}
