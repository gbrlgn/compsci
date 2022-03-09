(ns hospital.aula1
  (:use clojure.pprint))

(defn adiciona-paciente
  [pacientes paciente]
  (if-let [id (:id paciente)]
    (assoc pacientes id paciente)
    (throw (ex-info "Paciente não possui ID." {:paciente paciente}))))
