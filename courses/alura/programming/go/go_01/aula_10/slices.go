package main

func exibeNomes() {
    nomes := []string{"Douglas", "Daniel", "Bernardo"}
    fmt.Println("O meu slice tem", len(nomes), "itens")
    fmt.Println("O meu slice tem capacidade para", cap(nomes), "itens")

    nomes = append(nomes, "Aparecida")
    fmt.Println("O meu slice tem", len(nomes), "itens")
    fmt.Println("O meu slice tem capacidade para", cap(nomes), "itens")
}