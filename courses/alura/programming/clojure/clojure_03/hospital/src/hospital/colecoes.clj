(ns hospital.colecoes
  (:use [clojure pprint]))

(defn testa-fila []
    (let [espera (conj clojure.lang.PersistentQueue/EMPTY "111" "222")]
        (println "fila")
        (println (seq (espera))
        (println (seq (conj espera "333")))
        (println (seq (pop espera)))
        (println (peek espera)))
        (pprint espera)))

(testa-fila)