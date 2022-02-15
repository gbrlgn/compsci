package br.com.alura.loja;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.Pedido;
import br.com.alura.loja.pedido.acao.EnviaEmailPedido;
import br.com.alura.loja.pedido.acao.SalvaPedidoDB;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TestesPedidos {
    public static void main(String[] args) {
        String cliente = args[0];
        BigDecimal valorOrcamento = new BigDecimal(args[1]);
        int quantItens = Integer.parseInt(args[2]);

        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantItens);
        GeraPedidoHandler handler = new GeraPedidoHandler(
                Arrays.asList(new SalvaPedidoDB(), new EnviaEmailPedido())
        );
        handler.executa(gerador);
    }
}
