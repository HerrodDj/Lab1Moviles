/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author djenanehernandezrodriguez
 */
public class Usuario {

    public Usuario(String cedula, String nombre, String apellido1, String apellido2, String contrasenia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.contrasenia = contrasenia;
    }

    public Usuario() {
        this(null, null, null, null, null);
    }

    
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String toString(){
    return String.format("Ced: %s, %s %s %s",cedula, nombre, apellido1, apellido2);
    
    }
    
    private String cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String contrasenia;
    
}
