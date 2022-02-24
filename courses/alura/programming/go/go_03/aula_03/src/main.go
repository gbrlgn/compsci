package main

import (
	"crypto/md5"
	"database/sql"
	"encoding/hex"
	"html/template"
	"net/http"

	_ "github.com/lib/pq"
)

type Produto struct {
	Id, Quantidade  int
	Nome, Descricao string
	Preco           float64
}

var tmpl = template.Must(template.ParseGlob("templates/*.html"))

func conectaBD() *sql.DB {
	pass := md5.Sum([]byte("admin"))
	hash := hex.EncodeToString(pass[:])

	conexao := "user=admin dbname=alura password=" + hash + " host=localhost sslmode=disable"

	db, err := sql.Open("postgres", conexao)
	if err != nil {
		panic(err.Error())
	}

	return db
}

func index(w http.ResponseWriter, r *http.Request) {
	db := conectaBD()

	selectTudo, err := db.Query("SELECT * FROM produtos")
	if err != nil {
		panic(err.Error())
	}

	p := Produto{}
	produtos := []Produto{}

	for selectTudo.Next() {
		var id, quantidade int
		var nome, descricao string
		var preco float64

		err := selectTudo.Scan(&id, &nome, &descricao, &preco, &quantidade)
		if err != nil {
			panic(err.Error())
		}

		p.Id, p.Nome, p.Descricao, p.Preco, p.Quantidade = id, nome, descricao, preco, quantidade

		produtos = append(produtos, p)
	}

	tmpl.ExecuteTemplate(w, "Index", produtos)
	defer db.Close()
}

func main() {
	http.HandleFunc("/", index)
	http.ListenAndServe(":8000", nil)
}
