<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buscar Usuario</title>
    <link rel="stylesheet" href="css/styles.css"> <!-- Enlace al archivo CSS general -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <header>
        <h1>Horóscopo Chino</h1>
        <a href="logout.jsp">Logout</a>
    </header>

    <div class="buscar-usuario-container">
        <h1>Buscar Usuario</h1>
        <form action="BuscarUsuarioServlet" method="post" class="search-form">
            <div class="search-box">
                <input type="text" id="username" name="username" placeholder="Ingrese el nombre de usuario" required>
                <button type="submit">
                    <i class="fa fa-search"></i>
                </button>
            </div>
        </form>
        <a href="panelDeUsuario.jsp" class="button">Volver al panel de usuario</a>
    </div>
</body>
</html>