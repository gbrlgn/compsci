(defproject ecommerce "0.1.0-SNAPSHOT"
  :description "Datomic"
  :url "br.com.alura.ecommerce"
  :license {:name "GPL version 3"
            :url "https://www.gnu.org/licenses/quick-guide-gplv3.pt-br.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [com.datomic/datomic-pro "0.9.5951"]]
  :repl-options {:init-ns ecommerce.core})