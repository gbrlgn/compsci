package main

import (
	"fmt"
	"time"
)

func Mono(array []int) {

	// criar canal para uso como buffer
	canal := make(chan int)

	// capturar tempo de início
	inicio := time.Now().UnixNano()

	// efetuar a soma dos elementos em uma thread
	go Somar(array[:], canal)

	// receber resultados do canal
	x := <-canal

	// dividir a soma dos elementos pelo número de elementos
	med := Media(x, 100000000)

	// capturar tempo de conclusão
	fim := time.Now().UnixNano()

	// calcular duração da operação
	duracao := fim - inicio

	fmt.Printf("Soma dos elementos = %v\nMédia dos elementos = %v", x, med)
	fmt.Printf("Tempo gasto: %vs", duracao)
}
