package com.edutecno.FinalUnidad5.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edutecno.FinalUnidad5.models.Usuario;
import com.edutecno.FinalUnidad5.procesaconexion.ConexionDB;

public class UsuarioDAO {

    // Método para autenticar un usuario
    public Usuario autenticar(String username, String password) {
        String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Usuario(
                    resultSet.getString("nombre"),
                    resultSet.getString("email"),
                    resultSet.getString("username"),
                    resultSet.getString("fecha_nacimiento"),
                    resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para registrar un usuario
    public boolean registrar(Usuario usuario) {
        String query = "INSERT INTO usuarios (nombre, email, username, fecha_nacimiento, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getUsername());

            // Convertir la fecha de nacimiento a java.sql.Date
            Date fechaNacimiento = Date.valueOf(usuario.getFechaNacimiento());
            statement.setDate(4, fechaNacimiento);

            statement.setString(5, usuario.getPassword());

            // Imprimir el query generado (para depuración)
            System.out.println("Query generado: " + statement);

            // Ejecutar la inserción
            int filasAfectadas = statement.executeUpdate();

            // Imprimir la cantidad de filas afectadas
            System.out.println("Filas afectadas: " + filasAfectadas);

            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para buscar un usuario
    public Usuario buscar(String username) {
        String query = "SELECT * FROM usuarios WHERE username = ?";
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Usuario(
                    resultSet.getString("nombre"),
                    resultSet.getString("email"),
                    resultSet.getString("username"),
                    resultSet.getString("fecha_nacimiento"),
                    resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para eliminar un usuario
    public boolean eliminar(String username) {
        String query = "DELETE FROM usuarios WHERE username = ?";
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setString(1, username);

            int filasAfectadas = statement.executeUpdate();
            System.out.println("Filas afectadas en eliminación: " + filasAfectadas);

            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para modificar un usuario
    public boolean modificar(Usuario usuario) {
        String query = "UPDATE usuarios SET email = ?, password = ? WHERE username = ?";
        try (Connection conexion = ConexionDB.getConexion();
             PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getPassword());
            statement.setString(3, usuario.getUsername());

            int filasAfectadas = statement.executeUpdate();
            System.out.println("Filas afectadas en modificación: " + filasAfectadas);

            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
