package com.edutecno.FinalUnidad5.servlets;

import com.edutecno.FinalUnidad5.dao.UsuarioDAO;
import com.edutecno.FinalUnidad5.models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModificarDatosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario(null, email, username, null, password);

        if (dao.modificar(usuario)) {
            request.setAttribute("message", "Datos modificados exitosamente.");
        } else {
            request.setAttribute("message", "Hubo un error al modificar los datos.");
        }

        request.getRequestDispatcher("message.jsp").forward(request, response);
    }
}
