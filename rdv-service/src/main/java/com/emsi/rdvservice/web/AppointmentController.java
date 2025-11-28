package com.emsi.rdvservice.web;

import com.emsi.rdvservice.entities.Appointment;
import com.emsi.rdvservice.services.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/rdv")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAll() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public Appointment create(@RequestParam Long doctorId,
                              @RequestParam String patientName,
                              @RequestParam String patientEmail,
                              @RequestParam String dateTime) {
        // Exemple : dateTime = "2025-11-30T10:30"
        LocalDateTime dt = LocalDateTime.parse(dateTime);
        return appointmentService.createAppointment(doctorId, patientName, patientEmail, dt);
    }
}
