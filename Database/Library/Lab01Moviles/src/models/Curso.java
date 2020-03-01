/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author PC
 */
public class Curso {

    public Curso(String codigo, String nombre, int creditos, int horasSemanales, int ciclo, int anio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
        this.ciclo = ciclo;
        this.anio = anio;
    }

   

    public Curso() {
        this(null,null,0,0,0,0);
    }
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int cicloInicio) {
        this.ciclo = cicloInicio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", nombre=" + nombre + ", creditos=" + creditos + ", horasSemanales=" + horasSemanales + ", ciclo=" + ciclo + ", anio=" + anio + '}';
    }

    
    private String codigo;
    private String nombre;
    private int creditos;
    private int horasSemanales;
    private int ciclo;
    private int anio;
}
