package main

import (
	"alura/go-rest-api/models"
	"alura/go-rest-api/routes"
	"fmt"
)

func main() {
	models.Personalidades = []models.Personalidade{
		{Id: 1, Nome: "Afonso Pena", Historia: "..."},
		{Id: 1, Nome: "Adélia Prado", Historia: "..."},
	}

	fmt.Println("Iniciando o servidor REST")
	routes.HandleRequest()
}
