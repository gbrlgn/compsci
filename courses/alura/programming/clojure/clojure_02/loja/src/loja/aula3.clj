(ns loja.aula3
  (:require [loja.db :as l.db]))

(println (group-by :usuario (l.db/todos-os-pedidos)))

(defn funcao-agrupamento
  [elemento]
  (println "Elemento:" elemento)
  (:usuario elemento))

(println (group-by funcao-agrupamento (l.db/todos-os-pedidos)))

(println (map count (vals (group-by :usuario (l.db/todos-os-pedidos)))))

(->> l.db/todos-os-pedidos
     (group-by :usuario)
     vals
     (map count)
     println)
