package main

import (
	"fmt"

	"../contas"
)

func PagarBoleto(conta VerificarConta, valorDoBoleto float64) {
	conta.Sacar(valorDoBoleto)
}

func main() {
	contaDoDenis := contas.ContaPoupanca{}
	contaDoDenis.Depositar(100)
	PagarBoleto(&contaDoDenis, 60)

	fmt.Println(contaDoDenis.ObterSaldo())

	contaDaLuisa := contas.ContaPoupanca{}
	contaDaLuisa.Depositar(500)
	PagarBoleto(&contaDaLuisa, 200)

	fmt.Println(contaDaLuisa.ObterSaldo())
}
