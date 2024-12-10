package com.edutecno.FinalUnidad5.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.edutecno.FinalUnidad5.dao.UsuarioDAO;

public class CRUDServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        switch (action) {
            case "buscar":
                String username = request.getParameter("username");
                request.setAttribute("usuario", usuarioDAO.buscar(username));
                request.getRequestDispatcher("buscar.jsp").forward(request, response);
                break;
            case "eliminar":
                String eliminarUsername = request.getParameter("username");
                if (usuarioDAO.eliminar(eliminarUsername)) {
                    request.setAttribute("messageTitle", "Cuenta eliminada");
                    request.setAttribute("messageContent", "El usuario fue eliminado exitosamente.");
                } else {
                    request.setAttribute("messageTitle", "Error");
                    request.setAttribute("messageContent", "No se pudo eliminar al usuario.");
                }
                request.getRequestDispatcher("message.jsp").forward(request, response);
                break;
            // Agregar lógica para modificar si es necesario
        }
    }
}
