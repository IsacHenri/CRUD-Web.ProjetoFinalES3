package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.modelo.Cidade;
import br.com.crud.modelo.Endereco;
import br.com.crud.modelo.EntidadeDominio;
import br.com.crud.modelo.Estado;
import br.com.crud.modelo.Pais;

public class EnderecoDAO extends AbstractDAO implements IDAO {



	public EnderecoDAO(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		openConnection();

		Endereco endereco = (Endereco) entidade;
		PreparedStatement st = null;
		StringBuilder sql = new StringBuilder();

		sql.append("update endereco set end_logradouro=?, end_numero=?, end_bairro=?, end_cep=?, ");
		sql.append("end_cidade=?, end_estado=?, end_pais=?, end_tipo_endereco=?, ");
		sql.append("end_tipo_residencia=?, end_tipo_logradouro=? where  end_id=?");
		con.setAutoCommit(false);

		try {
			st = con.prepareStatement(sql.toString());

				
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
//				st.setInt(11, endereco.getId());
				st.setInt(11, endereco.getId());

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
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		Endereco endereco = (Endereco) entidade;
		Cidade cidade = null;
		Estado estado = null;
		Pais pais = null;
		ResultSet rs = null;
		PreparedStatement st = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT end_id, end_logradouro, end_numero, end_bairro, end_cep, end_cidade, end_estado, end_pais, end_tipo_endereco,end_tipo_residencia,end_tipo_logradouro, end_cli_id FROM endereco where end_id = ? order by end_id;");

		List<EntidadeDominio> listaDeEndereco = new ArrayList<>();

		st = con.prepareStatement(sql.toString());

		st.setInt(1, endereco.getCliente().getId());

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

}
