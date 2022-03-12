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

"""
Não queremos permitir que ninguém instancie um 
objeto da classe Programa, e queremos garantir que 
todo mundo implemente o __str__ nas suas subclasses.
"""
class Programa(metaclass=ABCMeta):
    @abstractmethod
    def __str__(self):
        pass