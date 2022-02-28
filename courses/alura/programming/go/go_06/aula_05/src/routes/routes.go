package routes

import (
	"github.com/gin-gonic/gin"
	"github.com/guilhermeonrails/api-go-gin/controllers"
)

func HandleRequests() {
	r := gin.Default()
	r.LoadHTMLGlob("templates/*")
	r.Static("/assets", "./assets")
	r.GET("/alunos", controllers.ExibirTodosAlunos)
	r.GET("/:nome", controllers.Saudar)
	r.POST("/alunos", controllers.CriarNovoAluno)
	r.GET("/alunos/:id", controllers.BuscarAlunoPorID)
	r.DELETE("/alunos/:id", controllers.DeletarAluno)
	r.PATCH("/alunos/:id", controllers.EditarAluno)
	r.GET("/alunos/cpf/:cpf", controllers.BuscarAlunoPorCPF)
	r.GET("/index", controllers.ExibirIndex)
	r.NoRoute(controllers.NotFound)
	r.Run()
}
