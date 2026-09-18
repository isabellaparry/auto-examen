package cl.iplacex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepository {

    private final String url;

    public UsuarioRepository(String url) {
        this.url = url;
    }

    public void crearTabla() throws SQLException {

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS usuarios (" +
                     "correo VARCHAR(100), password VARCHAR(100))")) {

            statement.execute();
        }
    }

    public void guardar(String correo, String password) throws SQLException {

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO usuarios(correo, password) VALUES (?, ?)")) {

            statement.setString(1, correo);
            statement.setString(2, password);

            statement.executeUpdate();
        }
    }

    public boolean existe(String correo, String password) throws SQLException {

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT COUNT(*) FROM usuarios WHERE correo = ? AND password = ?")) {

            statement.setString(1, correo);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            result.next();

            return result.getInt(1) > 0;
        }
    }
}