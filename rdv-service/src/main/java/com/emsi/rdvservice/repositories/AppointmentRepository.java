package com.emsi.rdvservice.repositories;

import com.emsi.rdvservice.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
