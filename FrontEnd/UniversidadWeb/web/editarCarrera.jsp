<%-- 
    Document   : editarCarrera
    Created on : 14-mar-2020, 22:51:02
    Author     : djenanehernandezrodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificando Carrera</title>
    </head>
    <body>
     <body>
        <div>
            <%@include file="menu.jsp" %>
        </div>
        <div class="container" id="container" style="border-radius: 50px 50px 50px 50px; background-color: white; border: solid #CDEBDB">
            <div class="card-body" >
                <div>
                    <div>
                        <h4>Modificar Carrera</h4>
                    </div>
                </div>
                <form id="uploadForm" encty="multipart/form-data" method="POST" action="ServicioEditarCarrera" >
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
                                    <input type="text" id="codigoCarrera" name="codigoCarrera" class="form-control">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label>Nombre de la carrera</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-8">
                                    <input type="text" id="nombreCarrera" name="nombreCarrera" class="form-control"
                                           required autofocus>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div  class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <label>Titulo de la carrera</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <select class="form-control form-control-sm" name ="tituloCarrera">
                                <option>Bachillerato</option>
                                <option>Licenciatura</option>
                                <option>Maestria</option>
                            </select>
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
