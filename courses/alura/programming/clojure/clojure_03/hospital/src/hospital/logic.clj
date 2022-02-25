(ns hospital.logic)
(defn cabe-na-fila?
  [hospital departamento]
  (-> hospital
      (get departamento)
      count
      (< 5)))

(defn chega-em
  [hospital departamento pessoa]
  (if (cabe-na-fila? hospital departamento)
     (update hospital departamento conj pessoa)
     (throw (ex-info "Fila já está cheia" {:tentando-adicionar pessoa}))))

(defn chega-em-pausado
  [hospital departamento pessoa]
  (if (cabe-na-fila? hospital departamento)
    (do
      (Thread/sleep (* (rand) 2000))
      (update hospital departamento conj pessoa))
    (throw (ex-info "Fila já está cheia" {:tentando-adicionar pessoa}))))

(defn chega-em-paralelo
  [pessoa]
  (def hospital (h.logic/chega-em-pausado hospital :espera pessoa))
  (println pessoa "inserida."))

(defn atende
  [hospital departamento]
  (update hospital departamento pop))

(defn proxima
  [hospital departamento]
  (-> hospital
      departamento
      peek))

(defn transfere
  [hospital de para]
  (let [pessoa (proxima hospital de)]
    (-> hospital
        (atende de)
        (chega-em para pessoa))))

(defn atende-completo
  [hospital departamento]
  {:paciente (update hospital departamento peek)
   :fila (update hospital departamento pop)})

(defn atende-completo-chama-ambos
  [hospital departamento]
  (let [fila (get hospital departamento)
        peel-pop (juxt peek pop)
        [pessoa fila-atualizada] (peek-pop fila)
        hospital-atual (update hospital departamento fila-atualizada)]
    {:paciente pessoa
     :hospital hospital-atual}))
