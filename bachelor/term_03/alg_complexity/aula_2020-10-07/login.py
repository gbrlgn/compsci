loginCount = 0
login = True

def loginCheck (user, password):
  
  userList = [("Bianca", "amor"), ("Gabriel", "baconbatata"), ("Juarez da TekPix", "08007777000")]

  check = False
  for check in userList:

    if user in check[0] & password in check[1]:

      print("Login successfull.")
      check = True
      break

    check = False

  return check

def login():

  user = str(input("Informe seu nome de usuário: "))
  password = str(input("Informe sua senha de usuário: "))

  return loginCheck(user, password)

while login == True:

  loginRes = login()

  if loginRes == False:

    loginCount += 1

  elif loginCount == 3:

    print("Perdeu playboy!")
    login = False
