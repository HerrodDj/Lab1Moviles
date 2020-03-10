<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="politics.ico" type="image/x-icon" />
                <link href="css/bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
        
        <title>Login</title>
    </head>
    <body>
<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Bienvenido Nuevamente</h5>
            <form class="form-signin"  method="POST" action="ServicioLogin">
              <div class="form-label-group">
                <input type="text" id="inputUser" name ="inputUser"class="form-control" placeholder="Usuario" required autofocus>
                <label for="User">Usuario</label>
              </div>

              <div class="form-label-group">
                <input type="password" id="inputPassword" name ="inputPassword"class="form-control" placeholder="Contraseña" required>
                <label for="inputPassword">Password</label>
              </div>
                
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Ingresar</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
    </body>
</html>