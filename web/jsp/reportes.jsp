<%-- 
    Document   : reportes
    Created on : 5/01/2019, 06:38:23 PM
    Author     : bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

        <title>Hello, world!</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">Gestion Administrativa</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto"></ul>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Cerrar Sesión</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <div class="row pt-4">
                <h1 class="text-center">Reportes</h1>
            </div>
            <div class="row">
                <div class="col-sm-12 col-md-4 pt-4">
                    <div class="card border-primary">
                        <img class="card-img-top p-2" src="../assets/images/salon.png" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Usuarios</h5>
                            <p class="card-text">Apartado para ver la estructura de usuarios.</p>
                            <a href="../ReporteUsuariosServlet" class="btn btn-primary">Generar</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12 col-md-4 pt-4">
                    <div class="card border-primary">
                        <img class="card-img-top p-2" src="../assets/images/incidenteSalon.png" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Productos</h5>
                            <p class="card-text">Apartado para ver la estructura de productos.</p>
                            <a href="#" class="btn btn-primary">Administrar</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12 col-md-4 pt-4">
                    <div class="card border-primary">
                        <img class="card-img-top p-2" src="../assets/images/incidenteSalon.png" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Ventas</h5>
                            <p class="card-text">Apartado para ver la estructura de ventas.</p>
                            <a href="#" class="btn btn-primary">Administrar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
