package com.emsi.rdvservice.clients;

public class DoctorDto {
    private Long id;
    private String nom;
    private String specialite;
    private String email;
    private String telephone;

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
