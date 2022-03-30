package br.com.alura.tdd.modelo;

public enum Desempenho {
    A_DESEJAR {
        @Override
        public abstract BigDecimal percentualReajuste() {
            return new BigDecimal("0.03");
        }
    },
    BOM {
        @Override
        public abstract BigDecimal percentualReajuste() {
            return new BigDecimal("0.15"); 
        }
    },
    OTIMO {
        @Override
        public abstract BigDecimal percentualReajuste() {
            return new BigDecimal("0.2"); 
        }
    };

    public abstract BigDecimal percentualReajuste();
}