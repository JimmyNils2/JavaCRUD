<%-- 
    Document   : login
    Created on : Jul 11, 2022, 9:46:24 PM
    Author     : jimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% 
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //Borrar directivas de memoria cache
            response.setHeader("Pragma", "no-cache");    //Borra algoritmo generados para borrar cache, borra directivas compatibles con m. cache
            response.setDateHeader("Expires", 0);        //Fecha de expiracion
        %>
    </head>
    <body>
        <div class="form-container" id="form">
            <form class="m-auto py-5" id="formularioLogin" method="post" action="InicioSesionServlet">
                <div class="text-center">
                    <h1>Inicio de sesion</h1>
                </div>
                <div class="row m-auto">
                    <div class="col">
                      <input type="text" class="form-control" placeholder="Nombre" aria-label="First name" id="txtUsuario" required name="txtUsuario">
                    </div>
                    <div class="col">
                      <input type="password" class="form-control" placeholder="Contaseña" aria-label="Password"id="txtContrasena" required name="txtContrasena">
                    </div>
                </div>
                <div class="row m-auto">
                    <div class="col">
                        <input type="submit" value="Inicio Sesion" class="form-btn">
                    </div>
                    <div class="col">
                        <input type="reset" value="Borrar Datos" class="form-btn"> 
                    </div>
                </div>
            </form>
        </div>
    </body>
    <script src="/js/funcionesLogin.js"></script>
</html>
