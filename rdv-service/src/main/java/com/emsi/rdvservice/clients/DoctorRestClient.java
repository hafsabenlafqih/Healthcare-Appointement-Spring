package com.emsi.rdvservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctor-service", url = "http://localhost:8081")
public interface DoctorRestClient {

    @GetMapping("/api/doctors/{id}")
    DoctorDto getDoctorById(@PathVariable("id") Long id);
}
