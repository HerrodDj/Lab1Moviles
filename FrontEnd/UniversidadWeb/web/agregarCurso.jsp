<%-- 
    Document   : agregarCurso
    Created on : 14-mar-2020, 22:52:02
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
        <title>Agregar Curso</title>
    </head>

    <body>
        <div>
            <%@include file="menu.jsp" %>
        </div>
        <div class="container" id="container" style="border-radius: 50px 50px 50px 50px; background-color: white; border: solid #CDEBDB">
            <div class="card-body" >
                <div>
                    <div>
                        <h4>Agregar Curso</h4>
                    </div>
                </div>
                <form id="uploadForm" encty="multipart/form-data" method="POST" action="ServicioAgregarCurso" >
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
                                    <input type="text" id="codigoCurso" name="codigoCurso" class="form-control">
                                </div>
                            </div>
                        </div>

                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label for="form-control col-6" class="form-label">Nombre</label>
                                </div>

                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-8">
                                    <input type="text" id="nombreCurso" name="nombreCurso" class="form-control">
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label for="form-control col-6" class="form-label">Número de Créditos</label>
                                </div>

                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-8">
                                    <input type="number" id="creditosCurso" name="creditosCurso" class="form-control">
                                </div>
                            </div>
                        </div>

                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label for="form-control col-6" class="form-label">Horas por semana</label>
                                </div>

                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-8">
                                    <input type="number" id="horasCurso" name="horasCurso" class="form-control">
                                </div>
                            </div>
                        </div>

                    </div>



                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label>Carrera:</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-8">
                                    <select class="form-control form-control-sm" name ="tituloCarrera">
                                        <option value=""></option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div  class="row">
                        <div class="col-4">
                            <select class="form-control form-control-sm" name ="cicloCurso">
                                <option value="1">I Ciclo</option>
                                <option value="2">II Ciclo</option>
                                <option value="3">III Ciclo (Verano)</option>
                            </select>
                        </div>
                        <div class="col-3">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label>Año: </label>
                                </div>
                            </div>
                        </div>

                        <div class="col-4">
                            <div class="form-group">
                                <div class="col-sm-8">
                                    <input type="number" id="anioCurso" name="anioCurso" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-8">
                                <button type="submid">Guardar</button>
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
