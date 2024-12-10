<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    // Invalidar la sesión del usuario
    HttpSession currentSession = request.getSession(false);
    if (currentSession != null) {
        currentSession.invalidate();
    }

    // Redirigir al usuario a la página principal
    response.sendRedirect("login.jsp");
%>
