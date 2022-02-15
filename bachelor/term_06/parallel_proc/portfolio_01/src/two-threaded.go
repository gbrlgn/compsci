package main

import (
	"fmt"
	"time"
)

func Two(array []int) {

	// criar canal para uso como buffer
	canal := make(chan int)

	// capturar tempo de início
	inicio := time.Now().UnixNano()

	// efetuar a soma dos elementos em duas metades e duas threads
	go Somar(array[:len(array)/2], canal)
	go Somar(array[len(array)/2:], canal)

	// receber resultados do canal
	x, y := <-canal, <-canal

	// dividir a soma dos elementos pelo número de elementos
	med := Media(x+y, 100000000)

	// capturar tempo de conclusão
	fim := time.Now().UnixNano()

	// calcular duração da operação
	duracao := fim - inicio

	fmt.Printf("Soma dos elementos = %v\nMédia dos elementos = %v", x+y, med)
	fmt.Printf("Tempo gasto: %vs", duracao)
}
