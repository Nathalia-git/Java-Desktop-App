package br.com.prog2.sh.model;

import java.time.LocalDate;

public class Hospedagem {
	String codHospedagem;
	String codChale;
	String estado;
	LocalDate dataInicio;
	LocalDate dataFim;
	Integer qtdPessoas;
	Double desconto;
	Double valorFinal;	
	
	public Hospedagem() {}  
	
	public Double calculaValor(Double valorFinal, Double desconto) {
		this.valorFinal = valorFinal;
		this.desconto = desconto;
		desconto = desconto/100.0;
		valorFinal = valorFinal - (valorFinal * desconto);
		return valorFinal;
	}
	
	public String getCodHospedagem() {
		return codHospedagem;
	}
	public void setCodHospedagem(String codHospedagem) {
		this.codHospedagem = codHospedagem;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	public Integer getQtdPessoas() {
		return qtdPessoas;
	}
	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public String getCod_chale() {
		return cod_chale;
	}

	public void setCod_chale(String cod_chale) {
		this.cod_chale = cod_chale;
	}
	
}
