<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Modificar Datos</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Horóscopo Chino</h1>
        <a href="logout.jsp">Logout</a>
    </header>

    <div class="modificar-container">
        <h1>Modificar Datos del Usuario</h1>
        <form action="ModificarDatosServlet" method="post">
            <input type="text" name="username" id="username" value="<%= request.getParameter("username") %>" readonly placeholder="Nombre de usuario">
            <input type="email" name="email" id="email" required placeholder="Correo Electrónico">
            <input type="password" name="password" id="password" required placeholder="Contraseña">
            <button type="submit">Modificar</button>
        </form>
        <a href="panelDeUsuario.jsp" class="button">Volver al panel de usuario</a>
    </div>
</body>
</html>
