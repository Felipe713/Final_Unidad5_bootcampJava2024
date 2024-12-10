package com.edutecno.FinalUnidad5.models;

public class Usuario {
    private String nombre;
    private String email;
    private String username;
    private String fechaNacimiento;
    private String password;

    // Constructor
    public Usuario(String nombre, String email, String username, String fechaNacimiento, String password) {
        this.nombre = nombre;
        this.email = email;
        this.username = username;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
