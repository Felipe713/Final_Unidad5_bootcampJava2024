package com.edutecno.FinalUnidad5.servlets;

import com.edutecno.FinalUnidad5.dao.UsuarioDAO;
import com.edutecno.FinalUnidad5.models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String fechaNacimiento = request.getParameter("birthdate");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        if (!password.equals(confirmPassword)) {
            System.out.println("Las contraseñas no coinciden.");
            response.sendRedirect("register.jsp?status=error");
            return;
        }

        Usuario usuario = new Usuario(nombre, email, username, fechaNacimiento, password);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean registrado = usuarioDAO.registrar(usuario);

        if (registrado) {
            System.out.println("Usuario registrado exitosamente.");
            response.sendRedirect("login.jsp?status=registroExitoso");
        } else {
            System.out.println("Error al registrar usuario.");
            response.sendRedirect("register.jsp?status=error");
        }
    }
}
