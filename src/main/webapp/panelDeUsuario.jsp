<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de Usuario</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Horóscopo Chino</h1>
        <a href="logout.jsp">Logout</a>
    </header>
    <div class="dashboard-container">
        <h2>¿Qué deseas hacer, <%= session.getAttribute("nombre") != null ? session.getAttribute("nombre") : "Usuario" %>?</h2>
        <div class="panel-buttons">
            <a href="ConsultaZodiacoServlet" class="button">Conoce tu animal</a>
            <a href="buscarUsuarios.jsp" class="button">Buscar usuarios</a>
            <a href="modificarDatos.jsp?username=<%= session.getAttribute("username") %>" class="button">Modificar datos</a>
            <a href="eliminarCuenta.jsp" class="button">Eliminar cuenta</a>
        </div>
    </div>
</body>
</html>
