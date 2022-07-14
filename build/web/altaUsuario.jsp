<%-- 
    Document   : altaUsuario6
    Created on : Jul 11, 2022, 9:45:58 PM
    Author     : jimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% 
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
        %>
    </head>
    <body>
        <div class="form-container" id="form">
            <form class="m-auto py-5" id="formularioAlta" method="post" action="GuardarServlet">
                <div class="text-center">
                    <h1>Registro de usuarios</h1>
                    <span>Ingrese los siguientes datos</span>
                </div>
                <div class="row m-auto mt-3">
                    <div class="col">
                      <input type="text" class="form-control" placeholder="DNI" aria-label="DNI" id="txtDni" required name="txtDni">
                    </div>
                    <div class="col">
                      <input type="text" class="form-control" placeholder="Nombre" aria-label="Name" id="txtNombre" required onkeyup="usuarioAutomatico()" name="txtNombre">
                    </div>
                    <div class="col">
                      <input type="text" class="form-control" placeholder="Apellidos" aria-label="Last name" id="txtApellidos" required onkeyup="usuarioAutomatico()" name="txtApellidos">
                    </div>
                </div>
                <div class="row m-auto mt-3">
                    <div class="col">
                        <label for="password">Contaseña</label>
                        <input type="password" class="form-control" placeholder="Contraseña" aria-label="password"id="txtContrasena" required onkeyup="verificaConstrasena()">
                    </div>
                    <div class="col">
                        <label for="correo">Confirma Contraseña</label>
                        <input type="password" class="form-control" placeholder="Confirma contraseña" aria-label="password" id="txtConfirmaContrasena" required onkeyup="verificaConstrasena()" name="txtContrasena">
                    </div>
                </div>
                <div class="row m-auto mt-3">
                    <div class="col">
                        <label for="usuarioAutomatico">Usuario generado:</label>
                        <input type="text" class="form-control" aria-label="usuarioAutomatico" id="txtUsuarioAutomatico" required  readonly="true" name="txtUsuarioAutomatico">
                    </div>
                </div>
                <div class="row m-auto mt-4">
                    <div>
                        <div class="alert alert-primary" role="alert">
                            Todos los campos son requeridos
                        </div>
                        <div style="display:inline-flex; width: 100%;">
                            <input type="submit" value="Crear Usuario" class="form-btn me-2" style="width: 50%" id="btnEnviarDatos" disabled>
                            <input type="reset" value="Borrar Datos" class="form-btn" style="width: 50%"id="btnBorrarDatos" onclick="vaciaFormulario()">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
    <script src="js/funcionesAltaUsuario.js"></script>
</html>
