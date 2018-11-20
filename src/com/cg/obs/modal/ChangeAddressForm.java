package com.cg.obs.modal;

import javax.validation.constraints.Size;

public class ChangeAddressForm {

	@Size(min=1,message="Address cannot be Empty")
	public String newAddress;

	public String getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}
	
}
