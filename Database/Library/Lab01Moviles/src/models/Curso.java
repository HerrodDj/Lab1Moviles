/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Curso {

    public Curso(String codigo, String nombre, int creditos, int horasSemanales, Date cicloInicio, Date cicloFinal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
        this.cicloInicio = cicloInicio;
        this.cicloFinal = cicloFinal;
    }

    public Curso() {
        this(null,null,0,0,null,null);
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

    public Date getCicloInicio() {
        return cicloInicio;
    }

    public void setCicloInicio(Date cicloInicio) {
        this.cicloInicio = cicloInicio;
    }

    public Date getCicloFinal() {
        return cicloFinal;
    }

    public void setCicloFinal(Date cicloFinal) {
        this.cicloFinal = cicloFinal;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", nombre=" + nombre + ", creditos=" + creditos + ", horasSemanales=" + horasSemanales + ", cicloInicio=" + cicloInicio + ", cicloFinal=" + cicloFinal + '}';
    }
    
    
    
    private String codigo;
    private String nombre;
    private int creditos;
    private int horasSemanales;
    private Date cicloInicio;
    private Date cicloFinal;
}
