package com.cg.obs.modal;

import javax.validation.constraints.Pattern;

public class ChangePasswordForm {

        @Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).{5,15})", message="Password must be between 6 to 15 characters.\nAtleast 1 uppercase, 1 lowercase, 1 special symbol and a special character'@#$%'")
		private String oldPassword;
        @Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).{5,15})", message="Password must be between 6 to 15 characters.\nAtleast 1 uppercase, 1 lowercase, 1 special symbol and a special character'@#$%'")
		private String newPassword;
        @Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).{5,15})", message="Password must be between 6 to 15 characters.\nAtleast 1 uppercase, 1 lowercase, 1 special symbol and a special character'@#$%'")
		private String new1Password;
		public String getOldPassword() {
			return oldPassword;
		}
		public void setOldPassword(String oldPassword) {
			this.oldPassword = oldPassword;
		}
		public String getNewPassword() {
			return newPassword;
		}
		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
		}
		public String getNew1Password() {
			return new1Password;
		}
		public void setNew1Password(String new1Password) {
			this.new1Password = new1Password;
		}
		} 



