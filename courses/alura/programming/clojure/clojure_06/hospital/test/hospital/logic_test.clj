(ns hospital.logic_test
  (:use clojure.pprint)
  (:require [clojure.test :refer :all]
            [hospital.logic :refer :all]
            [hospital.model :as h.model]))

(deftest cabe-na-fila?-test
  ;; Borda do zero.
  (testing "Que cabe na fila"
    (is (cabe-na-fila? {:espera []} :espera)))
  ;; Borda do limite.
  (testing "Que não cabe na fila quando a fila está cheia"
    (is (not (cabe-na-fila? {:espera [1 2 3 4 5]} :espera))))
  ;; One-off da borda do limite para cima.
  (testing "Que não cabe na fila quando tem mais do que uma fila cheia."
    (is (not (cabe-na-fila? {:espera [1 2 3 4 5 6]} :espera))))
  ;; Dentro das bordas.
  (testing "Que cabe na fila quando tem pouco menos do que uma fila cheia."
    (is (cabe-na-fila? {:espera [1 2 3 4]} :espera))
    (is (cabe-na-fila? {:espera [1 2]} :espera)))
  (testing "Que não cabe quando o departamento não existe."
        (is (not (cabe-na-fila? {:espera [1 2 3 4]} :raio-x)))))

;; (ns hospital.logic)

;; Devolve nil caso não haja departamento.
;; (defn cabe-na-fila?
;;     [hospital departamento]
;;     (if-let -- when-let [fila (get hospital departamento)]
;;         (-> fila
;;             count
;;             (< 5))))

;; Devolve nil e para a execução em caso de count nulo.
;; (defn cabe-na-fila?
;;     [hospital departamento]
;;         (some-> hospital
;;             departamento
;;             count
;;             (< 5)))

(deftest chega-em-test
  (let [hospital-cheio {:espera [1 35 42 64 21]}]
    (testing "Não aceita quando não cabe na fila."

;;  (is (thrown? clojure.lang.ExceptionInfo "não cabe ninguém neste departamento."
;;               (chega-em {:espera [1 35 42 64 21]} :espera 76)))

;;  (is (thrown? IllegalStateException
;;               (chega-em {:espera [1 35 42 64 21]} :espera 76)))

;;  (is (nil? (chega-em {:espera [1 35 42 64 21]} :espera 76)))

;;  (is (try
;;        (chega-em {:espera [1 35 42 64 21]} :espera 76)
;;        false 
;;        (catch clojure.lang.ExceptionInfo e
;;          (= :impossivel-colocar-pessoa-na-fila (:tipo ex-data e)))))))

;;  (defn- tenta-colocar-na-fila
;;    [hospital departamento pessoa]
;;      (if (cabe-na-fila? hospital departamento)
;;          (update hospital departamento conj pessoa)))

;;  (defn chega-em
;;    [hospital departamento pessoa]
;;    (if-let [novo-hospital (tenta-colocar-na-fila hospital departamento pessoa)]
;;      {:hospital novo-hospital :resultado :sucesso}
;;      {:hospital hospital :resultado :impossível-colocar-pessoa-na-fila}))

      (is (= {:hospital {:espera [1 35 42 64 21]}
              :resultado :impossível-colocar-pessoa-na-fila}
             (chega-em {:espera [1 35 42 64 21]} :espera 76))))

    (testing "Aceita pessoas se cabe."
      (let [hospital-original {:espera (conj h.model/fila-vazia 5)
                               :raio-x []}]
        (is (= {:espera []
                :raio-x [5]}
               (transfere hospital-original :espera :raio-x))))
      (let [hospital-original {:espera [51 5]
                               :raio-x (conj h.model/fila-vazia 13)}]
        (is (= {:espera [5]
                :raio-x [13 51]}
               (transfere hospital-original :espera :raio-x)))))

    (testing "Recusa pessoas se não cabe."
      (let [hospital-cheio {:espera (conj h.model/fila-vazia 5)
                            :raio-x (conj h.model/fila-vazia 1 2 53 42 13)}]
        (is (thrown? clojure.lang.ExceptionInfo
                     (transfere hospital-cheio :espera :raio-x))))))

  (deftest transfere-test
    (s/defn atende :- h.model/Hospital
      [hospital :- h.model/Hospital
       departamento :- s/Keyword]
      (update hospital departamento pop))

    (s/defn proxima :- h.model/PacienteID
      "Retorna o próximo paciente da fila."
      [hospital :- h.model/Hospital
       departamento :- s/Keyword]
      (-> hospital
          departamento
          peek))

    (s/defn transfere :- h.model/Hospital
      "Transfere o próximo paciente da fila de para a fila para."
      [hospital :- h.model/Hospital
       de :- s/Keyword
       para :- s/Keyword]
      (let [pessoa (proxima hospital de)]
        (-> hospital
            (atende de)
            (chega-em para pessoa))))

    (testing "Não pode invocar transferência sem hospital."
      (is (thrown? clojure.lang.ExceptionInfo (transfere nil :espera :raio-x))))

    (testing "Condições obrigatórias."
      (let [hospital {:espera (conj h.model/fila-vazia "5")
                      :raio-x (conj h.model/fila-vazia "1" "54" "43" "12")}]
        (is (thrown? AssertionError)
            (transfere hospital :nao-existe :raio-x)))
      (is (thrown? AssertionError)
          (transfere hospital :raio-x :nao-existe))))

;;  (defn mesmo-tamanho? [hospital outro-hospital de para]
;;    (= (+ (count (get (outro-hospital de)) (count (get outro-hospital para)))
;;          (+ (count (get (hospital de)) (count (get hospital para)))))))

;;  (s/defn transfere :- h.model/Hospital
;;    "Transfere o próximo paciente da fila de para a fila para."
;;    [hospital :- h.model/Hospital
;;     de :- s/Keyword
;;     para :- s/Keyword]
;;    {:pre [(contains? hospital de) (contains? hospital para)]
;;     :post [(= (+ (count (get (% de)) (count (get % para)))
;;                  (+ (count (get (hospital de)) (count (get hospital para))))))]}
;;    (let [pessoa (proxima hospital de)]
;;      (-> hospital
;;          (atende de)
;;          (chega-em para pessoa)))))