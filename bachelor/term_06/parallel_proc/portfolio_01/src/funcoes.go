package main

import (
	"fmt"
	"math/rand"
	"time"
)

func IniArray(arr []int) {
    
	fmt.Println("Inicializando array...")
	for i := 0; i < len(arr); i++ {

		// inicializar array com números aleatórios de 1 a 10
		// por meio de uma função que captura o horário atual
		// do computador e o formata em relação à Unix Epoch
		rand.Seed(time.Now().UnixNano())
		arr[i] = rand.Intn(10) + 1
		fmt.Printf("Elemento %d:	%d\n", i, arr[i])

	}
}

func Somar(arr []int, canal chan int) {

	fmt.Println("Somando elementos...")

	soma := 0
	for i, v := range arr {

		soma += v
		fmt.Printf("%d + %d = %d\n", arr[i], v, soma)

	}
	canal <- soma // enviar soma para o canal
}

func Media(soma int, divisor int) int {

	return soma / divisor

}
