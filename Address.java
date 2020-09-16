package com.he.addressBook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {

	private String label;
	private String address;
	
	public Address(String label, String address) throws Exception {
		this.label = label;
		this.address = address;
	}
	
	public String getLabel() {
		if (this.label != null || this.label.length() == 0) {
			if (this.label.length() <= 255) {
				Pattern p = Pattern.compile("^[ A-Za-z]+$");
				Matcher m = p.matcher(this.label);
				boolean b = m.matches();
				if (b) {
					return this.label;
				} else {
					throw new MyException("Should contain only English alphabet and White Spaces");
				}
			} else
				throw new MyException("Label should not exceed 255 characters");
		} else {
			throw new MyException("Cannot be empty or null");
		}
	}
	
	public String getAddress() {
		return this.address;
	}
}
