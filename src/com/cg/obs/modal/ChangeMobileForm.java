package com.cg.obs.modal;

import javax.validation.constraints.Pattern;

public class ChangeMobileForm {
	
	    @Pattern(regexp="[0-9]{10}", message="Mobile number should be of 10 digits ")
		private String newMobile;

		public String getNewMobile() {
			return newMobile;
		}

		public void setNewMobile(String newMobile) {
			this.newMobile = newMobile;
		}

		

	}
