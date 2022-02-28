package main

import (
	"aluracursos/gin-api-rest/models"
	"aluracursos/gin-api-rest/routes"
)

func main() {
	models.Alunos = []models.Aluno{
		{Nome: "Gabriel Gian", CPF: "00000000000", RG: "11111111111"},
		{Nome: "Bianca Magalhães", CPF: "22222222222", RG: "33333333333"},
	}
	routes.HandleRequests()
}
