package br.com.prog2.sh.persistencia;

import java.util.List;

import br.com.prog2.sh.model.Hospedagem;

public interface HospedagemDAO {
	public String inserir(Hospedagem hosp);
	public String alterar(Hospedagem hosp);
	public String excluir(Hospedagem hosp);
	public List<Hospedagem> listarTodos();
	public List<Hospedagem> pesquisarPorHospedagens(String cpf);
}
