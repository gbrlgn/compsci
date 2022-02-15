(ns aulas.aula-1)

(defn imprime-mensagem
  []
  (println "------------------------")
  (println "Bem vindo(a) ao estoque!"))

(defn aplica-desconto
  "Retorna o valor descontado."
  [valor-bruto]
  (* valor-bruto 0.9))

(defn valor-descontado
  "Retorna o valor com desconto de 10%."
  [valor-bruto]
  (* valor-bruto (- 1 0.1)))
