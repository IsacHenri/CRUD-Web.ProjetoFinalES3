package br.com.crud.controle;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Conexao {

	public Connection recuperarConexao() {

		try {
			return createDataSource().getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private HikariDataSource createDataSource() {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		}

		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:postgresql://localhost:5432/Banco");
		config.setUsername("postgres");
		config.setPassword("1234");
		config.setMaximumPoolSize(1);

		return new HikariDataSource(config);
	}

}
