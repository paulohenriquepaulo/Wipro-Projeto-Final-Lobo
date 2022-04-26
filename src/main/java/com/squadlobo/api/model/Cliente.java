package com.squadlobo.api.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@SQLDelete(sql = "UPDATE cliente SET ativo = false WHERE cpf = ?")
@Where(clause = "ativo = true")
@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Size(min = 11, max = 11, message = "O CPF deve conter 11 digitos!")
	@CPF(message = "CPF inválido!")
	private String cpf;

	@NotBlank(message = "O nome não pode ser nulo ou vazio!")
	private String nome;

	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@Size(min = 10, max = 11, message = "O telefone deve conter 10 ou 11 digitos!")
	@NotBlank(message = "O telefone não pode ser nulo ou vazio!")
	private String telefone;

	@Column(nullable = false)
	private Double rendaMensal;

	private Boolean ativo;

	public Cliente() {
	}

	public Cliente(String nome, String cpf, LocalDate dataNascimento, String telefone, Double rendaMensal) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.rendaMensal = rendaMensal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(Double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}


	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@PrePersist
	public void prePersist() {
		this.setAtivo(Boolean.TRUE);
	}
}

}

