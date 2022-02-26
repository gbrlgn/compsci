(ns hospital.aula6
  (:use [clojure pprint])
  (:require [hospital.model :as h.model]))

(defn cabe-na-fila?
  [fila]
  (-> fila
      count
      (< 5)))

(def chega-em
  [fila pessoa]
  (if (cabe-na-fila? fila)
    (conj fila pessoa)
    (throw (ex-info "Fila já está cheia." {:tentando-adicionar pessoa)))))

(def chega-em!
  [hospital pessoa]
  (let
      [fila (get hospital :espera)]
    (alter fila chega-em pessoa)))

(def chega-em-alter
  [hospital pessoa]
  (let
      [fila (get hospital :espera)]
    (ref-set fila (chega-em @fila pessoa))))

(defn simula-um-dia
  []
  (let [hospital {:espera (ref h.model/fila-vazia)
                  :laboratorio1 (ref h.model/fila-vazia)
                  :laboratorio2 (ref h.model/fila-vazia)
                  :laboratorio3 (ref h.model/fila-vazia)}]
    (dosync
     (chega-em! hospital "Guilherme")
     (chega-em! hospital "Maria")
     (chega-em! hospital "Lúcia")
     (chega-em! hospital "Daniela")
     (chega-em! hospital "Ana")
     (chega-em! hospital "Paulo"))
    (pprint hospital)))

(defn async-chega-em!
  [hospital pessoa]
  (future (Thread/sleep (rand 5000))
          (dosync
           (println "Tentando o código sinconizado." pessoa)
           (chega-em! hospital pessoa))))

(defn async-simula-um-dia
  []
  (let [hospital {:espera (ref h.model/fila-vazia)
                  :laboratorio1 (ref h.model/fila-vazia)
                  :laboratorio2 (ref h.model/fila-vazia)
                  :laboratorio3 (ref h.model/fila-vazia)}]
    (dotimes
        [pessoa 10]
     (async-chega-em! hospital pessoa))
    (pprint hospital)))

(defn async-simula-um-dia2
  []
  (let [hospital {:espera (ref h.model/fila-vazia)
                  :laboratorio1 (ref h.model/fila-vazia)
                  :laboratorio2 (ref h.model/fila-vazia)
                  :laboratorio3 (ref h.model/fila-vazia)}
        futures (mapv #(async-chega-em! hospital %) (range 10))]

    (future
      (dotimes [n 8]
        (Thread/sleep 4000)
        (pprint hospital)
        (pprint futures)))))
