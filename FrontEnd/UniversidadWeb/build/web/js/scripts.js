/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/*
 * Cargar las carreras en tablas
 */


function initCarreras() {
    
    solicitarDatosCarreras("ServicioListCarrera", "carreraList");
    console.log("Aplicación inicializada..");
}

function buscarCarrera(){
    var op= document.getElementById("searchOp").value;
    switch(op){
        case op=== "searchCodigo":
            ;
        
    }
    
}


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
            nuevaCelda.innerText = datos.carreras[i].codigo;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.carreras[i].nombre;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.carreras[i].titulo;
            nuevaCelda = nuevaFila.insertCell(-1);
           
            
        }

    }
}

function myDeleteTable(tabla) {
  document.getElementById(tabla).deleteRow(0);
}


/*
 * Para Editar las carreras
 */
