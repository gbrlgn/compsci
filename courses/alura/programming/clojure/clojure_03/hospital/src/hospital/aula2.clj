(ns hospital.aula2
  (:use [clojure pprint])
  (:require [hospital.logic :as h.logic
             hospital.model :as h.model]))

;; Shadowing
(let [nome "Guilherme"]
  (println nome)
  (let [nome "Daniela"]
    (println nome))
  (println nome))

(defn testa_atomo
  []
  (let [hospital2 (atom {:espera h.model/fila-vazia})]
    (println hospital2)
    (pprint hospital2)
    ;; #<Atom@hash: {:espera <-()-<}>
    (pprint @hospital2)
    ;; Dereferencia, obtendo o valor dentro do atom.
    (assoc @hospital2 :laboratorio1 h.model/fila-vazia)
    ;; Apenas acessa o valor, mas não altera-o.
    (swap! hospital2 assoc :laboratorio1 h.model/fila-vazia)
    ;; Altera o valor.
    (pprint @hospital2)
    ;; Adiciona membro à fila.
    (swap! hospital2 update :laboratorio1 conj "111")))
