(ns hospital.aula5
    (:use clojure.pprint))

(defn tipo-de-autorizador [pedido]
  (let [paciente (:paciente pedido)
        situacao (:situacao paciente)
        urgencia? (= :urgente situacao)]
    (cond (= :urgente situacao) :autorizado
          (contains? paciente :plano) :plano-de-saude
          :else :credito-minimo)))

(defmulti deve-assinar? tipo-de-autorizador)

(defmethod deve-assinar? :autorizado
  [pedido]
  false)

(defmethod deve-assinar? :plano-de-saude
  [pedido]
  (not (some #(= % (:procedimento pedido)) (:plano (:paciente pedido)))))

(let [particular {:id 15 :nome "Guilherme" :nascimento "18/9/1981" :situacao :urgente}
      plano {:id 15 :nome "Guilherme" :nascimento "18/9/1981" :situacao  :urgente [:raio-x :ultrassom]}]
  (pprint (deve-assinar? [:paciente particular :valor 1000 :procedimento :coleta-de-sangue]))
  (pprint (deve-assinar? [:paciente plano :valor 1000 :procedimento :coleta-de-sangue]))

(let [particular {:id 15 :nome "Guilherme" :nascimento "18/9/1981" :situacao :normal}
      plano {:id 15 :nome "Guilherme" :nascimento "18/9/1981" :situacao  :normal [:raio-x :ultrassom]}]
  (pprint (deve-assinar? [:paciente particular :valor 1000 :procedimento :coleta-de-sangue]))
  (pprint (deve-assinar? [:paciente plano :valor 1000 :procedimento :coleta-de-sangue]))