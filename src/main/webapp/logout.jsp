<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    // Invalidar la sesi�n del usuario
    HttpSession currentSession = request.getSession(false);
    if (currentSession != null) {
        currentSession.invalidate();
    }

    // Redirigir al usuario a la p�gina principal
    response.sendRedirect("login.jsp");
%>
