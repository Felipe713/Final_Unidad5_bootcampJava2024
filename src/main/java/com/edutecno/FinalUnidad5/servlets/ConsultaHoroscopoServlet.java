package com.edutecno.FinalUnidad5.servlets;

import com.edutecno.FinalUnidad5.dao.HoroscopoDAO;
import com.edutecno.FinalUnidad5.models.Horoscopo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ConsultaHoroscopoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // Arreglo del serialVersionUID

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Crear instancia del DAO
        HoroscopoDAO dao = new HoroscopoDAO();

        // Obtener la lista de horóscopos desde la base de datos
        List<Horoscopo> horoscopos = dao.obtenerHoroscopos();

        // Verificar que la lista no esté vacía
        if (horoscopos != null && !horoscopos.isEmpty()) {
            System.out.println("Horóscopos obtenidos en el Servlet: " + horoscopos);
        } else {
            System.out.println("No se obtuvieron horóscopos en el Servlet.");
        }

        // Enviar la lista como atributo a la página JSP
        request.setAttribute("horoscopos", horoscopos);

        // Redirigir a resultado.jsp
        request.getRequestDispatcher("/resultado.jsp").forward(request, response);
    }

}
