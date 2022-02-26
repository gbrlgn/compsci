package main

import (
	"alura/go-rest-api/routes"
	"fmt"
)

func main() {
	fmt.Println("Iniciando o servidor REST")
	routes.HandleRequest()
}
