(ns hospital.aula4
    (:use clojure.pprint))

(defrecord PacienteParticular [id nome nascimento situacao])
(defrecord PacientePlano [id nome nascimento situacao plano])

(defprotocol Cobravel
    (deve-assinar? [paciente procedimento valor]))

(defn nao-urgente? [paciente]
    (not= :urgente (:situacao paciente :normal)))

(extend-type PacienteParticular
    Cobravel
    (deve-assinar? [paciente, procedimento, valor]
        (and (>= valor 50) (nao-eh-urgente? paciente))))

(extend-type PacientePlano
    Cobravel
    (deve-assinar? [paciente procedimento valor]
        (let [plano (:plano paciente)]
            (and (not (some #(= % procedimento) plano)) (nao-urgente? paciente)))))

(let [particular (->PacienteParticular 15 "Guilherme" "18/9/1981" :normal)
    plano (->PacientePlano 15 "Guilherme" "18/9/1981" :normal [:raio-x :ultrassom])]
  (pprint (deve-assinar? particular :raio-x 500))
  (pprint (deve-assinar? particular :raio-x 40))
  (pprint (deve-assinar? plano :raio-x 999999))
  (pprint (deve-assinar? plano :coleta-de-sangue 999999)))

(defmulti deve-assinar-multi? class)
(defmethod deve-assinar-multi? PacienteParticular
  [paciente]
  (println "Invocando paciente particular.")
  true)
(defmethod deve-assinar-multi? PacientePlano
  [paciente]
  (println "Invocando paciente com plano.")
  false)

(let [particular (->PacienteParticular 15 "Guilherme" "18/9/1981" :urgente)
      plano (->PacientePlano 15 "Guilherme" "18/9/1981" :urgente [:raio-x :ultrassom])]
  (pprint (deve-assinar-multi? particular))
  (pprint (deve-assinar-multi? plano)))

(defn tipo-de-autorizador [pedido]
  (let [paciente (:paciente pedido)
        situacao (:situacao paciente)
        urgencia? (= :urgente situacao)]
    (if urgencia?
      :autorizado
      (class paciente))))
    
(defmulti deve-assinar? tipo-de-autorizador)
(defmethod deve-assinar? :autorizado [pedido]
  false)
(defmethod deve-assinar? PacienteParticular [pedido]
  (>= (:valor pedido 0) 50))
(defmethod deve-assinar? PacientePlano [pedido]
  (not (some #(= % (:procedimento pedido)) (:plano (:paciente pedido)))))

(let [particular (->PacienteParticular 15 "Guilherme" "18/9/1981" :urgente)
      plano (->PacientePlano 15 "Guilherme" "18/9/1981" :urgente [:raio-x :ultrassom])]
  (pprint (deve-assinar? [:paciente particular :valor 1000 :procedimento :coleta-de-sangue]))
  (pprint (deve-assinar? [:paciente plano :valor 1000 :procedimento :coleta-de-sangue