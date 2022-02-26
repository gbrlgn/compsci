package main

import (
	"alura/go-rest-api/models"
	"alura/go-rest-api/routes"
	"fmt"
)

func main() {
	models.Personalidades = []models.Personalidade{
		{Nome: "Afonso Pena", Historia: "..."},
		{Nome: "Adélia Prado", Historia: "..."},
	}

	fmt.Println("Iniciando o servidor REST")
	routes.HandleRequest()
}
