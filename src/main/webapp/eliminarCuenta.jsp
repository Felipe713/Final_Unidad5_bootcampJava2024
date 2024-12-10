<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Eliminar Cuenta</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Horóscopo Chino</h1>
        <a href="logout.jsp">Logout</a>
    </header>

    <div class="delete-account-container">
        <h1>Eliminar Cuenta de Usuario</h1>
        <form action="EliminarCuentaServlet" method="post">
            <input type="text" name="username" id="username" placeholder="Nombre de usuario" required>
            <button type="submit">Eliminar Cuenta</button>
        </form>
        <a href="panelDeUsuario.jsp" class="button">Volver al panel de usuario</a>
    </div>
</body>
</html>
