<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado de Búsqueda</title>
  	<link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Resultado de Búsqueda</h1>
    </header>
    <div class="container">
        <%
            com.edutecno.FinalUnidad5.models.Usuario usuario = (com.edutecno.FinalUnidad5.models.Usuario) request.getAttribute("usuario");
            String mensaje = (String) request.getAttribute("mensaje");
            if (usuario != null) {
        %>
            <h2>Datos del Usuario</h2>
            <p><strong>Nombre:</strong> <%= usuario.getNombre() %></p>
            <p><strong>Email:</strong> <%= usuario.getEmail() %></p>
            <p><strong>Username:</strong> <%= usuario.getUsername() %></p>
            <p><strong>Fecha de Nacimiento:</strong> <%= usuario.getFechaNacimiento() %></p>
        <%
            } else {
        %>
            <h2><%= mensaje %></h2>
        <%
            }
        %>
        <div class="back">
            <a href="buscarUsuarios.jsp">Realizar otra búsqueda</a>
        </div>
    </div>
</body>
</html>
