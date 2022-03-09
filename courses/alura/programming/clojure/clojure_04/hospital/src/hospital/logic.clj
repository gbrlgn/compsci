(ns hospital.logic
  (:use clojure.pprint)
  (:require [hospital.logic :as h.logic]))


(defn agora
  (to-ms (java.util.Date)))
