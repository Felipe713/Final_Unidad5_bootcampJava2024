package com.edutecno.FinalUnidad5.servlets;

import com.edutecno.FinalUnidad5.dao.HoroscopoDAO;
import com.edutecno.FinalUnidad5.models.Horoscopo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

public class ConsultaZodiacoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener la fecha de nacimiento del usuario en sesión
            String fechaNacimientoStr = (String) request.getSession().getAttribute("fechaNacimiento");
            if (fechaNacimientoStr == null) {
                throw new Exception("Fecha de nacimiento no encontrada en la sesión.");
            }

            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);

            // Consultar el signo zodiacal basado en la fecha
            HoroscopoDAO dao = new HoroscopoDAO();
            Horoscopo signo = dao.obtenerHoroscopoPorFecha(fechaNacimiento);

            if (signo != null) {
                request.setAttribute("signo", signo.getAnimal());
            } else {
                request.setAttribute("signo", "No se encontró un signo para la fecha registrada.");
            }

            // Redirigir al JSP de resultado
            request.getRequestDispatcher("resultadoZodiaco.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Ocurrió un error al procesar la consulta.");
            request.getRequestDispatcher("resultadoZodiaco.jsp").forward(request, response);
        }
    }
}
