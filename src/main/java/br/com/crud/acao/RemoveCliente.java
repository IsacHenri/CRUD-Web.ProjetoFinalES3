package br.com.crud.acao;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.Cliente;

public class RemoveCliente implements IAcao {
    
    @Override
    public String getEntidade(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String idString = request.getParameter("id");

        // Verifique se a String contém apenas dígitos
        if (idString.matches("\\d+")) {
            Integer idInt = Integer.valueOf(idString);
            Cliente cli = new Cliente(idInt);
            Fachada fac = new Fachada();
            fac.excluir(cli);
            System.out.println("O cliente de id:" + idString + " foi excluído!");
        } else {
            System.out.println("O valor fornecido para 'id' não é um número válido.");
        }
        
        return "<html></html>";
    }
}

