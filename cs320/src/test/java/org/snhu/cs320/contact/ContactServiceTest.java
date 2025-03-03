package org.snhu.cs320.contact;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("12345", "Bruce", "Wayne", "1234567890", "Wayne Manor");
        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    void testAddDuplicateContactId() {
		Contact contact1 = new Contact("12345", "Bruce", "Wayne", "1234567890", "Wayne Manor");
        Contact contact2 = new Contact("12345", "Clark", "Kent", "0987654321", "Fortress of Solitude");

        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("12345", "Bruce", "Wayne", "1234567890", "Wayne Manor");
        service.addContact(contact);
        service.deleteContact("12345");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("12345"));
    }

    @Test
    void testDeleteNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99999"));
    }

    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact("12345", "Bruce", "Wayne", "1234567890", "Wayne Manor");
        service.addContact(contact);
        service.updateFirstName("12345", "Jane");
        assertEquals("Jane", service.getContact("12345").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        Contact contact = new Contact("12345", "Bruce", "Wayne", "1234567890", "Wayne Manor");
        service.addContact(contact);
        service.updateLastName("12345", "Smith");
        assertEquals("Smith", service.getContact("12345").getLastName());
    }

    @Test
    void testUpdatePhone() {
        Contact contact = new Contact("12345", "Bruce", "Wayne", "1234567890", "Wayne Manor");
        service.addContact(contact);
        service.updatePhone("12345", "0987654321");
        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    @Test
    void testUpdateAddress() {
        Contact contact = new Contact("12345", "Bruce", "Wayne", "1234567890", "Wayne Manor");
        service.addContact(contact);
        service.updateAddress("12345", "Fortress of Solitude");
        assertEquals("Fortress of Solitude", service.getContact("12345").getAddress());
    }

    @Test
    void testUpdateNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("99999", "Clark"));
    }

    @Test
    void testUpdateWithInvalidData() {
        Contact contact = new Contact("12345", "Bruce", "Wayne", "1234567890", "Wayne Manor");
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("12345", "ThisNameIsTooLong"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("12345", "12345"));
    }
}
