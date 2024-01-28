package br.com.crud.fachada;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.crud.controle.Conexao;
import br.com.crud.dao.ClienteDAO;
import br.com.crud.dao.EnderecoDAO;
import br.com.crud.dao.IDAO;
import br.com.crud.modelo.Cliente;
import br.com.crud.modelo.Endereco;
import br.com.crud.modelo.EntidadeDominio;
//import br.com.crud.modelo.Funcionario;
import br.com.crud.strategy.ComplementarDtCadastro;
import br.com.crud.strategy.IStrategy;
import br.com.crud.strategy.PreechimentoEndereco;
import br.com.crud.strategy.ValidarCliente;
import br.com.crud.strategy.ValidarCpf;

public class Fachada implements IFachada {

	private Map<String, IDAO> daos;
	private Map<String, List<IStrategy>> rns;

	public Fachada() {
		daos = new HashMap<String, IDAO>();
		Conexao conn = new Conexao();
		Connection connection = conn.recuperarConexao();
		daos.put(Cliente.class.getName(), new ClienteDAO(connection));
		daos.put(Endereco.class.getName(), new EnderecoDAO(connection));

		rns = new HashMap<String, List<IStrategy>>();

		ValidarCliente vCliente = new ValidarCliente();
		ValidarCpf vCpf = new ValidarCpf();
		ComplementarDtCadastro cDt = new ComplementarDtCadastro();
		PreechimentoEndereco pEnd = new PreechimentoEndereco();

		List<IStrategy> rnsCliente = new ArrayList<IStrategy>();
		rnsCliente.add(vCliente);
		rnsCliente.add(vCpf);
		rnsCliente.add(cDt);

		List<IStrategy> rnsFuncionario = new ArrayList<IStrategy>();
		rnsFuncionario.add(vCpf);
		rnsFuncionario.add(cDt);
		
		List<IStrategy> rnsEndereco = new ArrayList<IStrategy>();
		rnsEndereco.add(pEnd);

		rns.put(Cliente.class.getName(), rnsCliente);
//		rns.put(Funcionario.class.getName(), rnsFuncionario);
		rns.put(Endereco.class.getName(), rnsEndereco);

	}

	public String salvar(EntidadeDominio entidade) {
		String nmClass = entidade.getClass().getName();

		List<IStrategy> rnEntidade = rns.get(nmClass);
		StringBuilder sb = new StringBuilder();
		for (IStrategy s : rnEntidade) {
			String msg = s.processar(entidade);
			if (msg != null) {
				sb.append(msg);
			}
		}
		if (sb.length() > 0) {
			return sb.toString();
		} else {
			IDAO dao = daos.get(nmClass);
			try {
				dao.salvar(entidade);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

	}

	public String alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		String nmClass = entidade.getClass().getName();
	    List<IStrategy> rnEntidade = rns.get(nmClass);
	    StringBuilder msgs = new StringBuilder();

	    for (IStrategy s : rnEntidade) {
	        String msg = s.processar(entidade);
	        if (msg != null) {
	            System.out.println(msgs.append(msg));
	        }
	    }

	    if (msgs.length() == 0) {
	        IDAO dao = daos.get(nmClass);
	        try {
	            dao.alterar(entidade);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return "Erro ao realizar a alteração.";
	        }
	    } else {
	        return msgs.toString();
	    }
	    
	    return "Alteração realizada com sucesso.";
	}

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		String nmClasse = entidade.getClass().getName();
		List<EntidadeDominio> lista = new ArrayList<>();

		IDAO dao = daos.get(nmClasse);
		try {
			lista = dao.consultar(entidade);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public String excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		String nmClasse = entidade.getClass().getName();

		IDAO dao = daos.get(nmClasse);
		try {
			dao.excluir(entidade);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
