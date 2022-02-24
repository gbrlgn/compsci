package db

import (
	"crypto/md5"
	"database/sql"
	"encoding/hex"
)

func ConectarBD() *sql.DB {
	pass := md5.Sum([]byte("admin"))
	hash := hex.EncodeToString(pass[:])

	conexao := "user=admin dbname=alura password=" + hash + " host=localhost sslmode=disable"

	db, err := sql.Open("postgres", conexao)
	if err != nil {
		panic(err.Error())
	}

	return db
}
