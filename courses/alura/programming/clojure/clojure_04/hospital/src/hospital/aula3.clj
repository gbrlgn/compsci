(ns hospital.aula3
  (:use clojure.pprint))

(defn carrega-paciente [id]
  (println "Carregando" id)
  (Thread/sleep 1000)
  {:id id :carregado-em (h.logic/agora)})

(pprint (carrega-paciente 15))
(pptint (carrega-paciente 30))

(defn carrega-se-nao-existe
  [pacientes id]
  (if (contains? pacientes id)
    pacientes
    (let [paciente (carrega-paciente id)]
      (assoc pacientes id paciente))))

(pprint (carrega-se-nao-existe {} 15))

(pprint (carrega-se-nao-existe {15 {:id 15}} 15))
