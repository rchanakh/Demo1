package com.cg.obs.modal;

import javax.validation.constraints.Pattern;

public class UpdateForgotPasswordForm {
		@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).{5,15})", message="Password must be between 6 to 15 characters.\nAtleast 1 uppercase, 1 lowercase, 1 special symbol and a special character'@#$%'")
		private String password;
		@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).{5,15})", message="Password must be between 6 to 15 characters.\nAtleast 1 uppercase, 1 lowercase, 1 special symbol and a special character'@#$%'")
		private String ConfPassword;
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfPassword() {
			return ConfPassword;
		}
		public void setConfPassword(String confPassword) {
			ConfPassword = confPassword;
		}
		
		} 
