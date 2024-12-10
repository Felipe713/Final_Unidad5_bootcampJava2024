<%@ page import="com.edutecno.FinalUnidad5.models.Horoscopo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultados del Horóscopo</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<h1>Resultados del Horóscopo</h1>
<table border="1">
    <thead>
    <tr>
        <th>Animal</th>
        <th>Fecha Inicio</th>
        <th>Fecha Fin</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Horoscopo> horoscopos = (List<Horoscopo>) request.getAttribute("horoscopos");
        if (horoscopos != null && !horoscopos.isEmpty()) {
            for (Horoscopo horoscopo : horoscopos) {
    %>
    <tr>
        <td><%= horoscopo.getAnimal() %></td>
        <td><%= horoscopo.getFechaInicio() %></td>
        <td><%= horoscopo.getFechaFin() %></td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="3">No hay datos disponibles</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>

