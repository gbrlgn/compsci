package main

import (
	"fmt"

	"../clientes"
	"../contas"
)

func main() {
	/* Instanciação aninhada
	contaDoBruno := c.ContaCorrente{
		Titular: clientes.Titular{
			Nome: "Bruno",
			CPF: "123.111.123-12",
			Profissao: "Desenvolvedor",
		},
		NumeroAgencia: 123,
		NumeroConta: 321,
		Saldo: 100
	}
	*/

	clienteBruno := clientes.Titular{"Bruno", "123.111.123-12", "Desenvolvedor"}
	contaDoBruno := contas.ContaCorrente{clienteBruno, 123, 123456, 100}

	fmt.Println(contaDoBruno)
}
