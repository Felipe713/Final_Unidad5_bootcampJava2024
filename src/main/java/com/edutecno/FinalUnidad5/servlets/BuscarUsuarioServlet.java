package com.edutecno.FinalUnidad5.servlets;

import com.edutecno.FinalUnidad5.dao.UsuarioDAO;
import com.edutecno.FinalUnidad5.models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BuscarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.buscar(username);

        if (usuario != null) {
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("resultadoBusqueda.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Usuario no existe, debe registrarse.");
            request.getRequestDispatcher("message.jsp").forward(request, response);
        }
    }
}
