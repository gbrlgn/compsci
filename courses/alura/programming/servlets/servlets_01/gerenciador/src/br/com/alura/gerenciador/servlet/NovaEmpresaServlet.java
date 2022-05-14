package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("Cadastrando nova empresa.");
        String nomeEmpresa = req.getParameter("nome");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Empresa " + nomeEmpresa + " cadastrada com sucesso.");
        out.println("</body>");
        out.println("</html>");
    }

}