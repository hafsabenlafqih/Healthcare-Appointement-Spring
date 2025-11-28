package com.emsi.rdvservice.services;

import com.emsi.rdvservice.clients.DoctorDto;
import com.emsi.rdvservice.clients.DoctorRestClient;
import com.emsi.rdvservice.entities.Appointment;
import com.emsi.rdvservice.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRestClient doctorRestClient;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRestClient doctorRestClient) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRestClient = doctorRestClient;
    }

    public Appointment createAppointment(Long doctorId,
                                         String patientName,
                                         String patientEmail,
                                         LocalDateTime dateTime) {

        // 1. Vérifier que le docteur existe via FeignClient
        DoctorDto doctor = doctorRestClient.getDoctorById(doctorId);
        if (doctor == null) {
            throw new RuntimeException("Le médecin avec l'id " + doctorId + " n'existe pas");
        }

        // 2. Créer et sauvegarder le rendez-vous
        Appointment appointment = new Appointment(doctorId, patientName, patientEmail, dateTime);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
