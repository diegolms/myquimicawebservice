package br.com.myquimica.dao;

import java.sql.Connection;

import br.com.myquimica.database.DbUtil;
import br.com.myquimica.model.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO() {
		connection = DbUtil.getConnection();
	}


	public Usuario getUsuarioByLogin(String login) {
		Usuario usuario = null;
		try {
			
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM usuario WHERE login LIKE '%" + login + "%';";
			ResultSet rs = st.executeQuery(sql);
			
						
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}
}
