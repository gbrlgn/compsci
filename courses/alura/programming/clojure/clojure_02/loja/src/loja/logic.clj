(ns loja.logic)

(defn funcao-agrupamento
  [elemento]
  (println "Elemento:" elemento)
  (:usuario elemento))

(defn total-do-item
  [[item-id detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido
  [pedido]
  (reduce + (map total-do-item pedido)))

(defn total-pedidos
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn total-usuario
  [[usuario pedidos]]
  {:usuario-id usuario
   :total-de-pedidos (count pedidos)
   :preco-total (total-pedidos pedidos)})

(defn resumo-por-usuario
  [pedidos]
  (->> pedidos
       (group-by :usuario)
       (map total-usuario)))
