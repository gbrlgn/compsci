;; Implementar um jogo de adivinhação de número por meio
;; de uma busca binária

(defparameter *max* 100)
(defparameter *min* 1)

(defun adivinha ()
    ;; A função ash executa um shift binário de acordo 
    ;; com o parâmetro passado, dobrando ou dividindo
    ;; o valor pela metade.
    (ash (+ *max* *min*) -1))

(defun maior ()
    (setf *min* (1- (adivinha)))
    (adivinha))

(defun menor ()
    (setf *max* (1- (adivinha)))
    (adivinha))

(defun recomecar () 
    (defparameter *max* 100)
    (defparameter *min* 1)
    (adivinha))
