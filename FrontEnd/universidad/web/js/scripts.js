
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
            nuevaCelda.value=datos.carreras[i].codigo;
            nuevaCelda.innerText = datos.carreras[i].codigo;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.carreras[i].nombre;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.carreras[i].titulo;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerHTML = "<button  type ='button' class='btn btn-primary'> Editar</button>";
            nuevaCelda= nuevaFila.insertCell(-1);
            nuevaCelda.innerHTML='<a href="ServicioEliminarCarrera?codigoC='+datos.carreras[i].codigo+'">Eliminar</a>'

        }

    }
}

function linkeoEditCarrera() {
  window.location.href = "http://localhost:8080/universidad/editarCarrera.jsp";

}


function myDeleteTable(tabla) {
    document.getElementById(tabla).deleteRow(0);
}

//Editar carrera
function onLoadCarrera(){
    
    
}

// Eliminar carrera

function eliminaCarrera(){
    
    
    
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

function initCursos(){
    solicitarDatosCursos("ServicioListarCurso", "cursoList");
    console.log("Aplicación inicializada..");
}

function solicitarDatosCursos(origen, tabla) {
    fetch(origen).then(
            (resultados) => {
        return resultados.json();
    }
    ).then(
            (datosJSON) => {
        cargarTablaCursos(tabla, datosJSON);
    }
    );
}


function cargarTablaCursos(tabla, datos) {
    var refTabla = document.getElementById(tabla);
    if (refTabla) {

        for (var i = 0; i < datos.cursos.length; i++) {
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.cursos[i].codigo;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.cursos[i].nombre;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.cursos[i].carrera;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.cursos[i].creditos;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.cursos[i].horas;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.cursos[i].ciclo;
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datos.cursos[i].anio;
            
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerHTML = "<button  type ='button' class='btn btn-primary' onclick='location.href= 'editarCurso.jsp' '> Editar</button>";
            nuevaCelda=nuevaFila.insertCell(-1);
            nuevaCelda.innerHTML='<a href="ServicioEliminarCurso?codigo='+datos.cursos[i].codigo+'">Eliminar</a>'



        }

    }
}
