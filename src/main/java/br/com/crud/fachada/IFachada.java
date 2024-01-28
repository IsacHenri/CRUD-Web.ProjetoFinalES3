package br.com.crud.fachada;

import java.util.List;

import br.com.crud.modelo.EntidadeDominio;

public interface IFachada {

	public String salvar(EntidadeDominio entidade);
	public String alterar(EntidadeDominio entidade);
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
	public String excluir(EntidadeDominio entidade);
	
}
