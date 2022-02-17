(ns loja.aula2)

;; Erro pois não há critério de parada
(defn conta
  [total-agora elementos]
  (recur (inc total-agora(rest elementos))))

(defn conta
  [total-agora elementos]
  (if (seq elementos)
    (recur (inc total-agora (next elementos)))
    total-agora))
