(ns hospital.aula3
  (:use [clojure pprint])
  (:require [hospital.logic :as h.logic
             hospital.model :as h.model]))

(defn chega-em-atom!
  [hospital pessoa]
  (swap! hospital (h.logic/chega-em hospital :espera pessoa))
  (println pessoa "inserida"))

(defn simula-um-dia-paralelo-mapv
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]]
    (mapv #(.start (Thread. (fn [] (chega-em-atom! hospital %)))) pessoas)
    (.start (Thread. (fn []
                       (Thread/sleep 4000)
                       (pprint hospital))))))

(defn simula-um-dia-paralelo-mapv-refac
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]
        thread-chegada #(.start (Thread. (fn [] (chega-em-atom! hospital %))))]
    (mapv thread-chegada pessoas)
    (.start (Thread. (fn []
                       (Thread/sleep 4000)
                       (pprint hospital))))))

(defn start-thread
  ([hospital]
   (fn [pessoa] (start-thread hospital pessoa)))
  ([hospital pessoa]
   (Thread. (fn [] chega-em-atom! hospital pessoa))))

(defn simula-um-dia-paralelo-mapv-refac2
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]]
    (mapv (hospital) pessoas)
    (.start (Thread. (fn []
                       (Thread/sleep 4000)
                       (pprint hospital))))))

(defn start-thread-partial
  [hospital pessoa]
  (Thread. (fn [] chega-em-atom! hospital pessoa)))

(defn simula-um-dia-paralelo-partial
  []
  (let [hospital (atom (h.model/novo-hospital))
        pessoas ["111", "222", "333", "444", "555", "666"]
        start (partial start-thread-partial hospital)]
    ;; O mapv gera um vetor de nil pois .start é void
    (mapv start pessoas)
    (.start (Thread. (fn []
                       (Thread/sleep 4000)
                       (pprint hospital))))))
