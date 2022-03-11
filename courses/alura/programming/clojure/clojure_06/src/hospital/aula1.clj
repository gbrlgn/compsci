(ns hospital.aula1
  (:use clojure.pprint)
  (:require [schema.core :as s]))

(defn adiciona-paciente [pacientes paciente]
  (if-let [id (:id paciente)]
    (assoc pacientes id paciente)
    (throw (ex-info "Paciente não possui id" {:paciente paciente}))))

(defn testa-uso-de-pacientes []
  (let [guilherme {:id 15 :nome "Guilherme"}
        daniela {:id 20 :nome "Daniela"}
        paulo {:id 25 :nome "Paulo"}
        pacientes (reduce adiciona-paciente {} [guilherme daniela paulo])]
    (pprint pacientes)))

(testa-uso-de-pacientes)

;; { 15 [] 20 [] 25 []}
(defn adiciona-visita
  [visitas paciente novas-visitas]
  (if (contains? visitas paciente)
    (update visitas paciente concat novas-visitas)
    (assoc visitas paciente novas-visitas)))

(defn imprime-relatorio-de-pacientes [visitas paciente]
  (println "Visitas do paciente" paciente "são:" (get visitas paciente)))

(defn testa-uso-de-pacientes []
  (let [guilherme {:id 15 :nome "Guilherme"}
        daniela {:id 20 :nome "Daniela"}
        paulo {:id 25 :nome "Paulo"}
        pacientes (reduce adiciona-paciente {} [guilherme daniela paulo])
        visitas {15 ["01/01/2019"]
                 20 ["01/02/2019" "01/01/2020"]
                 15 ["01/03/2019"]}
        lista-de-visitas (reduce adiciona-visita {} (:id pacientes) visitas)]
    (pprint pacientes)
    (pprint lista-de-visitas)
    (imprime-relatorio-de-pacientes)))

;; Depois de instalar o Prismatic Schema.
(pprint (s/validate Long 15))

;; Syntax error (ExceptionInfo) compiling at (aula1.clj:41:1).
;; Value does not match schema: (not (instance? java.lang.Long "guilherme"))
;; (pprint (s/validate Long "guilherme"))

;; Syntax error (ExceptionInfo) compiling at (aula1.clj:42:1).
;; Value does not match schema: (not (instance? java.lang.Long [15 13]))
;; (pprint (s/validate Long [15 13]))

;; Define que a validação ocorra sempre.
(s/set-fn-validation! true)

;; Macro defn que permite validações com s/validate.
(s/defn teste-simples [x :- Long]
  (println x))

(teste-simples 15)
(teste-simples 30)
;; (teste-simples "guilherme")

(s/defn imprime-relatorio-de-pacientes
  [visitas paciente :- Long]
  (println "Visitas do paciente" paciente "são:" (get visitas paciente)))

(testa-uso-de-pacientes)

;; Syntax error (ExceptionInfo) compiling at (aula1.clj:58:1).
;; Input to imprime-relatorio-de-paciente does not match schema: 
;; [nil (named (not (instance? java.lang.Long a-clojure.lang.PersistentArrayMap)) paciente)]

(s/defn novo-paciente
  [id :- Long, nome :- s/Str]
  { :id id, :nome nome})

;; {:id 15 :nome "Guilherme"}
(pprint (novo-paciente 15 "Guilherme"))

;; (pprint (novo-paciente "Guilherme" 15))
;; Syntax error (ExceptionInfo) compiling at (aula1.clj:67:1).
;; Input to novo-paciente does not match schema: 
;; [(named (not (instance? java.lang.Long "Guilherme")) id) (named (not (instance? java.lang.String 15)) nome)]