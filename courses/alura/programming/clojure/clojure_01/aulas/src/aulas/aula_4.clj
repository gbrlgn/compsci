(ns aulas.aula-4)

(def precos [30 700 1000])

(println (precos 0))
(println (get precos 0))
(println (get precos 17))
;; out of bounds exception: (println (precos 17))
(println (get precos 17 "Valor padrão no caso de nulo."))
(println (conj precos 5))
(println (update precos 0 inc))
(println (update precos 1 dec))

(defn soma-1
  [valor]
  (println "Estou somando um em " valor)
  (+ valor 1))

(println (soma-1 (get precos 0)))

(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))

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

(println (map valor-descontado precos))

(println (range 10))

(println (filter even? (range 10)))

(println "Vetor" precos)
(println "Filter" (filter mais-caro-que-100? precos))
(println "Map após o filter" (map valor-descontado (filter mais-caro-que-100? precos)))

(println (reduce + precos))

(defn minha-soma
  [valor-1 valor-2]
  (println "Somando" valor-1 "e" valor-2)
  (+ valor-1 valor-2))

(println (reduce minha-soma precos))
(println (reduce minha-soma (range 10)))
(println (reduce minha-soma [15]))
(println (reduce minha-soma 10 precos))
