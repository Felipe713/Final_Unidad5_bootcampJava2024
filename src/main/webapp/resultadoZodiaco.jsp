<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Tu Animal del Horóscopo Chino</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
    <h1>Horóscopo Chino</h1>
    <a href="logout.jsp">Logout</a>
</header>
    
    <div class="container">
    <h2>Tu Animal del Horóscopo Chino</h2>
    <p>Tu animal es: <strong>${signo}</strong></p>
    <a href="panelDeUsuario.jsp" class="button">Volver al panel de usuario</a>
</div>
    
</body>
</html>

