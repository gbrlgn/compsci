(ns hospital.aula3
  (:use clojure.pprint)
  (:require [schema.core :as s]))

(s/set-fn-validation! true)

(def PosInt (s/pred pos-int? 'inteiro-positivo))

(def Paciente
  {:id (s/pred PosInt) :nome s/Str})

(s/defn novo-paciente :- Paciente
  [id :- PosInt
   nome :- s/Str]
  {:id id :nome nome})

(defn maior-ou-igual-a-zero? [x] (>= x 0))

(def ValorFinanceiro (s/constrained s/Num maior-ou-igual-a-zero?))

(def Procedimento s/Keyword)

(s/defn novo-pedido :- Pedido
  [paciente :- Paciente
   valor :- ValorFinanceiro
   procedimento :- Procedimento]
  {:paciente paciente 
   :valor valor 
   :procedimento procedimento})
        
(pprint (novo-pedido (novo-paciente 15 "Guilherme") 15.53 :raio-x))

(def Plano [s/Keyword])

(pprint (s/validate Plano [:raio-x]))

(def Numeros [s/Num])

(pprint (s/validate Numeros [15]))

(def Paciente
  {:id PosInt :nome s/Str :plano Plano})

(pprint (s/validate Paciente {:id 15 :nome "Guilherme" :plano [:raio-x :ultrassom]}))

(pprint (s/validate Paciente {:id 15 :nome "Guilherme" :plano [:raio-x]}))
(pprint (s/validate Paciente {:id 15 :nome "Guilherme" :plano []}))
(pprint (s/validate Paciente {:id 15 :nome "Guilherme" :plano nil}))

;; {:id 15 :nome "Guilherme" :plano [:raio-x]}
;; {:id 15 :nome "Guilherme" :plano []}
;; {:id 15 :nome "Guilherme" :plano nil}