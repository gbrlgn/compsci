/* Grafo */

        Maria -- Divino
              |        \
Vicente -- Geralda     Ana, Lilian
        |
Gabriel / Adan / Theo

/* Fatos */

pai(Divino, Geralda).
pai(Divino, Ana).
pai(Divino, Lilian).
mae(Maria, Geralda).
mae(Geralda, Gabriel).
mae(Geralda, Adan).
mae(Geralda, Theo).
marido(Divino, Maria).
marido(Vicente, Geralda).

/* Regras */

filhos(X, Y) :- pai(Y, X).
                mae(Y, X).

irmaos(X, Y) :- pais(A, X),
                pais(A, Y),
                X \== Y.
pais(X, Y) :- pai(A, Y), pai(A, X),
              mae(A, Y), mae(A, X),
              X \== Y.

tios(X, Y) :- irmaos(X, A),
              pais(A, Y).

avos(X, Y) :- pais(X, A),
              pais(A, Y).

netos(X, Y) :- filhos(Y, A),
               filhos(A, X).
