(ns aulas.aula-5)

(def estoque {"Mochila" 10
              "Camiseta" 5})

(println "Temos" (count estoque) "elementos")
(println "As chaves são:" (keys estoque))
(println "Os valores são:" (vals estoque))

(def estoque {:mochila 10
              :camiseta 5})

(println (assoc estoque :cadeira 3))
(println (dissoc estoque :camiseta))
(println (update estoque :mochila inc))

(def pedido {:mochila {:quantidade 2
                       :preco 80}
             :camiseta {:quantidade 2
                        :preco 40}})
(println "\n\n\n")
(println pedido)

(def pedido (assoc pedido :chaveiro {:quantidade 1
                                     :preco 10}))
(println (pedido :mochila)) ;; NullPointer caso for nulo
(println (:camiseta pedido))

(println (:quantidade (:mochila pedido)))

(println (update-in pedido [:mochila :quantidade] inc))

;; THREADING

(println(-> pedido
            :mochila
            :quantidade))

(-> pedido
    :mochila
    :quantidade
    print)
