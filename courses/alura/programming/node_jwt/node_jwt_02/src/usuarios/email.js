const nodemailer = require('nodemailer');

const configEmailProd = {
  host: process.env.EMAIL_HOST,
  auth: {
    user: process.env.EMAIL_USUARIO,
    pass: process.env.EMAIL_SENHA
  },
  secure: true
};

const configEmailTeste = (conta) => ({
  host: 'smtp.ethereal.email',
  auth: contaTeste
});

async function criaConfigEmail() {
  if (process.env.NODE_ENV === 'production') {
    return configEmailProd;
  } else {
    const contaTeste = await nodemailer
      .createTestAccount();
      return configEmailTeste(contaTeste);
  }
}

class Email {
  async enviaEmail() {
    const configEmail = await criaConfigEmail();
    const transportador = nodemailer.createTransport(configEmail);
    const info = await transportador.sendMail(this);

    if (process.env.NODE_ENV !== 'production') {
      console.log('URL: ' + nodemailer.getTestMessageUrl(info));
    }

  }
}

class EmailVerificacao extends Email {
  constructor(usuario, endereco) {
    super();
    this.from = '"Blog do Código" <noreply@blogdocodigo.com.br>';
    this.to = usuario.email;
    this.subject = "Email de verificação";
    this.html = `
      <h1>Olá!</h1>
      <br>
      <p>Verifique seu email aqui:</p>
      <br>
      <a href="${endereco}">${endereco}</a>
    `;
  }
}

module.exports = { EmailVerificacao };