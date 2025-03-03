package org.snhu.cs320.Appointment;

import java.util.Date;

public class Appointment {
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Validate appointmentId
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID can't be empty and can't have more than 10 characters.");
        }
        // Validate appointmentDate
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must be not empty and can't be made in the past.");
        }
        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be not empty and can't be more than 50 characters.");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return new Date(appointmentDate.getTime()); 
    }

    public String getDescription() {
        return description;
    }
}
