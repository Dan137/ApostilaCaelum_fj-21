package br.com.caelum.jdbc.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.jdbc.ConnectionFactory;

public class ContatoDao {
	private Connection connection;
	private Contato contato;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
		
		
	}
	

	public void adiciona(Contato contato) {
		String sql = "insert into contatos" + "(nome, email, endereco, datanascimento)" + "values (?,?,?,?)";
		try {

			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			
			

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	

	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos ");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto contato
				
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco("endereco");

				// montando data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				// adicionando contatos na lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alteraContato(Contato contato) {
		String sql = "update contato set nome=?, email=?, endereco=?, datanascimento=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date( contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	public void deletarContato (Contato contato){
		String sql = "delete from contatos where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, contato.getId());
			stmt.executeQuery();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}

	public Contato pesquisar(int id, Contato contato) {

		return contato;

	}

}
