package controllers

import (
	"aluracursos/gin-api-rest/models"

	"github.com/gin-gonic/gin"
)

func ExibirAlunos(c *gin.Context) {
	c.JSON(200, models.Alunos)
}

func Saudar(c *gin.Context) {
	nome := c.Params.ByName("nome")
	c.JSON(200, gin.H{
		"API diz: ": "E aí " + nome + ", tudo beleza?",
	})
}
