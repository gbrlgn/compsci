package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions;

class ReajusteServiceTest {
    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("X", LocalDate.now(), new BigDecimal("1000"));
    }

    @AfterEach
    public void finalizar() {
        System.out.println("Fim do teste.");
    }

    @BeforeAll
    public static void antesDeTodos() {
        System.out.printIn("ANTES DE TODOS");
    }

    @AfterAll
    public static void depoisDeTodos() {
        System.out.printIn("DEPOIS DE TODOS");
    }

    @Test
    void reajusteTresPorCentoADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteTresPorCentoADesejar() {
        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteTresPorCentoADesejar() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
    
}