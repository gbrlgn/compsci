package database

import (
	"aluracursos/gin-api-rest/models"
	"log"

	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

var (
	DB  *gorm.DB
	err error
)

func ConectarDB() {
	strCon := "host=localhost password=root dbname=root port=5432 sslmode=disable"

	DB, err := gorm.Open(postgres.Open(strCon))
	if err != nil {
		log.Panic("Erro ao conectar ao BD")
	}
	DB.AutoMigrate(&models.Aluno{})
}
