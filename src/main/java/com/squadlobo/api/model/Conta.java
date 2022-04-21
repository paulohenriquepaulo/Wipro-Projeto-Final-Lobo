package com.squadlobo.api.model;

import com.squadlobo.api.model.exceptions.DepositoInvalidoException;
import com.squadlobo.api.model.exceptions.SaldoInsuficienteException;

import javax.persistence.*;

@MappedSuperclass
public abstract class Conta  {

    @Id
    private String numeroConta;
    private Double saldo;
    private String cartaoCredito;
	private Double limiteCartaoCredito;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpf_cliente")
    private Cliente cliente;

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }    

    public String getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public Double getLimiteCartaoCredito() {
		return limiteCartaoCredito;
	}

	public void setLimiteCartaoCredito(Double limiteCartaoCredito) {
		this.limiteCartaoCredito = limiteCartaoCredito;
	}

	public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public abstract void sacar(Double valor) throws SaldoInsuficienteException;

    public abstract void depositar(Double valor) throws DepositoInvalidoException;

}
