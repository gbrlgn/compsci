(ns aulas.aula-3)

(defn valor-descontado
  "Retorna o valor com desconto de 10%."
  [aplica? valor-bruto]
  (if aplica? valor-bruto
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de " taxa-de-desconto)
      (- valor-bruto desconto)
      (class taxa-de-desconto))
    valor-bruto))

(println (valor-descontado mais-caro-que-100? 1000))

(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))

(println "Lambdaaaaaa")

(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100) ) 1000))

(println (valor-descontado (fn [v] (> v 100)) 1000))

(println (valor-descontado #(> % 100) 1000))

(def mais-caro-que-100? (fn [valor-bruto] (> valor-bruto 100)))
