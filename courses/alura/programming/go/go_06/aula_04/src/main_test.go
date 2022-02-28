package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"net/http/httptest"
	"strconv"
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

func CriarAlunoMock() int {
	aluno := models.Aluno{
		Nome: "Nome teste", CPF: "12345678910",
		RG: "123456789",
	}
	database.DB.Create(&aluno)
	ID := int(aluno.ID)
	return ID
}

func DeletarAlunoMock(ID int) {
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
	ID := CriarAlunoMock()
	defer DeletarAlunoMock(ID)
	r := SetupRotasDeTeste()
	r.GET("/alunos", controllers.ExibirTodosAlunos)
	req, _ := http.NewRequest("GET", "/alunos", nil)
	resp := httptest.NewRecorder()

	r.ServeHTTP(resp, req)
	assert.Equal(t, http.StatusOK, resp.Code)
}

func TestBuscarAlunoPorCPF(t *testing.T) {
	database.ConectaComBancoDeDados()
	ID := CriarAlunoMock()
	defer DeletarAlunoMock(ID)

	r := SetupRotasDeTeste()
	r.GET("/alunos/cpf/:cpf", controllers.BuscarAlunoPorCPF)
	req, _ := http.NewRequest("GET", "/alunos/cpf/12345678910", nil)
	resp := httptest.NewRecorder()

	r.ServeHTTP(resp, req)
	assert.Equal(t, http.StatusOK, resp.Code)
}

func TestBuscarAlunoPorID(t *testing.T) {
	database.ConectaComBancoDeDados()
	ID := CriarAlunoMock()
	defer DeletarAlunoMock(ID)

	r := SetupRotasDeTeste()
	r.GET("/alunos/id/:id", controllers.BuscarAlunoPorCPF)
	path := "/alunos/" + strconv.Itoa(ID)

	req, _ := http.NewRequest("GET", path, nil)
	resp := httptest.NewRecorder()

	r.ServeHTTP(resp, req)

	var alunoMock models.Aluno
	json.Unmarshal(resp.Body.Bytes(), &alunoMock)
	fmt.Println(alunoMock.Nome)

	assert.Equal(t, "Nome teste", alunoMock.Nome)
	assert.Equal(t, "12345678910", alunoMock.CPF)
	assert.Equal(t, "123456789", alunoMock.RG)
	assert.Equal(t, http.StatusOK, resp.Code)
}

func TestDeletarAluno(t *testing.T) {
	database.ConectaComBancoDeDados()
	ID := CriarAlunoMock()

	r := SetupRotasDeTeste()
	r.DELETE("/alunos/:id", controllers.DeletarAluno)
	path := "/alunos/" + strconv.Itoa(ID)

	req, _ := http.NewRequest("GET", path, nil)
	resp := httptest.NewRecorder()

	r.ServeHTTP(resp, req)

	assert.Equal(t, http.StatusOK, resp.Code)
}

func TestEditarAluno(t *testing.T) {
	database.ConectaComBancoDeDados()
	ID := CriarAlunoMock()
	defer DeletarAlunoMock(ID)

	r := SetupRotasDeTeste()
	r.PATCH("/alunos/:id", controllers.EditarAluno)
	aluno := models.Aluno{
		Nome: "Nome teste", CPF: "12345678911",
		RG: "123456700",
	}
	valorJSON, _ := json.Marshal(aluno)
	path := "/alunos/" + strconv.Itoa(ID)

	req, _ := http.NewRequest("PATCH", path, bytes.NewBuffer(valorJSON))
	resp := httptest.NewRecorder()

	r.ServeHTTP(resp, req)

	var alunoMockAtualizado models.Aluno
	json.Unmarshal(resp.Body.Bytes(), &alunoMockAtualizado)

	assert.Equal(t, "Nome teste", alunoMockAtualizado.Nome)
	assert.Equal(t, "12345678911", alunoMockAtualizado.CPF)
	assert.Equal(t, "123456700", alunoMockAtualizado.RG)
}
