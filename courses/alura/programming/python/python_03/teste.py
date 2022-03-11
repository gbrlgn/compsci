import conta as c

def cria_conta(numero, titular, saldo, limite):
   conta = {
       "numero": numero, "titular": titular, 
        "saldo": saldo, "limite": limite
    }
   return conta

def deposita(conta, valor): 
    conta ["saldo"] += valor

def saca(conta, valor):
    conta["saldo"] -= valor

def extrato(conta):
    print("Saldo é {}".format(conta["saldo"]))

# >>> from teste import cria_conta, deposita, saca, extrato
# >>> conta = cria_conta(123, "Nico", 55.0, 1000.0)
# >>> deposita(conta, 300.0)
# >>> extrato(conta)
# Saldo 355.0
# >>> saca(conta, 100.0)
# >>> extrato(conta)
# Saldo 255.0

conta = c.Conta(123, "Nico", 55.5, 1000.0)
conta2 = c.Conta(321, "Marco", 100.0, 1000.0)
print(conta.titular)
print(conta2.saldo)
conta.deposita(15.0)
print(conta.extrato())

pessoa = p.Pessoa("Chalita", "Steppat")
pessoa.exibe_nome_e_sobrenome()

conta2.transfere(10.0, conta2, conta)
print(conta2.extrato())
print(conta.extrato())

conta.set_limite(10000.0)

conta.limite = 2000.0
print(conta.limite)