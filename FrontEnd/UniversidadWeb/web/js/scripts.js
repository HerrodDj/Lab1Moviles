/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function initCarreras() {
    solicitarDatosCarreras("carreras.json", "carreraList");
    console.log("Aplicación inicializada..");
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
            nuevaCelda.innerText = datos.carreras[i].Codigo;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.carreras[i].Nombre;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.carreras[i].Titulo;
        }
    }
}