(ns hospital.aula2
  (:use clojure.pprint))

(defrecord PacienteParticular [id nome nascimento])
(defrecord PacienteComPlano [id nome nascimento plano])

; Tudo no mesmo lugar.
(deve-assinar?
 [paciente procedimento valor]
 (if (= PacienteParticular (type paciente))
   (>= valor 50)
   (if (= PacientePlano (type paciente))
     (let [plano (.plano paciente)]
       (not (some #(= % procedimento) plano)))
     true)))

(defprotocol Cobravel
  (deve-assinar? [paciente procedimento valor]))

(extend-type PacienteParticular
  Cobravel
  (deve-assinar? [paciente procedimento valor]
    (>= valor 50)))

(extend-type PacienteComPlano
  Cobravel
  (deve-assinar? [paciente procedimento valor]
    (let [plano (.plano paciente)]
      (not (some #(= % procedimento) plano)))))

(let [particular (->PacienteParticular 15, "Guilherme" "18/9/1981")
      plano (->PacienteComPlano 15, "Guilherme" "18/9/1981" [:raio-x :ultrassom])]
  (pprint (deve-assinar? particular :raio-x 500))
  (pprint (deve-assinar? plano :raio-x 500))
  (pprint (deve-assinar? plano :sangue 500)))

; Implementar o record junto com o protocol.
(defrecord PacienteComPlano
    [id nome nascimento plano]
  Cobravel
  (deve-assinar?
    [paciente procedimento valor]
    (let [plano (.plano paciente)]
      (not (some #(= % procedimento) plano)))))

(defprotocol Dateable
  (to-ms [this]))

(extend-type java.lang.Number
  Dateable
  (to-ms [this] this))

(pprint (to-ms 56))

(extend-type java.util.Date
  Dateable
  (to-ms [this] (.getTime this)))

; Construtor padrão do java.util.Date cria uma data,
; que tem sua função .getTime chamada no this de to-ms.
(pprint (to-ms (java.util.Date.)))

(extend-type java.util.Calendar
  Dateable
  (to-ms [this] (to-ms (.getTime this))))

; Cria um calendário gregoriano.
(pprint (to-mds (java.util.GregorianCalendar.)))
