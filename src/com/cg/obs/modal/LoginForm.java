package com.cg.obs.modal;

import javax.validation.constraints.Pattern;


	public class LoginForm {
		
		@Pattern(regexp="[0-9]{6}", message="User Id should be of 6 digits ")
		private String uname;
		@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).{5,15})", message="Password must be between 6 to 15 characters.\nAtleast 1 uppercase, 1 lowercase, 1 special symbol and a special character'@#$%'")
		private String password;
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
	} 
