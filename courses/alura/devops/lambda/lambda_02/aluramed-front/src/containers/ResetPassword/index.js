import React, { useState } from "react";
import { Link } from "react-router-dom";
import Form from "react-bootstrap/Form";
import { Auth } from "aws-amplify";
import LoaderButton from "../../components/LoaderButton";
import { useFormFields } from "../../libs/hooksLib";
import { onError } from "../../libs/errorLib";
import "./style.css";

export default function ResetPassword() {
  const [fields, handleFieldChange] = useFormFields({
    code: "",
    email: "",
    password: "",
    confirmPassword: "",
  });
  const [codeSent, setCodeSent] = useState(false);
  const [confirmed, setConfirmed] = useState(false);
  const [isConfirming, setIsConfirming] = useState(false);
  const [isSendingCode, setIsSendingCode] = useState(false);
  const [validateCode, setValidateCode] = useState(false);
  const [validateReset, setValidateReset] = useState(false);

  function validateResetForm() {
    return (
      fields.password === fields.confirmPassword
    );
  }

  async function handleSendCodeClick(event) {
    const form = event.currentTarget;

    event.preventDefault();
    event.stopPropagation();

    setValidateCode(true);

    if (form.checkValidity()) {
      setIsSendingCode(true);

      try {
        await Auth.forgotPassword(fields.email);
        setCodeSent(true);
      } catch (error) {
        onError(error);
        setIsSendingCode(false);
      }
    }
  }

  async function handleConfirmClick(event) {
    const form = event.currentTarget;

    event.preventDefault();
    event.stopPropagation();

    setValidateReset(true);

    if (form.checkValidity()) {
      setIsConfirming(true);

      try {
        await Auth.forgotPasswordSubmit(
          fields.email,
          fields.code,
          fields.password
        );
        setConfirmed(true);
      } catch (error) {
        onError(error);
        setIsConfirming(false);
      }
    }
  }

  function renderRequestCodeForm() {
    return (
      <Form noValidate validated={validateCode} onSubmit={handleSendCodeClick}>
        <Form.Group size="large" controlId="email">
          <Form.Label>E-mail</Form.Label>
          <Form.Control
            required
            autoFocus
            type="email"
            value={fields.email}
            onChange={handleFieldChange}
          />
          <Form.Control.Feedback type="invalid">
            E-mail ?? obrigat??rio.
          </Form.Control.Feedback>
        </Form.Group>
        <LoaderButton
          block
          type="submit"
          size="large"
          isLoading={isSendingCode}
        >
          Enviar c??digo
        </LoaderButton>
      </Form>
    );
  }

  function renderConfirmationForm() {
    return (
      <Form noValidate validated={validateReset} onSubmit={handleConfirmClick}>
        <Form.Group size="large" controlId="code">
          <Form.Label>C??digo de confirma????o</Form.Label>
          <Form.Control
            required
            autoFocus
            type="text"
            value={fields.code}
            onChange={handleFieldChange}
          />
          <Form.Text className="text-muted">
            O c??digo de confirma????o foi enviado para o e-mail cadastrado.
          </Form.Text>
          <Form.Control.Feedback type="invalid">
            C??digo de confirma????o ?? obrigat??rio.
          </Form.Control.Feedback>
        </Form.Group>
        <hr />
        <Form.Group size="large" controlId="password">
          <Form.Label>Nova senha</Form.Label>
          <Form.Control
            required
            minLength={8}
            type="password"
            value={fields.password}
            onChange={handleFieldChange}
          />
          <Form.Text className="text-muted">
            A senha deve ser de no m??nimo 8 caracterer e conter letras, n??meros e caracteres especiais.
          </Form.Text>
          <Form.Control.Feedback type="invalid">
            Nova senha ?? obrigat??rio.
          </Form.Control.Feedback>
        </Form.Group>
        <Form.Group size="large" controlId="confirmPassword">
          <Form.Label>Confirmar a senha</Form.Label>
          <Form.Control
            required
            minLength={8}
            type="password"
            value={fields.confirmPassword}
            onChange={handleFieldChange}
          />
          <Form.Control.Feedback type="invalid">
            Confirmar senha ?? obrigat??rio.
          </Form.Control.Feedback>
        </Form.Group>
        <LoaderButton
          block
          type="submit"
          size="large"
          isLoading={isConfirming}
          disabled={!validateResetForm()}
        >
          Confirmar
        </LoaderButton>
      </Form>
    );
  }

  function renderSuccessMessage() {
    return (
      <div className="success">
        <p>Sua senha foi alterada.</p>
        <p>
          <Link to="/login">
            Clique aqui para fazer o login com as suas novas credenciais.
          </Link>
        </p>
      </div>
    );
  }

  return (
    <div className="ResetPassword">
      {!codeSent
        ? renderRequestCodeForm()
        : !confirmed
          ? renderConfirmationForm()
          : renderSuccessMessage()}
    </div>
  );
}
