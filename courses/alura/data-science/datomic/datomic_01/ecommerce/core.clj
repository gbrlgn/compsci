(ns ecommerce.core
  (use clojure.pprint)
  (require [datomic.api :as d]
           [ecommerce.db :as db]
           [ecommerce.model :as model]))

(def conn (db/abrir-conexao))
(pprint conn)

(db/criar-schema conn)

(let [computador (model/novo-produto "Computador"
                                     "/computador"
                                     2500.10M)]
     (d/transact conn [computador]))

(def db (d/db conn))

(d/q '[:find ?entidade
       :where [?entidade :produto/nome]] db)