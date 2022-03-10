(ns hospital.aula4
  (:use clojure.pprint))

(defrecord PacienteParticular [id nome nascimento situacao])
(defrecord PacientePlano [id nome nascimento plano situacao])

(defprotocol Cobravel
  (deve-assinar? [paciente procedimento valor]))

(defn nao-urgente?
  [paciente]
  (not= :urgente (:situacao paciente :normal)))

(extend-type PacienteParticular
  Cobravel
  (deve-assinar? [paciente procedimento valor]
    (let [plano (:plano paciente)]
      (and (not (some #(= % procedimento) plano) (nao-urgente? paciente))))))

(let [particular (->PacienteParticular 15 "Guilherme" "18/9/1981" :normal)
      plano (->PacienteComPlano 15 "Guilherme" "18/9/1981" :normal [:raio-x :ultrassom])]
  (pprint (deve-assinar? particular :raio-x 500))
  (pprint (deve-assinar? particular :raio-x 40))
  (pprint (deve-assinar? plano :raio-x 99999))
  (pprint (deve-assinar? plano :coleta-de-sangue 99999)))
