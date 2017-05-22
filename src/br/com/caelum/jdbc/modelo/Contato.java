package br.com.caelum.jdbc.modelo;

import java.util.Calendar;

public class Contato {
	  private Long id;
	  private String nome;
	  private String email;
	  private String endereco;
	  private Calendar dataNascimento;

	  public Contato() {
		  this.nome=nome;
		  this.email=email;
		  this.endereco=endereco;
		  this.dataNascimento=dataNascimento;
		  this.id=id;
		// TODO Auto-generated constructor stub
	}
	  // métodos get e set para id, nome, email, endereço e dataNascimento

	  public String getNome() {
	    return this.nome;
	  }
	  public void setNome(String novo) {
	    this.nome = novo;
	  }

	  public String getEmail() {
	    return this.email;
	  }
	  public void setEmail(String novo) {
	    this.email = novo;
	  }

	  public String getEndereco() {
	    return this.endereco;
	  }
	  public void setEndereco(String novo) {
	    this.endereco = novo;
	  }

	  public Long getId() {
	    return this.id;
	  }
	  public void setId(Long novo) {
	    this.id = novo;
	  }

	  public Calendar getDataNascimento() {
	    return this.dataNascimento;
	  }
	  public void setDataNascimento(Calendar dataNascimento) {
	    this.dataNascimento = dataNascimento;
	  }
	}