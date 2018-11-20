package com.cg.obs.modal;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class FundTransferForm {
		
		@Pattern(regexp="[0-9]{10}", message="Account number should be a 10 digit number")
		private String recAccNo;
	    @Pattern(regexp="[0-9]{1,15}", message="Amount should be in number format")
		private String amount;
	    @Pattern(regexp="[0-9]{4}", message="Transaction Password should be a 4 digit Id")
		private String transPassword;
		
		public String getRecAccNo() {
			return recAccNo;
		}
		public void setRecAccNo(String recAccNo) {
			this.recAccNo = recAccNo;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getTransPassword() {
			return transPassword;
		}
		public void setTransPassword(String transPassword) {
			this.transPassword = transPassword;
		}
		
		
	    
		} 