package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions;

class BonusServiceTest {
    @Test
    void bonusDeveSerZeroSalarioAlto() {
        BonusService service = new BonusService();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.calcularBonus(
                new Funcionario("X", LocalDate.now(), new BigDecimal("25000"))));

     /* try {
            service.calcularBonus(
                new Funcionario("X", LocalDate.now(), new BigDecimal("25000")));
            fail("Não houve exception.");
        } catch (Exception e) {
            assertEquals("Funcionário com salário maior que R$10000,00 não pode receber bônus.", e.getMessage());
        } */
    }

    @Test
    void bonusDeveSerDezPorCentoDoSalario() {
        BonusService service = new BonusService();
        var teste = service.calcularBonus(new Funcionario("X", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), teste);
    }

    @Test
    void bonusDeveSerDezPorCentoSalarioDezMil() {
        BonusService service = new BonusService();
        var teste = service.calcularBonus(new Funcionario("X", LocalDate.now(), new BigDecimal("9000")));

        assertEquals(new BigDecimal("900.00"), teste);
    }
}