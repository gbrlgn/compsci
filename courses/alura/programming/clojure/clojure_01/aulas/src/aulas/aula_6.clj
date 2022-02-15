(ns aulas.aula-6)

(def pedido {:mochila {:quantidade 2
                       :preco 80}
             :camiseta {:quantidade 3
                        :preco 40}})

(defn imprime-e-15
  [valor]
  (println "Valor" valor)
  15)

(println (map imprime-e-15 pedido))


;; (defn imprime-e-15
;;   [chave valor]
;;   (println chave "e" valor)
;;   15)

(defn imprime-e-15
  [[chave valor]]
  (println chave "e" valor)
  15)

(println (map imprime-e-15 pedido))

(defn preco-por-produto [valor]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-por-produto pedido))
(println (reduce + (map preco-por-produto pedido)))

(defn total-do-pedido
  [pedido]
  ;; THREAD LAST passa como último parâmetro
  (->> pedido
       vals
       (map preco-por-produto)
       (reduce +)))

(println (total-do-pedido pedido))

(def pedido {:mochila {:quantidade 2
                       :preco 80}
             :camiseta {:quantidade 3
                        :preco 40}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [[_ item]]
  (<= (get item :preco 0) 0))

(println (filter (fn [[chave item]] (gratuito? item)) pedido))
(println (filter #(gratuito? (second %)) pedido))

(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

(def pago? (comp not gratuito?))
