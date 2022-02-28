package routes

import (
	"aluracursos/gin-api-rest/controllers"

	"github.com/gin-gonic/gin"
)

func HandleRequests() {
	r := gin.Default()
	r.GET("/alunos", controllers.ExibirAlunos)
	r.GET("/:nome", controllers.Saudar)
	r.POST("/alunos", controllers.CriarAluno)
	r.GET("/alunos/:id", controllers.BuscarAlunoPorID)
	r.Run(":8080")
}
