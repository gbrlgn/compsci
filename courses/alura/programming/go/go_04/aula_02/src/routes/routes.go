package routes

import (
	"alura/go-rest-api/controllers"
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

func HandleRequest() {
	r := mux.NewRouter()

	r.HandleFunc("/", controllers.Home)
	r.HandleFunc("/api/personalidades", controllers.Personalidades).Methods("Get")
	r.HandleFunc("/api/personalidades/{id}", controllers.RetornarPersonalidade).Methods("Get")

	log.Fatal(http.ListenAndServe(":8000", r))
}
