package br.com.prog2.sh.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.sh.model.Cliente;
import br.com.prog2.sh.persistencia.ConnectionFactory;

public class ClienteController {

	public String inserir(Cliente cli) {
		String sql = "insert into cliente(codCliente, nomeCliente, rgCliente, bairroCliente, cidadeCliente, estadoCliente, CEPCliente, nascimentoCliente) values(?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cli.getCodCliente());
			pst.setString(2, cli.getNomeCliente());
			pst.setString(3, cli.getRgCliente());
			pst.setString(4, cli.getBairroCliente());
			pst.setString(5, cli.getCidadeCliente());
			pst.setString(6, cli.getEstadoCliente());
			pst.setString(7, cli.getCEPCliente());
			pst.setObject(8, cli.getNascimentoCliente());
			int res = pst.executeUpdate();

			if (res > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public String alterar(Cliente cli) {
		String sql = "update cliente set nomeCliente=?," + "rgCliente=?," + "bairroCliente=?," + "cidadeCliente=?," + "estadoCliente=?," + "CEPCliente=?,"
				+ "nascimentoCliente=? where codCliente=?";
		Connection con = ConnectionFactory.getConnection();

		try {
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, cli.getNomeCliente());
			pst.setString(2, cli.getRgCliente());
			pst.setString(3, cli.getBairroCliente());
			pst.setString(4, cli.getCidadeCliente());
			pst.setString(5, cli.getEstadoCliente());
			pst.setString(6, cli.getCEPCliente());
			pst.setObject(7, cli.getNascimentoCliente());
			pst.setString(8, cli.getCodCliente());
			int res = pst.executeUpdate();

			if (res > 0) {
				return "Alterado com sucesso.";
			} else {
				return "Erro ao alterar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public String excluir(Cliente cli) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from cliente where codCliente=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, cli.getCodCliente());
			int res = pst.executeUpdate();

			if (res > 0) {
				return "Excluído com sucesso.";
			} else {
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public List<Cliente> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from cliente order by codCliente");
		Connection con = ConnectionFactory.getConnection();
		List<Cliente> lista = new ArrayList<>();

		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Cliente cli = new Cliente();
					cli.setCodCliente(rs.getString(1));
					cli.setNomeCliente(rs.getString(2));
					cli.setRgCliente(rs.getString(3));
					cli.setBairroCliente(rs.getString(4));
					cli.setCidadeCliente(rs.getString(5));
					cli.setEstadoCliente(rs.getString(6));
					cli.setCEPCliente(rs.getString(7));
					cli.setNascimentoCliente(rs.getObject(8, LocalDate.class));
					lista.add(cli);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	public Cliente pesquisarPorCliente(String codCliente) {
		String sql = "select * from cliente where codCliente=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codCliente);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Cliente cli = new Cliente();
				cli.setCodCliente(rs.getString(1));
				cli.setNomeCliente(rs.getString(2));
				cli.setRgCliente(rs.getString(3));
				cli.setBairroCliente(rs.getString(4));
				cli.setCidadeCliente(rs.getString(5));
				cli.setEstadoCliente(rs.getString(6));
				cli.setCEPCliente(rs.getString(7));
				cli.setNascimentoCliente(rs.getObject(8, LocalDate.class));
				return cli;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}
}
