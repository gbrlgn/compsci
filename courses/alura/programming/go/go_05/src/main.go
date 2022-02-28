package main

import "github.com/gin-gonic/gin"

func ExibirAlunos(c *gin.Context) {
	c.JSON(200, gin.H{
		"id":   "1",
		"nome": "Gabriel Gian",
	})
}

func main() {
	r := gin.Default()

	r.GET("/alunos", ExibirAlunos)

	r.Run(":8080")
}
