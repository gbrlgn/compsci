package models

import "src/db"

type Produto struct {
	Id, Quantidade  int
	Nome, Descricao string
	Preco           float64
}

func BuscaTodosProdutos() []Produto {
	db := db.ConectaBD()

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

	defer db.Close()
	return produtos
}

func CriarProduto(nome, descricao string, preco float64, quantidade int) {
	db := db.ConectaBD()

	inserirDados, err := db.Prepare("INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ($1, $2, $3, $4)")
	if err != nil {
		panic(err.Error())
	}

	inserirDados.Exec(nome, descricao, preco, quantidade)
	defer db.Close()
}

func DeletarProduto(id string) {
	db := db.ConectaBD()

	deletarDados, err := db.Prepare("DELETE FROM produtos WHERE id=$1")
	if err != nil {
		panic(err.Error())
	}

	deletarDados.Exec(id)
	defer db.Close()
}
