package org.snhu.cs320.contact;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testContactCreationValid() {
        Contact contact = new Contact("12345", "Bruce", "Wayne", "1234567890", "Wayne Manor");
        assertEquals("12345", contact.getid());
        assertEquals("Bruce", contact.getFirstName());
        assertEquals("Wayne", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("Wayne Manor", contact.getAddress());
    }

    @Test
    void testContactInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Bruce", "Wayne", "1234567890", "Wayne Manor"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Bruce", "Wayne", "1234567890", "Wayne Manor"));
    }

    @Test
    void testContactInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Wayne", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "ThisNameIsTooLong", "Wayne", "1234567890", "Wayne Manor"));
    }

    @Test
    void testContactInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Bruce", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Bruce", "ThisLastNameIsTooLong", "1234567890", "Wayne Manor"));
    }

    @Test
    void testContactInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Bruce", "Wayne", null, "Wayne Manor"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Bruce", "Wayne", "12345", "Wayne Manor"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Bruce", "Wayne", "abcdefghij", "Wayne Manor"));
    }

    @Test
    void testContactInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Bruce", "Wayne", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Bruce", "Wayne", "1234567890", "This address is way too long to be valid"));
    }

    @Test
    void testUpdateValidFields() {
        Contact contact = new Contact("12345", "Bruce", "Wayne", "1234567890", "Wayne Manor");
        contact.setFirstName("Clark");
        contact.setLastName("Kent");
        contact.setPhone("0987654321");
        contact.setAddress("Fortress of Solitude");

        assertEquals("Clark", contact.getFirstName());
        assertEquals("Kent", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("Fortress of Solitude", contact.getAddress());
    }

    @Test
    void testUpdateInvalidFields() {
        Contact contact = new Contact("12345", "Bruce", "Wayne", "1234567890", "Wayne Manor");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("ThisNameIsTooLong"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("This address is far too long to be accepted as valid"));
    }
}
