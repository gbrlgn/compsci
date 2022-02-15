package main

import (
	"fmt"
	"time"
)

func Four(array []int) {

	// criar canal para uso como buffer
	canal := make(chan int)

	// capturar tempo de início
	inicio := time.Now().UnixNano()

	// dividir os elementos do array em quatro partes
	pt1 := array[:len(array)/8]
	pt2 := array[len(array)/8 : len(array)/4]
	pt3 := array[len(array)/4 : len(array)/2]
	pt4 := array[len(array)/2:]

	// efetuar a soma das quatro partes em quatro threads
	go Somar(pt1, canal)
	go Somar(pt2, canal)
	go Somar(pt3, canal)
	go Somar(pt4, canal)

	// receber resultados do canal
	w, x, y, z := <-canal, <-canal, <-canal, <-canal

	// dividir a soma dos elementos pelo número de elementos
	med := Media(w+x+y+z, 100000000)

	// capturar tempo de conclusão
	fim := time.Now().UnixNano()

	// calcular duração da operação
	duracao := fim - inicio

	fmt.Printf("Soma dos elementos = %v\nMédia dos elementos = %v", x+y, med)
	fmt.Printf("Tempo gasto: %vs", duracao)
}
