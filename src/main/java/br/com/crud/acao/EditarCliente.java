package br.com.crud.acao;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.Cliente;
import br.com.crud.modelo.EntidadeDominio;

public class EditarCliente implements IAcao {
    
    @Override
    public String getEntidade(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String idString = request.getParameter("id");

        // Verifica se a String contém apenas dígitos
        if (idString.matches("\\d+")) {
            int idCliente = Integer.parseInt(idString);

            Fachada fac = new Fachada();
            Cliente clienteConsulta = new Cliente(idCliente);
            List<EntidadeDominio> clis = fac.consultar(clienteConsulta);
            Cliente cliente = new Cliente(0);
            
            for(EntidadeDominio cli : clis) {
                if(cli.getId() == idCliente) {
                    cliente = (Cliente) cli;
                }
            }

            // Adiciona o objeto ao request
            request.setAttribute("cliente", cliente);

            
            System.out.println("Cheguei aqui oooo");
        }
        
        return ""; 
    }
}
