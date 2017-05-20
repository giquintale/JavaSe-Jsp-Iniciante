/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.serverlets;

import br.com.Dao.PessoaDao;
import br.com.model.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Huilton
 */
@WebServlet(name = "CadastrarPessoaServlet", urlPatterns = {"/CadastrarPessoaServlet"})
public class CadastrarPessoaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        try {
            PessoaDao pessoaDao = new PessoaDao();
            List<Pessoa> listaPessoa = pessoaDao.listar();
            request.setAttribute("listaPessoa", listaPessoa);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarPessoa.jsp");
            requestDispatcher.forward(request, response);
            response.sendRedirect("ListarPessoa.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarPessoaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Pessoa pessoa = new Pessoa();
            PessoaDao pessoaDao = new PessoaDao();

            pessoa.setNome(request.getParameter("nome"));
            boolean cadastrarPessoa = pessoaDao.cadastrar(pessoa);
            if (cadastrarPessoa) {
                response.sendRedirect("CadastrarPessoa.jsp?sucesso=true");
            } else {
                response.sendRedirect("CadastrarPessoa.jsp?sucesso=false");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastrarPessoaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
