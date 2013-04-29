package br.com.myquimica.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.com.myquimica.database.Banco;
import br.com.myquimica.database.DbUtil;
import br.com.myquimica.model.Aluno;
import br.com.myquimica.model.Mistura;


public class MisturaDAO {
	private Connection connection;
	private static MisturaDAO instance;
	
	public static MisturaDAO getInstance(){
		if(instance==null)
			instance = new MisturaDAO();
		return instance;
	}


	public MisturaDAO() {
		connection = DbUtil.getConnection();
	}

	public List<Mistura> getAllMisturas() {
		List<Mistura> misturas = new LinkedList<Mistura>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from mistura");
			while (rs.next()) {
				Mistura mistura = new Mistura();
				mistura.setId(rs.getInt("id"));
				mistura.setNome(rs.getString("nome"));
				mistura.setMistura(rs.getString("mistura"));
				mistura.setDica(rs.getString("dica"));
				mistura.setInformacao(rs.getString("informacao"));
				
				misturas.add(mistura);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return misturas;
	}
}
