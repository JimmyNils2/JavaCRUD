<%-- 
    Document   : paginaInicio
    Created on : Jul 13, 2022, 3:46:26 PM
    Author     : jimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% 
            //Borra Cache
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            
            if(session.getAttribute("nombre") == null && session.getAttribute("usuario") == null){
               
                response.sendRedirect("index.html");
            }
        %>
    </head>
    <body>
        <h1>Hola <%= request.getSession().getAttribute("nombre") %>, ¡Bienvenido!</h1>
        <p>Ingresaste como: ${usuario}</p>
        <form action="CerrarSesionServlet">
                <input type="submit" value="Cerrar Sesion" class="btn">      
        </form>
    </body>
</html>
