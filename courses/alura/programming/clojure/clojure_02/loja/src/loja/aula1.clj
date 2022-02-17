(ns loja.aula1)

(def vet ["Gabriel" "Deleuze" "Nietzsche" "Leibniz"])

(def meu-map
  [func seq]
  (let [prim (first seq)]
    (if (not (nil? prim))
      (do
        (func prim)
        (meu-map func (rest seq))))))

(meu-map println vet)

;; Causa um stack overflow
(meu-map println (range 1000000))

;; recur faz com que a recursão não seja custosa
;; armazenando na pilha de execução (tail recursion)
(def meu-map
  [func seq]
  (let [prim (first seq)]
    (if (not (nil? prim))
      (do
        (func prim)
        (recur (meu-map func (rest seq)))))))

(meu-map println (range 100000))
