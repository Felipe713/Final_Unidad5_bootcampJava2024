package com.edutecno.FinalUnidad5.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.edutecno.FinalUnidad5.dao.UsuarioDAO;
import com.edutecno.FinalUnidad5.models.Usuario;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.autenticar(username, password);

        // Validación del usuario
        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", usuario.getUsername());
            session.setAttribute("nombre", usuario.getNombre());
            session.setAttribute("fechaNacimiento", usuario.getFechaNacimiento());
            response.sendRedirect("panelDeUsuario.jsp");
        } else {
            // Mensaje de error y redirección al login
            response.sendRedirect("login.jsp?status=error");
        }
    }
}
