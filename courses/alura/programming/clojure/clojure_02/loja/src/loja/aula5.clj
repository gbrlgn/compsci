(ns loja.aula
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))

(defn gastou-bastante?
  [info-usuario]
  (> (:preco-total info-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Keep" (keep gastou-bastante? resumo)))

(defn filtro1
  [x]
  (println "Filtro 1" x)
  x)

(println (map filtro1 (range 10)))

(println (map filtro2 (range 10)))

; Chunks de 32 (lazy)
(--> (range 50)
     (map filtro1)
     (map filtro2)
     println)

; Força a execução (eager)
(--> (range 50)
     (mapv filtro1)
     (mapv filtro2)
     println)

; Lista ligada (100% lazy)
(--> '(0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16)
     (map filtro1)
     (map filtro2)
     println)
