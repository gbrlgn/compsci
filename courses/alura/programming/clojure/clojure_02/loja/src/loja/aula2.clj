(ns loja.aula2)

;; Erro pois não há critério de parada
(defn conta
  [total-agora elementos]
  (recur (inc total-agora(rest elementos))))

(defn conta
  ([elementos]
   (conta 0 elementos))

  ([total-agora elementos]
   (if (seq elementos)
     (recur (inc total-agora (next elementos)))
     total-agora)))

(println (conta 0 [1 2 3 4]))


;; Uso de loop (caso haja algum código a ser executado
;; antes (ou fora) da execução
(defn conta
  [elementos]
  (println "Antes da recursão!")
  (loop [total-agora 0
         elementos-rest elementos]
    (if (seq elementos-rest)
      (recur (inc total-agora) (next elementos-rest))
      total-agora)))
