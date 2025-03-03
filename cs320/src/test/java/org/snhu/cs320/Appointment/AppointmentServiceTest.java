package org.snhu.cs320.Appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentServiceTest {
    private AppointmentService service;

    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
    }

    @Test
    public void testAddValidAppointment() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();
        
        Appointment appointment = new Appointment("123", futureDate, "Checkup");
        service.addAppointment(appointment);

        assertEquals(appointment, service.getAppointment("123"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();
        
        Appointment appointment1 = new Appointment("1234", futureDate, "Checkup");
        Appointment appointment2 = new Appointment("1234", futureDate, "Checkup 2");

        service.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));
    }

    @Test
    public void testDeleteAppointment() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date futureDate = calendar.getTime();
        
        Appointment appointment = new Appointment("123456", futureDate, "Checkup");
        service.addAppointment(appointment);

        service.deleteAppointment("123456");
        assertNull(service.getAppointment("123456"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("99999"));
    }
}
