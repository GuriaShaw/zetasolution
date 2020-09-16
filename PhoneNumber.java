package com.he.addressBook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    private String label;
    private String phoneNumber;

    public PhoneNumber(String label, String phoneNumber) throws Exception {
    	this.label = label;
		this.phoneNumber = phoneNumber;
    }

    public String getLabel() {
    	if (label != null || label.length() == 0) {
			if (label.length() <= 255) {
				Pattern p = Pattern.compile("^[ A-Za-z]+$");
				Matcher m = p.matcher(label);
				boolean b = m.matches();
				if (b) {
					return label;
				} else {
					throw new MyException("Should contain only English alphabet and White Spaces");
				}
			} else
				throw new MyException("Label should not exceed 255 characters");
		} else {
			throw new MyException("Cannot be empty or null");
		}
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPhoneNumber() {
    	if (phoneNumber.length() == 10) {
			Pattern p = Pattern.compile("^[0-9]+$");
			Matcher m = p.matcher(phoneNumber);
			boolean b = m.matches();
			if (b) {
				return phoneNumber;
			} else {
				throw new MyException("Should contain digits only");
			}
		} else
			throw new MyException("Phone Number should be of length 10 digits, Entered PhoneNumber is of Length:"
					+ phoneNumber.length());
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
