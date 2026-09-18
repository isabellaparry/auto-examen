package cl.iplacex;

import java.sql.SQLException;

public class LoginService {

    private UsuarioRepository repository;

    public LoginService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public boolean autenticar(String correo, String password)
            throws SQLException {

        if (repository.existe(correo, password)) {
            return true;
        }

        return false;
    }
}