package br.com.myquimica.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.com.myquimica.database.DbUtil;
import br.com.myquimica.model.Aluno;


public class AlunoDAO {
	private Connection connection;

	public AlunoDAO() {
		connection = DbUtil.getConnection();
	}

	public List<Aluno> getAllAlunos() {
		List<Aluno> alunos = new LinkedList<Aluno>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from aluno");
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("codigo"));
				aluno.setNome(rs.getString("nome"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setEmail(rs.getString("email"));

				alunos.add(aluno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alunos;
	}
}
