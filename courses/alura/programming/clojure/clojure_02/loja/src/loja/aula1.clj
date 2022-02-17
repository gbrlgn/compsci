(ns loja.aula1)

(def vet ["Gabriel" "Deleuze" "Nietzsche" "Leibniz"])

(def meu-map
  [func seq]
  (let [prim (first seq)]
    (if (not(nil? prim))
      (do
        (func prim)
        (meu-map func (rest seq))))))

(meu-map println vet)
