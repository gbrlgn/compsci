package main

import (
	"aluracursos/gin-api-rest/database"
	"aluracursos/gin-api-rest/routes"
)

func main() {
	database.ConectarDB()
	routes.HandleRequests()
}
