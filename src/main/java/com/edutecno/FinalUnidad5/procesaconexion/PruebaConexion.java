package com.edutecno.FinalUnidad5.procesaconexion; 

import java.sql.Connection;

public class PruebaConexion {
    public static void main(String[] args) {
        Connection conexion = ConexionDB.getConexion(); // Llamada al método getConexion de ConexionDB
        if (conexion != null) {
            System.out.println("Conexión exitosa.");
        } else {
            System.out.println("Conexión fallida.");
        }
    }
}
