package escola;

import static org.junit.jupiter.api.Assert.*;

class EmailTest {
    @Test
    void naoDeveCriarEmailsComEnderecoInvalido() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Email(null));

        assertThrows(
            IllegalArgumentException.class,
            () -> new Email(""));

        assertThrows(
            IllegalArgumentException.class,
            () -> new Email("Email inválido."));
    }
}