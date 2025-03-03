package org.snhu.cs320.Appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentTest {

    @Test
    public void testValidAppointment() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1); 
        Date futureDate = calendar.getTime();
        
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor's visit");

        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor's visit", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentIdTooLong() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();

        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("12345678901", futureDate, "Dentist appointment")
        );
    }

    @Test
    public void testInvalidNullAppointmentId() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();

        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment(null, futureDate, "Meeting")
        );
    }

    @Test
    public void testInvalidPastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); 
        Date pastDate = calendar.getTime();

        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("12345", pastDate, "Past appointment")
        );
    }

    @Test
    public void testInvalidNullDate() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("12345", null, "No date provided")
        );
    }

    @Test
    public void testInvalidDescriptionTooLong() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();

        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("12345", futureDate, "AppointmentDescriptionAppointmentDescriptionAppointmentDescriptionAppointmentDescription")
        );
    }

    @Test
    public void testInvalidNullDescription() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();

        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("12345", futureDate, null)
        );
    }
}
