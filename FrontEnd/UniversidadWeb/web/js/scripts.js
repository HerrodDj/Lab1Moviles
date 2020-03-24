<<<<<<< HEAD
/*
 * Cargar las carreras en tablas
 */


=======
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

>>>>>>> 42f9f04d008816951a25df734ae323c87702648a
function initCarreras() {
    solicitarDatosCarreras("carreras.json", "carreraList");
    console.log("Aplicación inicializada..");
}

<<<<<<< HEAD
function buscarCarrera(){
    var op= document.getElementById("searchOp").value;
    switch(op){
        case op=== "searchCodigo":
            ;
        
    }
    
}
=======
>>>>>>> 42f9f04d008816951a25df734ae323c87702648a

function solicitarDatosCarreras(origen, tabla) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        cargarTabla(tabla, datosJSON);
    }
    );
}

function cargarTabla(tabla, datos) {
    var refTabla = document.getElementById(tabla);
    if (refTabla) {
        
        // Si es necesario, se utiliza el método deleteRow()
        // para eliminar las filas que ya existan en la tabla.
        
        for (var i = 0; i < datos.carreras.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.carreras[i].Codigo;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.carreras[i].Nombre;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.carreras[i].Titulo;
        }
    }
<<<<<<< HEAD
}

function myDeleteTable(tabla) {
  document.getElementById(tabla).deleteRow(0);
}



function initAgregaCurso(){
    cargarCarrerasOpt("");
    console.log("Aplicación inicializada..");
}

function cargarCarrerasOpt(tabla){
        fetch("ServicioListCarrera").then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        carrerasOpt(tabla, datosJSON);
    }
    );
    
}

function addOpt(element, array){
    var select = document.getElementsByName(element);
    for (value in array){
        var option = document.createElement("option");
        option.text = array[value];
        select.add(option);
    }
=======
>>>>>>> 42f9f04d008816951a25df734ae323c87702648a
}