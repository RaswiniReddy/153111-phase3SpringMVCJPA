package com.cg.mypaymentapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.mypaymentapp.beans.Customer;

@Controller
public class URIController {
	@RequestMapping("/")
	public String getIndexPage() {
		return "index";
	}

	@RequestMapping("/createaccount")
	public String getCreateAccountPage() {
		return "createAccountPage";
	}
	
	@RequestMapping("/showbalance")
	public String getShowBalancePage() {
		return "showBalancePage";
	}
	
	@RequestMapping("/fundtransfer")
	public String getFundTransferPage() {
		return "fundTransferPage";
	}
	
	@RequestMapping("/deposit")
	public String getDepositAmountPage() {
		return "depositAmountPage";
	}
	
	@RequestMapping("/withdraw")
	public String getWithdrawAmountPage() {
		return "withdrawAmountPage";
	}

	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}
}
