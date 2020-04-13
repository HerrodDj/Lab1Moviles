<%-- 
    Document   : listarCurso
    Created on : 14-mar-2020, 22:52:32
    Author     : djenanehernandezrodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap/bootstrap-reboot.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/scripts.js" type="text/javascript"></script>
        <title>Lista de Cursos</title>
    </head>
    <body onload="initCursos()">
        <div>
            <%@include file="menu.jsp" %>
        </div>

        <div class="Container">
            <div>
                <div>
                    <h4>Lista de Cursos</h4>
                </div>
            </div>
            <div class="row">
                 <span style="white-space: pre-line"></span>
                <br/>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-responsive">        
                            <table id="tableCurso" class="table table-striped table-bordered border-info" style="width:100%">
                                <thead>
                                    <tr>
                                        <th style="background-color: #5da17a; color:white; text-align: center">Código </th>
                                        <th style="background-color: #5da17a; color:white; text-align: center">Nombre</th>
                                        <th style="background-color: #5da17a; color:white; text-align: center">Carrera</th>
                                        <th style="background-color: #5da17a; color:white; text-align: center">Creditos</th>
                                        <th style="background-color: #5da17a; color:white; text-align: center">Horas Semanales</th>
                                        <th style="background-color: #5da17a; color:white; text-align: center">Ciclo</th>
                                        <th style="background-color: #5da17a; color:white; text-align: center">Año</th>
                                        <th style="background-color: #5da17a; color:white; text-align: center">Editar</th>
                                        <th style="background-color: #5da17a; color:white; text-align: center">Eliminar</th>
                                </thead>
                                <tbody style="background-color: #CDEBDB;" id="cursoList">
                                </tbody>
                            </table
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
