from abc import ABCMeta, abstractmethod
from collections.abc import MutableSequence
from numbers import Complex


class Playlist(MutableSequence):
    pass


filmes = Playlist()


class Numero(Complex):
    def __getitem__(self, item):
        super().__getitem__()


numero = Numero()


class Programa(metaclass=ABCMeta):
    @abstractmethod
    def __str__(self):
        pass