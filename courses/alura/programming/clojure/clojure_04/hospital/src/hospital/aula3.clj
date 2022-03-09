(ns hospital.aula3
  (:use clojure.pprint)
  (:require [hospital.logic :as h.logic
             hospital.model :as h.model]))

(defn carrega-paciente [id]
  (println "Carregando" id)
  (Thread/sleep 1000)
  {:id id :carregado-em (h.logic/agora)})

(pprint (carrega-paciente 15))
(pptint (carrega-paciente 30))

(defn carrega-se-nao-existe
  [cache id carregadora]
  (if (contains? cache id)
    cache
    (let [item (carregadora id)]
      (assoc cache id item))))

(pprint (carrega-se-nao-existe {} 15))

(pprint (carrega-se-nao-existe {15 {:id 15}} 15))

(defprotocol Carregavel
  (carrega! [this id]))

(defrecord Cache
    [cache carregadora]
  Carregavel
  (carrega! [this id]
    (swap! cache carrega-se-nao-existe id carregadora)
    (get @cache id)))

(def pacientes (->Cache (atom {} carrega-paciente)))
(pprint pacientes)
(carrega! pacientes 15)
(carrega! pacientes 30)
(carrega! pacientes 15)
(pprint pacientes)
