<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Consulta Zodiaco</title>
	<link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h1>Consulta tu Animal del Horóscopo Chino</h1>
    <form action="ConsultaZodiacoServlet" method="post">
        <label for="fechaNacimiento">Fecha de Nacimiento:</label>
        <input type="date" id="fechaNacimiento" name="fechaNacimiento" required>
        <button type="submit">Consultar</button>
    </form>
</body>
</html>
