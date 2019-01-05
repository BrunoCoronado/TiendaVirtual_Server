<%-- 
    Document   : usuarios
    Created on : 3/01/2019, 11:47:59 PM
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

        <title>Hello, world!</title>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#">Gestion Administrativa ES</a>
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
        <h1 class="text-center">ADMINISTRAR USUARIOS</h1>
        <div class="row p-4">
            <h2 class="text">Usuarios</h1>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr class="bg-primary">
                            <th class="text-light" scope="col">Nick</th>
                            <th class="text-light" scope="col">Contraseña</th>
                            <th class="text-light" scope="col">Direcciones</th>
                            <th class="text-light" scope="col">Productos</th>
                            <th class="text-light" scope="col">Carrito</th>
                            <th class="text-light" scope="col">Modificar</th>
                            <th class="text-light" scope="col">Eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Mark</td>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>Otto</td>
                            <td>Mark</td>
                            <td><button type="submit" class="btn btn-warning">Modificar</button></td>
                            <td><button type="submit" class="btn btn-danger">Eliminar</button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="container-fluid">
                    <h2 class="text">Nuevo Usuario</h1>
                    <form action="" method="post">
                        <div class="row">
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Nombre</label>
                                    <input type="text" class="form-control" name="txtNombre" placeholder="Nombre">
                                </div> 
                            </div>
                            <div class="col-sm-12 col-md-6">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Contraseña</label>
                                    <input type="password" class="form-control" name="txtContraseña" placeholder="Contraseña">
                                </div>
                            </div>
                        </div>
                    </form>
                    <button type="submit" class="btn btn-primary btn-block">Crear Usuario</button>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="container-fluid">
                    <h2 class="text">Modificar Usuario</h1>
                    <small class="form-text text-muted">Seleccionar modificar en la tabla para cargar los datos del usuario.</small>
                    <label hidden=true></label>
                    <div class="row">
                        <div class="col-sm-12 col-md-6">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Nombre</label>
                                <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nombre">
                            </div> 
                        </div>
                        <div class="col-sm-12 col-md-6">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Contraseña</label>
                                <input type="password" class="form-control" id="exampleInputEmail1" placeholder="Contraseña">
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Modificar Usuario</button>
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
