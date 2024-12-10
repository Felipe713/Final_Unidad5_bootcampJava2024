package com.edutecno.FinalUnidad5.procesaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/finalunidad5"; // Cambiar si el puerto o base son distintos
    private static final String USER = "postgres"; // Usuario de PostgreSQL
    private static final String PASSWORD = "123456"; // Contraseña de PostgreSQL

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver de PostgreSQL cargado correctamente.");
            // Establecer conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a PostgreSQL exitosa.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver no encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }
}
