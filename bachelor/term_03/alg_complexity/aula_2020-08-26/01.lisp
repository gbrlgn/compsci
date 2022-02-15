(defun sort (list)
  (cond
    ((null list) nil)
    (t
      (append
        (sort (list< (car list) (cdr list)))
        (cons (car list) nil)
        (sort (list>= (car list) (cdr list)))))))

(defun list< (a b) 
  (cond
    ((or (null a) (null b) nil))
    ((< a (car b)) (list< a (cdr b)))
    ((t (cons (car b) (list< a (cdr b)))))))

(defun list>= (a b)
  (cond
    ((or (null a) (null b) nil))
    ((>= a (car b)) (list>= a (car b)))
    ((t (cons (car b) (list>= a (car b)))))))

