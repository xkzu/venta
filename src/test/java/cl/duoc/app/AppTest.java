package cl.duoc.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AppTest {

    @Test
    void testMainMethodRuns() {
        // Verifica que el método main se ejecuta sin excepciones
        assertDoesNotThrow(() -> App.main(new String[]{}), "El método main no debe lanzar excepciones");
    }

}
