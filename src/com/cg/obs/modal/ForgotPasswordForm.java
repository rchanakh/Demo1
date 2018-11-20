package com.cg.obs.modal;

import javax.validation.constraints.Pattern;

public class ForgotPasswordForm {
	    @Pattern(regexp="[0-9]{10}", message="Account number should be a 10 digit number")
		private String AccountNumber;

		public String getAccountNumber() {
			return AccountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			AccountNumber = accountNumber;
		}

	} 
