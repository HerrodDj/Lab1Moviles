
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

function SearchTypeCarrera(type){
    var search = document.getElementById("searchType").value;
    if (search === "searchAll"){
        type ="ServicioListCarrera?type=searchAll";
    }
    if(search === "searchCodigo"){
        var t= document.getElementById("searchText").value;
        type="ServicioListCarrera?type=searchCodigo";
    }
    if (search === "searchNombre"){
        var t= document.getElementById("searchText").value;
        type="ServicioListCarrera?type=searchNombre";
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
            nuevaCelda.innerHTML = '<a class="btn btn-outline-primary" role="button" href="ServicioEditarCarrera?codigoC='+datos.carreras[i].codigo+'">Editar</a>';
            nuevaCelda= nuevaFila.insertCell(-1);
            nuevaCelda.innerHTML='<a class="btn btn-outline-danger" role="button" href="ServicioEliminarCarrera?codigoC='+datos.carreras[i].codigo+'">Eliminar</a>'

        }

    }
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
        option.text =datos.carreras[i].nombre;
        select.add(option);
    }
}

function cargarSelectCarreras2(datos){
    addOptions2("carrera",datos);
    
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
            nuevaCelda.innerHTML = '<a class="btn btn-outline-primary" role="button" href="ServicioEditarCurso?codigoC='+datos.cursos[i].codigo+'">Editar</a>';
            nuevaCelda=nuevaFila.insertCell(-1);
            nuevaCelda.innerHTML='<a class="btn btn-outline-danger" role="button" href="ServicioEliminarCurso?codigo='+datos.cursos[i].codigo+'">Eliminar</a>'



        }

    }
}


function optionCicle(){
    var option = document.getElementById("ciclo");
    var valor = document.getElementById("ciclo").value;
    switch(valor){
        case "1": 
            option.text = "I ciclo";
            break;
        case "2": 
            option.text = "II ciclo";
            break;
        case "3":
            option.text = "III ciclo (verano)";
            break;
        default:
            option.text="Pendiente";
            break;
    }
    
    
} 

function editCurso(){
    myOnLoad();
    optionCicle();
}


function searchCarrera() {
    var search = document.getElementById("search").value;
    var tipo =document.getElementById("tipo").value;
    document.getElementById("search").href='ServicioListCarrera?search='+search+'?tipo='+tipo;
  

}