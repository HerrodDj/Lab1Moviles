
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
            nuevaCelda.innerHTML = "<button  type ='button' class='btn btn-primary' onclick='location.href= 'editarCarrera.jsp' '> Editar</button>\n\
 <button class ='btn btn-danger' type ='button'>Eliminar</button>";



        }

    }
}

function linkeoEditCarrera() {
    window.location = "UniversidadWeb/editarCarrera.jsp";

}


function myDeleteTable(tabla) {
    document.getElementById(tabla).deleteRow(0);
}



























//---------------CURSO---------------
//Agregar curso
function myOnLoad() {
    carga("ServicioListCarrera");
}

function carga(origen) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        cargarSelectCarreras(datosJSON);
    }
    );

}


function cargarSelectCarreras(datos) {
    
    addOptions("carrera", datos);
}


// Rutina para agregar opciones a un <select>
function addOptions(domElement, datos) {
    var select = document.getElementsByName(domElement)[0];

    for (var i = 0; i < datos.carreras.length; i++) {
        var option = document.createElement("option");
        option.value=datos.carreras[i].codigo;
        option.text =datos.carreras[i].nombre
        select.add(option);
    }
}



//Listar Curso












