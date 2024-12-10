<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar sesión</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Horóscopo Chino</h1>
    </header>

    <div class="login-container">
        <form action="LoginServlet" method="post">
            <input type="text" id="username" name="username" placeholder="Nombre de usuario" required>
            <input type="password" id="password" name="password" placeholder="Contraseña" required>
            <button type="submit">Iniciar sesión</button>
        </form>

        <a href="register.jsp" class="signup-link">¿No tienes una cuenta? Regístrate aquí</a>
    </div>

    <%
        String status = request.getParameter("status");
        if ("registroExitoso".equals(status)) {
    %>
        <script>
            alert("Registro exitoso. Por favor, inicia sesión.");
        </script>
    <%
        } else if ("error".equals(status)) {
    %>
        <script>
            alert("Contraseña incorrecta. Por favor, inténtalo de nuevo.");
        </script>
    <%
        }
    %>
</body>
</html>
