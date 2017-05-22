package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.ContatoDao;

public class JDBCInsere {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		ContatoDao dao = new ContatoDao();
		// conectando
		Connection conection = null;
		Contato contato=null;

		conection = new ConnectionFactory().getConnection();
		// faz um monte de operações.
		// que podem lançar exceptions runtime e SQLException
		int op = 0;

		System.out.println("informe a operação\n" + "1- cadastrar o contato\n" + "2- atualizar o contato\n"
				+ "3- remover um contato\n" + "0 exit");
		op = sc.nextInt();
		do  {
			switch (op) {
			case 1:
				

					// cria um preparedStatement
					String sql = "insert into contatos" + " (nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";
					PreparedStatement stmt = conection.prepareStatement(sql);

					// preenche os valores

					System.out.println("digite o nome");
					String nome = sc.next();

					System.out.println("digite o email");
					String email = sc.next();

					System.out.println("digite o endereço");
					String endereco = sc.next();
					
					contato = new Contato();
					dao.adiciona(contato);
					// executa
					stmt.execute();
					stmt.close();

					System.out.println("Gravado!");
			
					conection.close();
					break;
				
			case 2:
				String sql1 = "update contato set nome=?, email=?, endereco=?, datanascimento=? where id=?";
				
					PreparedStatement stmt1 = conection.prepareStatement(sql1);
					
					
				

				System.out.println("digite o novo nome");
				 nome = sc.next();
				 System.out.println("digite o novo email");
				 email = sc.next();
				 System.out.println("digite o novo endereço");
				 endereco= sc.next();
				 System.out.println("digite o id");
				 long id = sc.nextLong();
				 
				 stmt1.setString(1,nome);
					stmt1.setString(2, email);
					stmt1.setString(3, endereco);
					stmt1.setLong(4, id);
					stmt1.execute();
					stmt1.close();
				 break;
			case 3:
				String sql2 = "delete table from contatos";
				PreparedStatement stmt2 = conection.prepareStatement(sql2);
				System.out.println("digite o id");
				id= sc.nextLong();
				stmt2.setLong(1, id);
				break;
			case 0:
				System.out.println("obrigado por utilizar a nossa aplicação");

			}

		}while (op != 0);
	}
}
