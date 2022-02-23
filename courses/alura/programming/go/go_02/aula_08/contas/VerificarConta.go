package contas

type VerificarConta interface {
	Sacar(valor float64) string
}
