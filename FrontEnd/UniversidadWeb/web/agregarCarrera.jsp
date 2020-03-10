<%-- 
    Document   : AgregarCarrera
    Created on : 10-mar-2020, 0:15:38
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
        <title>Agregar Carrera</title>
    </head>
    <body>
        <div>
            <%@include file="menu.jsp" %>
        </div>

        <div class="container">
            <form > 

                <div class="row">
                    <div >
                        <label>Codigo</label>
                        <input type="text" id="codigoCarrera" name="codigoCarrera"
                               required autofocus>
                    </div>
                    <div >
                        <label>Nombre de la carrera</label>
                        <input type="text" id="codigoCarrera" name="codigoCarrera"
                               required autofocus>
                    </div>
                    <div >
                        <select>
                            <option>Bachillerato</option>
                            <option>Licenciatura</option>
                            <option>Maestria</option>
                        </select>
                    </div>
                    <div>
                        <button type="submid"> Guardar</button>
                    </div>
               <div class="col-md-4">
                            <button type="button" class="btn btn-outline-danger" id="cancelButton" onclick='javascript:cancelAction()'>Cancelar</button>
                        </div>
                      
            </form>

        </div>
    </body>
</html>
