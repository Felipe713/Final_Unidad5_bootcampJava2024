package com.edutecno.FinalUnidad5.servlets;

import com.edutecno.FinalUnidad5.dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EliminarCuentaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        UsuarioDAO dao = new UsuarioDAO();

        if (dao.eliminar(username)) {
            request.setAttribute("message", "Cuenta eliminada exitosamente.");
        } else {
            request.setAttribute("message", "Error al eliminar la cuenta.");
        }

        request.getRequestDispatcher("message.jsp").forward(request, response);
    }
}
