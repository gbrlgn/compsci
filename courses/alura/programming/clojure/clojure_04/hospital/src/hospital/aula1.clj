(ns hospital.aula1
  (:use clojure.pprint))

(defn adiciona-paciente
  "Pacientes:  { 15 {paciente 15}, 23 {paciente 23} }
  Paciente: { :id 15 ... }"
  [pacientes paciente]
  (if-let [id (:id paciente)]
    (assoc pacientes id paciente)
    (throw (ex-info "Paciente não possui ID" { :paciente paciente }))))

(defn testar-uso-de-pacientes
  []
  (let [pacientes {}
        guilherme { :id 15 :nome "Guilherme" :nascimento "18/9/1981"}
        daniela { :id 20 :nome "Daniela" :nascimento "18/9/1982"}
        paulo {:nome "Paulo" :nascimento "18/10/1983"}]
    (pprint (adiciona-paciente pacientes guilherme))
    (pprint (adiciona-paciente pacientes daniela))
    (pprint (adiciona-paciente pacientes paulo))))

(defrecord Paciente [id nome nascimento])
; Type hint: (defrecord Paciente [^Long id nome nascimento]).

; Adicionar elementos ao record.
(pprint (->Paciente 15 "Guilherme" "18/9/1981"))

; Adicionar por meio de um construtor.
(pprint (Paciente. 15 "Guilherme" "18/9/1981"))

; Adicionar por meio de um mapa.
(pprint (map->Paciente {:id 15 :nome "Guilherme" :nascimento "18/9/1981"}))

; Permite expansão do objeto (construtor é posicional).
(pprint (map->Paciente {:id 15 :nome "Guilherme" :nascimento "18/9/1981" :rg "687678668"}))

(let [guilherme (->Paciente 15 "Guilherme" "18/9/1981")]
  (println (:id guilherme))
  (println (vals guilherme))
  (println (class guilherme))
  (println (record? guilherme))
  (println (.nome guilherme))) ; / = método estático.

; Usar o . trata o acesso como um acesso direto. Sendo assim, é mais rápido em tempo de compilação do que um acesso a campos por meio de associações a um mapa.
