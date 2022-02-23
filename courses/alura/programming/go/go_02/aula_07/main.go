package main

import (
	"fmt"

	"../contas"
)

func main() {
	contaDoDenis := contas.ContaPoupanca{}
	contaDoDenis.Depositar(100)

	fmt.Println(contaDoDenis.ObterSaldo())
}
