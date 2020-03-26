package com.example.movilversion.data.LogicaNeg;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String cedula;
    private String contraseña;
    private String nombre;
    private String apellido1;
    private String apellido2;


    public Usuario() {
        this.cedula = "";
        this.contraseña = "";
        this.nombre="";
        this.apellido1="";
        this.apellido2="";
    }



    public Usuario(String cedula, String contraseña, String nombre, String apellido1, String apellido2) {
        this.cedula = cedula;
        this.contraseña = contraseña;
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String nombreCompleto(){
        String completo;
        completo = this.getNombre()+" "+this.getApellido1()+" "+this.getApellido2();
        return completo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cedula='" + cedula + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido 1='" + apellido1 + '\'' +
                ", apellido 2='" + apellido2 + '\'' +
                '}';
    }
}
