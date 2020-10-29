package br.com.prog2.sh.model;

import java.time.LocalDate;

public class Cliente {
	private String codCliente;
	private String nomeCliente;
	private String rgCliente;
	private String bairroCliente;
	private String cidadeCliente;
	private String estadoCliente;
	private String CEPCliente;
	private LocalDate NascimentoCliente;
	
	public Cliente() {}
	
	public String getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getRgCliente() {
		return rgCliente;
	}
	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}
	public String getBairroCliente() {
		return bairroCliente;
	}
	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}
	public String getCidadeCliente() {
		return cidadeCliente;
	}
	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}
	public String getEstadoCliente() {
		return estadoCliente;
	}
	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}
	public String getCEPCliente() {
		return CEPCliente;
	}
	public void setCEPCliente(String CEPCliente) {
		this.CEPCliente = CEPCliente;
	}
	public LocalDate getNascimentoCliente() {
		return NascimentoCliente;
	}
	public void setNascimentoCliente(LocalDate NascimentoCliente) {
		this.NascimentoCliente = NascimentoCliente;
	}
	
	
}
