package main

import (
	"fmt"
	"strings"
)

func main() {

	// declarar array a ser inicializado
	var array [100000000]int
	ini := false

Comando:

	fmt.Println("Selecione o tipo de teste: \n(1) Monothreaded\n(2) Two-threaded\n(3) Four-threaded\n\n(X) Cancelar")

	var comando string
	fmt.Scanln(&comando)

	comando = strings.ToUpper(comando)

	if !ini {

		// inicializar array
		IniArray(array[:])
		ini = true

	}

	switch comando {

	case "X":
		goto Sair

	case "1":
		Mono(array[:])
		goto Comando

	case "2":
		Two(array[:])
		goto Comando

	case "3":
		Four(array[:])
		goto Comando

	default:
		println("\nComando incorreto.\n")
		goto Comando

	}

Sair:
	return

}
