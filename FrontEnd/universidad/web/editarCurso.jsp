<%-- 
    Document   : editarCurso
    Created on : 14-mar-2020, 22:53:24
    Author     : djenanehernandezrodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Servicio.ServicioEditarCurso"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap/bootstrap-reboot.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/scripts.js" type="text/javascript"></script>
        <title>Editar Curso </title>
    </head>

    <body onLoad="myOnLoad()">
        <div>
            <%@include file="menu.jsp" %>
        </div>

        <div class="container" id="container" style="border-radius: 50px 50px 50px 50px; background-color: white; border: solid #CDEBDB">
            <div class="card-body" >
                <div>
                    <div>
                        <h4>Editar Curso</h4>
                    </div>
                </div>
                <form id="uploadForm" encty="multipart/form-data" method="POST" action="ServicioEditarCurso" >
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-10">

                                    <label for="form-control col-6" class="form-label">Código</label>
                                </div>

                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-8">
                                    <input type="text" id="codigoCurso" name="codigoCurso" class="form-control"
                                           readonly value="${codigo}"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label>Nombre del curso</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-8">
                                    <input type="text" id="nombreCurso" name="nombreCurso" class="form-control"
                                           required autofocus value="${nombre}"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div  class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label>Carrera</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <select class="form-control" name="carrera" id="carrera" value="${carrera}">
                                <option>Seleccione una Carrera...</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label>Número de creditos</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-8">
                                    <input type="number" id="creditoCurso" name="creditoCurso" class="form-control"
                                           required autofocus value="${creditos}"/>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label>Horas semanales</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-8">
                                    <input type="number" id="horaCurso" name="horaCurso" class="form-control"
                                           required autofocus value="${horas}"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-8">
                                    <select id ="cicloCurso" name ="cicloCurso" class="form-control form-control-sm" value="${ciclo}"/>
                                        <option  >Seleccione el Ciclo</option>
                                        <option  value ="1" >I ciclo</option>
                                        <option  value ="2" >II ciclo</option>
                                        <option value ="3" >III ciclo(verano)</option>

                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-6">
                                    <label for="form-control col-3" class="form-label">Año</label>
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-sm-6">
                                    <input type="number" id="anioCurso" name="anioCurso" class="form-control"
                                           required autofocus value="${anio}" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-8">
                            <button type="submid"> Guardar</button>
                        </div>
                        <div class="col-md-4">
                            <button type="button" class="btn btn-outline-danger" id="cancelButton" onclick='javascript:cancelAction()'>Cancelar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
