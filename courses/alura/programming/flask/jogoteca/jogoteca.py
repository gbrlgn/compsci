from flask import Flask, render_template, request, redirect, session, flash, url_for

class Jogo:
    def __init__(self, nome, categoria, console):
        self.nome = nome
        self.categoria = categoria
        self.console = console


class Usuario:
    def __init__(self, nome, nick, senha):
        self.nome = nome
        self.nick = nick 
        self.senha = senha


jogo1 = Jogo('Nier', 'Hack n\' Slash', 'PS4')
jogo2 = Jogo('Disco Elysium', 'Point and Click', 'PC')
jogo3 = Jogo('Pathologic', 'Depressão', 'PC')
lista = [jogo1, jogo2]

usuario1 = Usuario('Deleuze', 'GD', 'deterritorialisation')
usuario2 = Usuario('Leibniz', 'Leilei', 'MONADS')
usuario3 = Usuario('Thom Yorke', 'Tchock', 'nononononononononononononononononononono')
usuarios = {
    usuario1.nick: usuario1,
    usuario2.nick: usuario2,
    usuario3.nick: usuario2
}

app = Flask(__name__)
app.secret_key = "alura"

@app.route('/')
def index():
    return render_template('lista.html', titulo='Jogos', jogos=lista)

@app.route('/novo')
def novo():
    if 'usuario_logado' not in session or session['usuario_logado'] == None:
        return redirect(url_for('login'), prximo=url_for('novo'))

    return render_template('novo.html', titulo='Novo jogo')

@app.route('/criar', methods=['POST'])
def criar():
    nome = request.form['nome']
    categoria = request.form['categoria']
    console = request.form['console']

    jogo = Jogo(nome, categoria, console)
    lista.append(jogo)

    return redirect(url_for('index'))

@app.route('/login')
def login():
    proximo = request.args.bet('proximo')
    return render_template('login.html', proximo=proximo)

@app.route('/auth', methods=['POST'])
def auth():
    if request.form['usuario'] in usuarios:
        usuario = usuarios[request.form['usuario']]
        if request.form['senha'] == usuario.senha:
            session['usuario_logado'] = usuario.nick
            flash(usuario.nick + ' logado com sucesso.')
            proximo = request.form['proxima']
            return redirect(proximo)
        else:
            return redirect(url_for('login'))

@app.route('/logout')
def logout():
    session['usuario_logado'] = None
    flash("Logout efetuado com sucesso.")
    return redirect(url_for('index'))

app.run(host='0.0.0.0', port=8080, debug=True)