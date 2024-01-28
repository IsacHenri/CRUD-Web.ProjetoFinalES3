package br.com.crud.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface IAcao {
	public String getEntidade(HttpServletRequest request, HttpServletResponse response) throws ServletException;
}
