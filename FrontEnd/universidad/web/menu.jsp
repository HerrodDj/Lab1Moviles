<%-- 
    Document   : menu
    Created on : 10-mar-2020, 0:13:17
    Author     : djenanehernandezrodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width">
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
     <div class="container">
 
    <div class="wrap">
        <span class="decor"></span>
        <nav>
            <ul class="primary">
                <li>
                    <a href="">Carrera</a>
                    <ul class="sub">
                        <li><a href="agregarCarrera.jsp">Agregar</a></li>
                        <li><a href="listarCarrera.jsp">Listar</a></li>
                    </ul>
                </li>
                <li>
                    <a href="">Cursos</a>
                    <ul class="sub">
                        <li><a href="agregarCurso.jsp">Agregar</a></li>
                        <li><a href="listarCurso.jsp">Listar</a></li>
                    </ul>
                </li>
                <li>
                    <a href="ServicioLogut">Logout</a>
                </li>


            </ul>
        </nav>
    </div>
     </div>
</html>
