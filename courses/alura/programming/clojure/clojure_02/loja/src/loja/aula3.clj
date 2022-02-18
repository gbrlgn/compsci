(ns loja.aula3
  (:require [loja.db :as l.db]))

(println (group-by :usuario (l.db/todos-os-pedidos)))

(defn funcao-agrupamento
  [elemento]
  (println "Elemento:" elemento)
  (:usuario elemento))

(println (group-by funcao-agrupamento (l.db/todos-os-pedidos)))

(println (map count (vals (group-by :usuario (l.db/todos-os-pedidos)))))

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

(->> l.db/todos-os-pedidos
     (group-by :usuario)
     (map total-usuario)
     (map count)
     println)
