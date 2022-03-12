from abc import ABC
from collections.abc import MutableSequence
from numbers import Complex

class Playlist(MutableSequence):
    pass

filmes = Playlist()

class Numero(Complex):
    def __getitem__(self, item):
        super().__getitem__()