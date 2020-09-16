package com.he.addressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class AddressBook {

	private List<Contact> contacts;

	public AddressBook() {
		// TODO
	}

	public AddressBook(List<Contact> contacts) {
		//super();
		this.contacts = contacts;
	}

	public void addContact(Contact contact) {
		if (contacts != null) {
			boolean nameExists = contacts.stream().anyMatch(t -> t.getName().equalsIgnoreCase(contact.getName()));
			if (nameExists) {
				throw new MyException("No two contacts in an addressbook can have the same names");
			} else {
				contacts.add(contact);
			}
		} else {
			contacts = new ArrayList<Contact>();
			contacts.add(contact);
		}
	}

	public void deleteContact(String name) {
		int beforeDeletionSize = contacts.size();
		contacts.removeIf(t -> t.getName().equalsIgnoreCase(name));
		int afterDeletionSize = contacts.size();
		if (beforeDeletionSize == afterDeletionSize) {
			throw new MyException("No such records exists for name:" + name);
		}
	}

	public void updateContact(String name, Contact contact) {
		name = name.toLowerCase();
		boolean b = true;
		ListIterator itr = contacts.listIterator();
		while (itr.hasNext()) {
			Contact conatctFound = (Contact) itr.next();
			String names = conatctFound.getName().toLowerCase();
			if (name.startsWith(names)) {
				itr.set(contact);
				b = false;
			}
			if (b) {
				throw new MyException("Name Specified is not found");
			}
		}
	}

	public List<Contact> searchByName(String name) {
		if (name.length() == 0) {
			// For empty String
			return getContacts();
		}
		List<Contact> getContactBasedOnprefix = null;
		if (contacts.size() > 0) {
			// List of Contact contains value
			getContactBasedOnprefix = contacts.stream()
					.filter(contactInfo -> contactInfo.getName().toLowerCase().startsWith(name.toLowerCase()))
					.collect(Collectors.toList());
		}
		return getContactBasedOnprefix;
	}

	public List<Contact> searchByOrganisation(String organisation) {
		if (organisation.length() == 0) {
			// For empty String
			return getContacts();
		}
		List<Contact> getContactBasedOnprefix = null;
		if (contacts.size() > 0) {
			System.out.println("Size:" + contacts.size());
			System.out.println(organisation);
			// List of Contact contains value
			getContactBasedOnprefix = contacts.stream().filter(
					contactInfo -> contactInfo.getOrganisation().toLowerCase().startsWith(organisation.toLowerCase()))
					.collect(Collectors.toList());
		}
		return getContactBasedOnprefix;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

}