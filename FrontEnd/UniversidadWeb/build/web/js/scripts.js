
/*
 * Cargar las carreras en tablas
 */


function initCarreras() {
    solicitarDatosCarreras("ServicioListCarrera", "carreraList");
    console.log("Aplicación inicializada..");
}


function buscarCarrera() {
    var op = document.getElementById("searchOp").value;
    switch (op) {
        case op === "searchCodigo":
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
        cargarTablaCarreras(tabla, datosJSON);
    }
    );
}

function cargarTablaCarreras(tabla, datos) {
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
            nuevaCelda.innerHTML = "<button  type ='button' class='btn btn-primary' onclick='editarCarrera()'> Editar</button>\n\
 <button class ='btn btn-danger' type ='button'>Eliminar</button>";



        }

   }
}



function myDeleteTable(tabla) {
    document.getElementById(tabla).deleteRow(0);
}



function initAgregaCurso() {
    cargarCarrerasOpt("");
    console.log("Aplicación inicializada..");
}

function cargarCarrerasOpt(tabla) {
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

function addOpt(element, array) {
    var select = document.getElementsByName(element);
    for (value in array) {
        var option = document.createElement("option");
        option.text = array[value];
        select.add(option);
    }
}


function editarCarrera(){
    
    
    
}