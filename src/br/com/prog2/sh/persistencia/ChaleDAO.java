package br.com.prog2.sh.persistencia;

import java.util.List;

import br.com.prog2.sh.model.Chale;

public interface ChaleDAO {
	public String inserir(Chale ch);
	public String alterar(Chale ch);
	public String excluir(Chale ch);

	public List<Chale> listarTodos();
	public Chale pesquisarPorCod(String codChale);
}
