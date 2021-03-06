package br.com.prog2.sh.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.sh.model.Hospedagem;
import br.com.prog2.sh.persistencia.ConnectionFactory;

public class HospedagemController {
	public String inserir(Hospedagem hosp) {
		String sql = "insert into hospedagem(codHospedagem, codChale, estado, dataInicio, dataFim, qtdPessoas, desconto, valorFinal) values(?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, hosp.getCodHospedagem());
			pst.setString(2, hosp.getCodChale());
			pst.setString(3, hosp.getEstado());
			pst.setObject(4, hosp.getDataInicio());
			pst.setObject(5, hosp.getDataFim());
			pst.setInt(6, hosp.getQtdPessoas());
			pst.setDouble(7, hosp.getDesconto());
			pst.setDouble(8, hosp.getValorFinal());
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

	public String alterar(Hospedagem hosp) {
		String sql = "update hospedagem set estado=?," + "dataInicio=?," + "dataFim=?," + "qtdPessoas=?," + "desconto=?," + "valorFinal=?"
				+ " where codHospedagem=? and codChale=?";
		Connection con = ConnectionFactory.getConnection();

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, hosp.getEstado());
			pst.setObject(2, hosp.getDataInicio());
			pst.setObject(3, hosp.getDataFim());
			pst.setInt(4, hosp.getQtdPessoas());
			pst.setDouble(5, hosp.getDesconto());
			pst.setDouble(6, hosp.getValorFinal());
			pst.setString(7, hosp.getCodHospedagem());
			pst.setString(8, hosp.getCodChale());
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

	public String excluir(Hospedagem hosp) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from hospedagem where codHospedagem=? " + "and codChale=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, hosp.getCodHospedagem());
			pst.setString(2, hosp.getCodChale());
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

	public List<Hospedagem> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from hospedagem order by codHospedagem;");
		Connection con = ConnectionFactory.getConnection();
		List<Hospedagem> lista = new ArrayList<>();

		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Hospedagem hosp = new Hospedagem();
					hosp.setCodHospedagem(rs.getString(1));
					hosp.setCodChale(rs.getString(2));
					hosp.setEstado(rs.getString(3));
					hosp.setDataInicio(rs.getObject(4, LocalDate.class));
					hosp.setDataFim(rs.getObject(5, LocalDate.class));
					hosp.setQtdPessoas(rs.getInt(6));
					hosp.setDesconto(rs.getDouble(7));
					hosp.setValorFinal(rs.getDouble(8));
					lista.add(hosp);
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

	public Hospedagem pesquisarPorHospedagens(String codHospedagem) {
		String sql = "select * from hospedagem where codHospedagem=? and codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codHospedagem);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Hospedagem hosp = new Hospedagem();
				//hosp.setCodHospedagem(rs.getString(1));
				hosp.setCodChale(rs.getString(2));
				hosp.setEstado(rs.getString(3));
				hosp.setDataInicio(rs.getObject(4, LocalDate.class));
				hosp.setDataFim(rs.getObject(5, LocalDate.class));
				hosp.setQtdPessoas(rs.getInt(6));
				hosp.setDesconto(rs.getDouble(7));
				hosp.setValorFinal(rs.getDouble(8));
				return hosp;
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
