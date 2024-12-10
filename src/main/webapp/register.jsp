<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Regístrate</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Horóscopo Chino</h1>
        <a href="login.jsp" class="back-button">Volver</a>
    </header>

    <div class="register-container">
        <h2>Regístrate</h2>
        <form action="RegisterServlet" method="post">
            <input type="text" id="name" name="name" placeholder="Nombre" required>

            <input type="email" id="email" name="email" placeholder="Correo electrónico" required>

            <input type="text" id="username" name="username" placeholder="Nombre de usuario" autocomplete="off" required>

            <input type="date" id="birthdate" name="birthdate" required>

            <input type="password" id="password" name="password" placeholder="Contraseña" required>

            <input type="password" id="confirm_password" name="confirm_password" placeholder="Repetir contraseña" required>

            <button type="submit">Registrarse</button>
        </form>
    </div>
</body>
</html>
