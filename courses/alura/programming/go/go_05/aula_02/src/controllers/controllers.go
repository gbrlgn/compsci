package controllers

import (
	"aluracursos/gin-api-rest/database"
	"aluracursos/gin-api-rest/models"
	"net/http"

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

func CriarAluno(c *gin.Context) {
	var aluno models.Aluno
	if err := c.ShouldBindJSON(&aluno); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{
			"error": err.Error()})
		return
	}

	database.DB.Create(&aluno)
	c.JSON(http.StatusOK, aluno)
}
