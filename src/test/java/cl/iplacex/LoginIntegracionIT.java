package cl.iplacex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LoginIntegrationIT {

    @Test
    void usuarioRegistradoDebePoderIngresar() throws Exception {

        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";

        UsuarioRepository repository =
                new UsuarioRepository(url);

        repository.crearTabla();

        repository.guardar(
                "usuario@test.cl",
                "1234"
        );

        LoginService loginService =
                new LoginService(repository);

        boolean resultado =
                loginService.autenticar(
                        "usuario@test.cl",
                        "1234"
                );

        assertTrue(resultado);
    }

    @Test
    void passwordIncorrectoDebeSerRechazado() throws Exception {

        String url = "jdbc:h2:mem:testdb2;DB_CLOSE_DELAY=-1";

        UsuarioRepository repository =
                new UsuarioRepository(url);

        repository.crearTabla();

        repository.guardar(
                "usuario@test.cl",
                "1234"
        );

        LoginService loginService =
                new LoginService(repository);

        boolean resultado =
                loginService.autenticar(
                        "usuario@test.cl",
                        "incorrecta"
                );

        assertFalse(resultado);
    }
}