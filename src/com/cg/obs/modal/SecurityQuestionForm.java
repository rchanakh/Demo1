package com.cg.obs.modal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class SecurityQuestionForm {

	
	    @Size(min=1, max=20, message="Length of Security Answer should be between 1 and 20")
		private String SecurityAnswer;

		public String getSecurityAnswer() {
			return SecurityAnswer;
		}

		public void setSecurityAnswer(String securityAnswer) {
			SecurityAnswer = securityAnswer;
		}

		} 
