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
  (println "Primeiro" (first resumo))
  (println "Segundo" (second resumo))
  (println "Resto" (rest resumo))
  (println "Classe" (class resumo))
  (println "Enésimo" (nth resumo 1))
  (println "Take" (take 2 resumo)))

(defn top-2
  [pedidos]
  (take 2 pedidos))
