package main

import (
	"io/ioutil"
	"net/http"
	"net/http/httptest"
	"testing"

	"github.com/gin-gonic/gin"
	"github.com/guilhermeonrails/api-go-gin/controllers"
	"github.com/guilhermeonrails/api-go-gin/database"
	"github.com/guilhermeonrails/api-go-gin/models"
	"github.com/stretchr/testify/assert"
)

func SetupRotasDeTeste() *gin.Engine {
	gin.SetMode(gin.ReleaseMode)
	rotas := gin.Default()
	return rotas
}

func TestFalhador(t *testing.T) {
	t.Fatalf("Teste falhou de propósito.")
}

func CriarAlunoMock() {
	aluno := models.Aluno{
		Nome: "Nome teste", CPF: "12345678910",
		RG: "123456789",
	}
	database.DB.Create(&aluno)
	ID := int(aluno.ID)
}

func DeletarAlunoMock() {
	var aluno models.Aluno
	database.DB.Delete(&aluno, ID)
}
func TestVerificaStatusCodeSaudar(t *testing.T) {
	r := SetupRotasDeTeste()
	r.GET("/:nome", controllers.Saudar)
	req, _ := http.NewRequest("GET", "/gabriel", nil)
	resp := httptest.NewRecorder()

	r.ServeHTTP(resp, req)
	assert.Equal(t, http.StatusOK, resp.Code, "Deveriam ser iguais.")

	mockResp := `{"API diz":"E aí gabriel, tudo bem?"}`
	respBody, _ := ioutil.ReadAll(resp.Body)

	assert.Equal(t, mockResp, string(respBody))
}

func TestListarTodosAlunos(t *testing.T) {
	database.ConectaComBancoDeDados()
	CriarAlunoMock()
	defer DeletarAlunoMock()
	r := SetupRotasDeTeste()
	r.GET("/alunos", controllers.ExibirTodosAlunos)
	req, _ := http.NewRequest("GET", "/alunos", nil)
	resp := httptest.NewRecorder()

	r.ServeHTTP(resp, req)
	assert.Equal(t, http.StatusOK, resp.Code)
}

func TesteBuscarAlunoPorCPF(t *testing.T) {
	database.ConectaComBancoDeDados()
	CriarAlunoMock()
	defer DeletarAlunoMock()

	r := SetupRotasDeTeste()
	r.GET("/alunos/cpf/:cpf", controllers.BuscarAlunoPorCPF)
	req, _ := http.NewRequest("GET", "/alunos/cpf/12345678910", nil)
	resp := httptest.NewRecorder()

	r.ServeHTTP(resp, req)
	assert.Equal(t, http.StatusOK, resp.Code)
}
