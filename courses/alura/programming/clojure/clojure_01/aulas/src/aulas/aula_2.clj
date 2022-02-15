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
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de " taxa-de-desconto)
      (- valor-bruto desconto)
      (class taxa-de-desconto))
    valor-bruto))
