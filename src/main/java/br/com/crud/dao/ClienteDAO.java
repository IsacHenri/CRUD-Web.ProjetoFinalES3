package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.com.crud.modelo.Cartao;
import br.com.crud.modelo.Cidade;
import br.com.crud.modelo.Cliente;
import br.com.crud.modelo.Endereco;
import br.com.crud.modelo.EntidadeDominio;
import br.com.crud.modelo.Estado;
import br.com.crud.modelo.Login;
import br.com.crud.modelo.Pais;
import br.com.crud.modelo.Telefone;

public class ClienteDAO extends AbstractDAO implements IDAO {

	public ClienteDAO(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {

		Cliente cliente = (Cliente) entidade;
		StringBuilder sql = new StringBuilder();
		PreparedStatement st = null;
		ResultSet rs = null;

		openConnection();
		con.setAutoCommit(false);

		sql.append("INSERT INTO cliente(cli_nome, cli_genero,");
		sql.append("cli_data_nascimento, cli_cpf, cli_email, cli_senha)");
		sql.append("VALUES (?, ?, ?, ?, ?, ?)");

		try {

			st = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			st.setString(1, cliente.getNome());
			st.setString(2, cliente.getGenero());
			String dataNascimentoString = cliente.getDtNascimento();
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

			try {
				// Convertendo a string para um objeto Date
				Date dataNascimento = formato.parse(dataNascimentoString);

				// Define a data no objeto st
				st.setDate(3, new java.sql.Date(dataNascimento.getTime()));
			} catch (ParseException e) {
				// Trate a exceção se a string não puder ser convertida para uma data
				e.printStackTrace(); // ou faça outro tratamento apropriado
			}
			st.setString(4, cliente.getCpf());
			st.setString(5, cliente.getLogin().getEmail());
			st.setString(6, cliente.getLogin().getSenha());
			st.execute();

			rs = st.getGeneratedKeys();
			while (rs.next()) {
				int idCliente = 0;

				idCliente = rs.getInt(1);
				cliente.setId(idCliente);

				salvarTelefone(cliente);
				salvarCartao(cliente);
				salvarEndereco(cliente);

			}
			con.commit();

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void salvarTelefone(Cliente cliente) throws SQLException {

		PreparedStatement st = null;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO telefone (tel_numero, tel_cli_id) VALUES (?, ?)");

		try {

			st = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			st.setString(1, cliente.getTelefone().getNumero());
			st.setInt(2, cliente.getId());

			st.execute();

			con.commit();

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void salvarCartao(Cliente cliente) throws SQLException {

		PreparedStatement st = null;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cartao (crt_numero,crt_nome_impresso,crt_codigo,"
				+ "crt_bandeira,crt_cli_id) VALUES (?,?,?,?,?)");

		try {

			st = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			st.setString(1, cliente.getCartao().getNumero());
			st.setString(2, cliente.getCartao().getNomeImpresso());
			st.setString(3, cliente.getCartao().getCodigo());
			st.setString(4, cliente.getCartao().getBandeira());
			st.setInt(5, cliente.getId());

			st.execute();

			con.commit();

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void salvarEndereco(Cliente cliente) throws SQLException {

		PreparedStatement st = null;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO endereco (end_logradouro, end_numero, ");
		sql.append("end_bairro,end_cep,end_cidade,end_estado,end_pais,"
				+ "end_tipo_endereco,end_tipo_residencia,end_tipo_logradouro,"
				+ "end_cli_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

		try {

			st = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			for (Endereco endereco : cliente.getEndereco()) {

				st.setString(1, endereco.getLogradouro());
				st.setString(2, endereco.getNumero());
				st.setString(3, endereco.getBairro());
				st.setString(4, endereco.getCep());
				st.setString(5, endereco.getCidade().getNome());
				st.setString(6, endereco.getCidade().getEstado().getNome());
				st.setString(7, endereco.getCidade().getEstado().getPais().getNome());
				st.setString(8, endereco.getTipoEndereco());
				st.setString(9, endereco.getTipoResidencia());
				st.setString(10, endereco.getTipoLogradouro());
				st.setInt(11, cliente.getId());

				st.execute();
//
//				con.commit();

			}

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		Login login = null;
		Cartao cartao = null;
		Telefone telefone = null;

		PreparedStatement st = null;
		ResultSet rs = null;

		ArrayList<EntidadeDominio> listaDeClientes = new ArrayList<>();
		ArrayList<Endereco> listaDeEnderecos = new ArrayList<>();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT cli_id, cli_nome, cli_genero, cli_data_nascimento, "
				+ "cli_cpf, cli_email, cli_senha FROM cliente WHERE 1=1");

		// Verifica se um nome específico foi fornecido
		if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
			sql.append(" AND cli_nome LIKE ?  ORDER BY cli_nome;"); // Adiciona a condição se um nome específico foi
																	// fornecido
		}

		openConnection();

		try {
			st = con.prepareStatement(sql.toString());

			int paramIndex = 1;

			// Define parâmetros da consulta
			if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
				st.setString(paramIndex++, "%" + cliente.getNome() + "%");
			}
			st.executeQuery();
			rs = st.getResultSet();

			while (rs.next()) {
				login = new Login(rs.getString("cli_email"), rs.getString("cli_senha"));
				cliente = new Cliente(rs.getString("cli_nome"), rs.getString("cli_genero"), rs.getString("cli_cpf"),
						rs.getString("cli_data_nascimento"), login);

				cliente.setId(rs.getInt("cli_id"));

				listaDeEnderecos = consultarEnderecos(cliente);

				for (Endereco end : listaDeEnderecos) {
					cliente.setEndereco(end);
				}

				cartao = consultarCartao(cliente);
				telefone = consultarTelefone(cliente);
				cliente.setCartao(cartao);
				cliente.setTelefone(telefone);

				listaDeClientes.add(cliente);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaDeClientes;
	}

	public ArrayList<Endereco> consultarEnderecos(Cliente cliente) throws SQLException {

		Endereco endereco = null;
		Cidade cidade = null;
		Estado estado = null;
		Pais pais = null;
		ResultSet rs = null;
		PreparedStatement st = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT end_id, end_logradouro, end_numero, end_bairro, "
				+ "end_cep, end_cidade, end_estado, end_pais, end_tipo_endereco,"
				+ "end_tipo_residencia,end_tipo_logradouro, end_cli_id "
				+ "FROM endereco where end_cli_id = ? order by end_cli_id;");

		ArrayList<Endereco> listaDeEndereco = new ArrayList<>();

		st = con.prepareStatement(sql.toString());

		st.setInt(1, cliente.getId());

		st.executeQuery();

		rs = st.getResultSet();

		while (rs.next()) {
			pais = new Pais(rs.getString("end_pais"));
			estado = new Estado(rs.getString("end_estado"), pais);
			cidade = new Cidade(rs.getString("end_cidade"), estado);

			endereco = new Endereco(rs.getString("end_logradouro"), rs.getString("end_cep"), cidade,
					rs.getString("end_numero"), rs.getString("end_tipo_endereco"), rs.getString("end_tipo_residencia"),
					rs.getString("end_tipo_logradouro"), rs.getString("end_bairro"));
			endereco.setId(rs.getInt("end_id"));
			listaDeEndereco.add(endereco);
		}
		return listaDeEndereco;
	}

	public Cartao consultarCartao(Cliente cliente) throws SQLException {
		Cartao cartao = null;
		ResultSet rs = null;
		PreparedStatement st = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT crt_id, crt_numero, crt_nome_impresso, crt_codigo, crt_bandeira,"
				+ " crt_cli_id FROM cartao where crt_cli_id = ? order by crt_cli_id;");

		st = con.prepareStatement(sql.toString());

		st.setInt(1, cliente.getId());

		st.executeQuery();

		rs = st.getResultSet();

		while (rs.next()) {

			cartao = new Cartao(rs.getString("crt_numero"), rs.getString("crt_nome_impresso"),
					rs.getString("crt_codigo"), rs.getString("crt_bandeira"));
		}
		return cartao;
	}

	public Telefone consultarTelefone(Cliente cliente) throws SQLException {
		Telefone telefone = null;
		ResultSet rs = null;
		PreparedStatement st = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT tel_id, tel_numero, tel_cli_id FROM telefone where tel_cli_id = ? order by tel_cli_id;");

		st = con.prepareStatement(sql.toString());

		st.setInt(1, cliente.getId());

		st.executeQuery();

		rs = st.getResultSet();

		while (rs.next()) {

			telefone = new Telefone(rs.getString("tel_numero"));
		}
		return telefone;
	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		openConnection();

		Cliente cliente = (Cliente) entidade;
		StringBuilder sql = new StringBuilder();
		PreparedStatement st = null;

		sql.append("UPDATE cliente SET cli_nome=?, cli_genero=?, cli_cpf=?,cli_senha=?  WHERE cli_id=?");
		con.setAutoCommit(false);

		try {
			st = con.prepareStatement(sql.toString());

			st.setString(1, cliente.getNome());
			st.setString(2, cliente.getGenero());

			st.setString(3, cliente.getCpf());
			st.setString(4, cliente.getLogin().getSenha());
			st.setInt(5, cliente.getId());

			st.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		if (entidade instanceof Cliente) {
			Cliente cliente = (Cliente) entidade;
			PreparedStatement stEnderecos = null;
			PreparedStatement stCartao = null;
			PreparedStatement stTelefone = null;
			PreparedStatement stCliente = null;

			try {
				openConnection();

				// Excluindo endereços associados ao cliente
				String deleteEnderecosSQL = "DELETE FROM endereco WHERE end_cli_id = ?";
				stEnderecos = con.prepareStatement(deleteEnderecosSQL);
				stEnderecos.setInt(1, cliente.getId());
				stEnderecos.executeUpdate();

				// Excluindo cartão associado ao cliente
				String deleteCartaoSQL = "DELETE FROM cartao WHERE crt_cli_id = ?";
				stCartao = con.prepareStatement(deleteCartaoSQL);
				stCartao.setInt(1, cliente.getId());
				stCartao.executeUpdate();

				// Excluindo telefone associado ao cliente
				String deleteTelefoneSQL = "DELETE FROM telefone WHERE tel_cli_id = ?";
				stTelefone = con.prepareStatement(deleteTelefoneSQL);
				stTelefone.setInt(1, cliente.getId());
				stTelefone.executeUpdate();

				// Excluindo o próprio cliente
				String deleteClienteSQL = "DELETE FROM cliente WHERE cli_id = ?";
				stCliente = con.prepareStatement(deleteClienteSQL);
				stCliente.setInt(1, cliente.getId());
				stCliente.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (stEnderecos != null) {
						stEnderecos.close();
					}
					if (stCartao != null) {
						stCartao.close();
					}
					if (stTelefone != null) {
						stTelefone.close();
					}
					if (stCliente != null) {
						stCliente.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			
		}
	}

}
