package main

import (
	"io/ioutil"
	"net/http"
	"net/http/httptest"
	"testing"

	"github.com/gin-gonic/gin"
	"github.com/guilhermeonrails/api-go-gin/controllers"
	"github.com/stretchr/testify/assert"
)

func SetupRotasDeTeste() *gin.Engine {
	rotas := gin.Default()
	return rotas
}

func TestFalhador(t *testing.T) {
	t.Fatalf("Teste falhou de propósito.")
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
