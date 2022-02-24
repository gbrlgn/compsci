package models

import "src/db"

type Produto struct {
	Id, Quantidade  int
	Nome, Descricao string
	Preco           float64
}

func BuscarProdutos() []Produto {
	db := db.ConectarBD()

	selectTudo, err := db.Query("SELECT * FROM produtos ORDER BY id ASC")
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
	db := db.ConectarBD()

	inserirDados, err := db.Prepare("INSERT INTO produtos (nome, descricao, preco, quantidade) VALUES ($1, $2, $3, $4)")
	if err != nil {
		panic(err.Error())
	}

	inserirDados.Exec(nome, descricao, preco, quantidade)
	defer db.Close()
}

func DeletarProduto(id string) {
	db := db.ConectarBD()

	deletarDados, err := db.Prepare("DELETE FROM produtos WHERE id=$1")
	if err != nil {
		panic(err.Error())
	}

	deletarDados.Exec(id)
	defer db.Close()
}

func EditarProduto(id string) Produto {
	db := db.ConectarBD()

	dadosProduto, err := db.Query("SELECT * FROM produtos WHERE id=$1", id)
	if err != nil {
		panic(err.Error())
	}

	p := Produto{}
	for dadosProduto.Next() {
		var id, quantidade int
		var nome, descricao string
		var preco float64

		err := dadosProduto.Scan(&id, &nome, &descricao, &preco, &quantidade)
		if err != nil {
			panic(err.Error())
		}

		p.Id, p.Nome, p.Descricao, p.Preco, p.Quantidade = id, nome, descricao, preco, quantidade
	}

	defer db.Close()
	return p
}

func AtualizarProduto(id, quantidade int, nome, descricao string, preco float64) {
	db := db.ConectarBD()

	atualizarProduto, err := db.Prepare("UPDATE produtos SET quantidade=$2, nome=$3, descricao=$4, preco$5 WHERE id=$1")
	if err != nil {
		panic(err.Error())
	}

	atualizarProduto.Exec(id, quantidade, nome, descricao, preco)
	defer db.Close()
}
