(ns loja.aula4
  :require [loja.db :as l.db
            loja.logic :as l.logic])

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-ord-usuario (pedidos))]
  (println "Resumo" resumo)
  (println "Ordenado" (sort-by :preco-total resumo))
  (println "Ordenado ao contrário" (reverse (sort-by :preco-total resumo)))
  (println "Ordenado por ID" (sort-by :usuario-id resumo))
  (println (get-in pedidos [0 :itens :mochila :quantidade])))

(defn resumo-ord-usuario
  [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :preco-total)))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-ord-usuario pedidos)]
  (println "Resumo" resumo)
  (println "Top 2" (take 2 resumo)))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-ord-usuario pedidos)]
  (println "> 500" (filter #(> (:preco-total %) 500) resumo))
  (println "> 500 some (se existe)" (some #(> (:preco-total %) 500) resumo)))
