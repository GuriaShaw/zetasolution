package com.he.addressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private String            name;
    private String            organisation;
    private List<PhoneNumber> phoneNumbers;
    private List<Address>     addresses;

    public Contact(String name, String organisation) throws Exception {
    	this.name = name;
		this.organisation = organisation;
    }

    public String getName() {
    	if (name != null || name.length() == 0) {
			if (name.length() <= 255) {
				Pattern p = Pattern.compile("^[ A-Za-z]+$");
				Matcher m = p.matcher(name);
				boolean b = m.matches();
				if (b) {
					return name;
				} else {
					throw new MyException("Should contain only English alphabet and White Spaces");
				}
			} else
				throw new MyException("Label should not exceed 255 characters");
		} else {
			throw new MyException("Cannot be empty or null");
		}
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        if (this.phoneNumbers == null) {
            this.phoneNumbers = new ArrayList<>();
        }
        this.phoneNumbers.add(phoneNumber);

    }

    public void addAddress(Address address) {
        if (this.addresses == null) {
            this.addresses = new ArrayList<>();
        }
        this.addresses.add(address);
    }

}