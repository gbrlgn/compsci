package routes

import (
	"alura/go-rest-api/controllers"
	"log"
	"net/http"
)

func HandleRequest() {
	http.HandleFunc("/", controllers.Home)
	http.HandleFunc("/api/personalidades", controllers.Personalidades)
	log.Fatal(http.ListenAndServe(":8000", nil))
}
