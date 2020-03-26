package com.example.movilversion.data.Datos;


import com.example.movilversion.data.LogicaNeg.Carrera;
import com.example.movilversion.data.LogicaNeg.Curso;
import com.example.movilversion.data.LogicaNeg.Usuario;

import java.util.ArrayList;


public class Data {

    private ArrayList<Carrera> listaCarreras;
    private ArrayList<Curso> listaCursos;

    public Data() {
        listaCarreras = new ArrayList<>();
        listaCursos = new ArrayList<>();
        prepareCarreraData();
        prepareCursoData();
    }



    public void prepareCarreraData() {
        Carrera carrera = new Carrera("EIF300", "Ingenieria en sistemas","Bachillerato");
        listaCarreras.add(carrera);
        carrera = new Carrera("LIX200", "Ingles","Bachillerato");
        listaCarreras.add(carrera);
        carrera = new Carrera("MAT500", "Matematica","Licenciatura");
        listaCarreras.add(carrera);
        carrera = new Carrera("FRP200", "Frances","Bachillerato");
        listaCarreras.add(carrera);
        carrera = new Carrera("EIF305", "Ingenieria en sistemas II","Maestria");
        listaCarreras.add(carrera);
    }

    public void prepareCursoData() {
        Curso curso = new Curso("PR", "Soporte", 3, 4,"EIF300",1,2020);
        listaCursos.add(curso);
        curso = new Curso("PR", "Progra 4", 4, 6,"EIF300",2,2020);
        listaCursos.add(curso);
        curso = new Curso("IG", "Ingles Integrado 4", 4, 6,"LIX200",1,2020);
        listaCursos.add(curso);
        curso = new Curso("IG", "Ingles Conversacional", 3, 8,"LIX200",2,2020);
        listaCursos.add(curso);
        curso = new Curso("MT", "Mate I", 3, 4,"MAT500",1,2019);
        listaCursos.add(curso);
        curso = new Curso("MT", "Ecuaciones", 4, 6,"MAT500",2,2019);
        listaCursos.add(curso);
        curso = new Curso("FR", "Frances 2", 3, 6,"FRP200",1,2018);
        listaCursos.add(curso);
        curso = new Curso("FR", "Frances Conversacional", 4, 8,"FRP200",2,2018);
        listaCursos.add(curso);
        curso = new Curso("PR2", "Soporte II", 3, 4,"EIF305",1,2020);
        listaCursos.add(curso);
        curso = new Curso("PR2", "Analisis de Datos", 4, 8,"EIF305",2,2020);
        listaCursos.add(curso);
    }


    public ArrayList<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCarreras(ArrayList<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }
    public void setListaCursos(ArrayList<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }



    public ArrayList<Usuario> getUsuariosList() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("116810263","123","Diego","Monterrey","Benavides"));
        usuarios.add(new Usuario("504210953","123","Djenane","Hernandez","Rodrigues"));
        usuarios.add(new Usuario("123","123","Admin","",""));
        return usuarios;
    }
}
