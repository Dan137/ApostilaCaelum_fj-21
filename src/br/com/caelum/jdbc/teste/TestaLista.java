package br.com.caelum.jdbc.teste;

import java.util.List;


import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.modelo.ContatoDao;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.getLista();
		for (Contato contato : contatos) {
			System.out.println("nome: " + contato.getNome());
			System.out.println("email: " + contato.getEmail());
			System.out.println("endereço: " + contato.getEndereco());
			System.out.println("data de nascimento" + contato.getDataNascimento().getTime() + "\n");
			

		}

	}

}
