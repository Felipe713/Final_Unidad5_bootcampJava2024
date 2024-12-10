<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar sesi�n</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Hor�scopo Chino</h1>
    </header>

    <div class="login-container">
        <form action="LoginServlet" method="post">
            <input type="text" id="username" name="username" placeholder="Nombre de usuario" required>
            <input type="password" id="password" name="password" placeholder="Contrase�a" required>
            <button type="submit">Iniciar sesi�n</button>
        </form>

        <a href="register.jsp" class="signup-link">�No tienes una cuenta? Reg�strate aqu�</a>
    </div>

    <%
        String status = request.getParameter("status");
        if ("registroExitoso".equals(status)) {
    %>
        <script>
            alert("Registro exitoso. Por favor, inicia sesi�n.");
        </script>
    <%
        } else if ("error".equals(status)) {
    %>
        <script>
            alert("Contrase�a incorrecta. Por favor, int�ntalo de nuevo.");
        </script>
    <%
        }
    %>
</body>
</html>
