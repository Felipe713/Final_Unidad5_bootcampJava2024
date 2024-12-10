package com.edutecno.FinalUnidad5.dao;

import com.edutecno.FinalUnidad5.models.Horoscopo;
import com.edutecno.FinalUnidad5.procesaconexion.ConexionDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HoroscopoDAO {

    // Query para obtener todos los horóscopos
    private static final String QUERY = "SELECT animal, fecha_inicio, fecha_fin FROM horoscopo";

    // Query para obtener el horóscopo por una fecha específica
    private static final String QUERY_POR_FECHA = 
        "SELECT animal, fecha_inicio, fecha_fin FROM horoscopo WHERE ? BETWEEN fecha_inicio AND fecha_fin";

    // Método para obtener todos los horóscopos
    public List<Horoscopo> obtenerHoroscopos() {
        List<Horoscopo> horoscopos = new ArrayList<>();
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement statement = conexion.prepareStatement(QUERY)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String animal = resultSet.getString("animal");
                LocalDate fechaInicio = resultSet.getDate("fecha_inicio").toLocalDate();
                LocalDate fechaFin = resultSet.getDate("fecha_fin").toLocalDate();

                Horoscopo horoscopo = new Horoscopo(animal, fechaInicio, fechaFin);
                horoscopos.add(horoscopo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horoscopos;
    }

    // Método para obtener el signo por una fecha específica
    public Horoscopo obtenerHoroscopoPorFecha(LocalDate fecha) {
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement statement = conexion.prepareStatement(QUERY_POR_FECHA)) {

            // Convertir LocalDate a java.sql.Date y establecer el parámetro
            statement.setDate(1, Date.valueOf(fecha));
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String animal = resultSet.getString("animal");
                LocalDate fechaInicio = resultSet.getDate("fecha_inicio").toLocalDate();
                LocalDate fechaFin = resultSet.getDate("fecha_fin").toLocalDate();

                return new Horoscopo(animal, fechaInicio, fechaFin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retornar null si no se encuentra el horóscopo
    }
}
