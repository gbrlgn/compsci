class Cliente:

    def __init__(self, nome):
        self.nome = nome

    @property
    def nome(self):
        print("chamando @property nome()")
        return self.nome.title()

    @property
    def limite(self):
        return self.__limite

    @limite.setter
    def limite(self, limite):
        self.__limite = limite