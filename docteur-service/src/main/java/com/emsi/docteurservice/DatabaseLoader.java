package com.emsi.docteurservice;

import com.emsi.docteurservice.entities.Doctor;
import com.emsi.docteurservice.repositories.DoctorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final DoctorRepository doctorRepository;

    public DatabaseLoader(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void run(String... args) {
        if (doctorRepository.count() == 0) {
            doctorRepository.save(new Doctor("Dr. Dupont", "Cardiologie", "dupont@hopital.fr", "0600000001"));
            doctorRepository.save(new Doctor("Dr. Martin", "Dermatologie", "martin@clinique.fr", "0600000002"));
            doctorRepository.save(new Doctor("Dr. Leroy", "Généraliste", "leroy@cabinet.fr", "0600000003"));
        }
    }
}
