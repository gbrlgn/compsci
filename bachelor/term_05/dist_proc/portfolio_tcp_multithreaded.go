package main

// Importar pacotes necessários para conexões de rede.
import (
	"fmt"
	"net"
	"os"
)

// Declaração de constantes de conexão.
const (
	CONN_HOST = ""
	CONN_PORT = "3333"
	CONN_TYPE = "tcp"
)

func main() {
	// Escutar conexões.
	l, erro := net.Listen(CONN_TYPE, CONN_HOST+":"+CONN_PORT)
	if erro != nil {
		fmt.Println("Erro de conexão:", erro.Error())
		os.Exit(1)
	}

	// Fechar o mecanismo de escuta quando a aplicação
	// for fechada.
	defer l.Close()
	fmt.Println("Escutando" + CONN_HOST + ":" + CONN_PORT)
	for {
		// Escutar conexões de clientes.
		con, erro := l.Accept()
		if erro != nil {
			fmt.Println("Erro ao aceitar: ", erro.Error())
			os.Exit(1)
		}
		// Tratar conexões em uma goroutine,
		// ou seja, em múltiplas threads.
		go handleRequest(con)
	}
}

// Tratamento de requisições.
func handleRequest(con net.Conn) {
	// Criar um buffer para armazenar dados de entrada.
	buffer := make([]byte, 1024)
	// Ler a conexão de entrada e transferir ao buffer.
	_, erro := con.Read(buffer)

	if erro != nil {
		fmt.Println("Erro de leitura:", erro.Error())
	}

	fmt.Println(con.RemoteAddr())
	// Enviar uma resposta ao cliente.
	con.Write([]byte("Mensagem recebida."))
	// Fechar a conexão no final da execução da aplicação.
	con.Close()
}
