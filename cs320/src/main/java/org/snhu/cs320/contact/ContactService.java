package org.snhu.cs320.contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private final List<Contact> contacts;

    public ContactService() {
        this.contacts = new ArrayList<>();
    }

    // Add a new contact
    public void addContact(Contact contact) {
       
        for (Contact c : contacts) {
            if (c.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID must be unique.");
            }
        }
        contacts.add(contact);
    }

    // Delete a contact
    public void deleteContact(String contactId) {
        Contact contactToRemove = null;
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                contactToRemove = c;
                break;
            }
        }
        if (contactToRemove == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.remove(contactToRemove);
    }

    // Update first name
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = findContactById(contactId);
        contact.setFirstName(newFirstName);
    }

    // Update last name
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = findContactById(contactId);
        contact.setLastName(newLastName);
    }

    // Update phone number
    public void updatePhone(String contactId, String newPhone) {
        Contact contact = findContactById(contactId);
        contact.setPhone(newPhone);
    }

    // Update address
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = findContactById(contactId);
        contact.setAddress(newAddress);
    }

    //find a contact by ID
    private Contact findContactById(String contactId) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Contact ID not found.");
    }

   
    public Contact getContact(String contactId) {
        return findContactById(contactId);
    }
}
