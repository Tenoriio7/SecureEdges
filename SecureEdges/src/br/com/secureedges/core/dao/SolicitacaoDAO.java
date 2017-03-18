package br.com.secureedges.core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.secureedges.core.IDAO;
import br.com.secureedges.core.util.factory.Conexao;
import br.com.secureedges.domain.EntidadeDominio;
import br.com.secureedges.domain.Solicitacao;
import br.com.secureedges.util.FacesUtil;

public class SolicitacaoDAO implements IDAO {

	public Long Salvar(EntidadeDominio entidade) throws SQLException {

		Solicitacao solicitacao = new Solicitacao();
		solicitacao = (Solicitacao) entidade;
		Long codigo = null;

		StringBuffer sql = new StringBuffer();

		sql.append(
				"INSERT INTO db_secureedges.tb_solicitacao(sol_Codigo,sol_Status,tb_Dispositivo_disp_Codigo,tb_Comodo_cmdo_Codigo,sol_descricao,sol_data,tb_Usuario_usr_Codigo");
		sql.append(" VALUES (?,?,?,?,?,?,?)");
		Connection con = Conexao.getConnection();
		PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql.toString(),
				Statement.RETURN_GENERATED_KEYS);

		try {
			SimpleDateFormat stf = new SimpleDateFormat("yyyy/MM/dd");
			String vendaHorario = stf.format(solicitacao.getData());

			int i = 0;
			pstm.setLong(++i, solicitacao.getCodigo());
			pstm.setString(++i, solicitacao.getStatus());
			pstm.setLong(++i, solicitacao.getDispositivo().getCodigo());
			pstm.setLong(++i, solicitacao.getComodo().getCodigo());
			pstm.setString(++i, solicitacao.getDescricao());
			pstm.setDate(++i,(Date) solicitacao.getData());
			pstm.setLong(++i, solicitacao.getUsuario().getCodigo());

			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			FacesUtil.adicionarMSGError(e.getMessage());
			return null;
		}
		ResultSet rset = pstm.getGeneratedKeys();
		while (rset.next()) {
			codigo = (long) rset.getInt(1);

		}
		codigo = Long.parseLong(codigo.toString());
		return codigo;

	}

	public void Editar(EntidadeDominio entidade) throws SQLException {
		if (!(entidade instanceof Solicitacao))
			return;

		Solicitacao solicitacao = new Solicitacao();
		solicitacao = (Solicitacao) entidade;

		StringBuffer sql = new StringBuffer();

		sql.append("UPDATE db_secureedges.tb_solicitacao set sol_Status = ? ");
		sql.append("WHERE sol_Codigo=?");

		Connection con = Conexao.getConnection();

		try {
			PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql.toString());
			int i = 0;
			pstm.setString(++i, solicitacao.getStatus());
			pstm.setLong(++i, solicitacao.getCodigo());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			FacesUtil.adicionarMSGError(e.getMessage());
		}

	}

	public void Excluir(EntidadeDominio entidade) throws SQLException {
		if (!(entidade instanceof Solicitacao))
			return;

		Solicitacao solicitacao = new Solicitacao();
		solicitacao = (Solicitacao) entidade;

		StringBuffer sql = new StringBuffer();
		sql.append("delete from db_secureedges.tb_solicitacao where sol_Codigo = ?");

		Connection con = Conexao.getConnection();

		try {
			PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql.toString());
			pstm.setLong(1, solicitacao.getCodigo());
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.adicionarMSGError((e.getMessage()));
		}

	}

	public List<EntidadeDominio> listar() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM db_secureedges.tb_solicitacao");
		sql.append(" order by db_secureedges.tb_solicitacao.sol_Codigo ;");
		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();

		Connection con = Conexao.getConnection();

		try {
			PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql.toString());
			ResultSet rSet = pstm.executeQuery();

			while (rSet.next()) {

				Solicitacao solicitacao = new Solicitacao();
				solicitacao.setCodigo(rSet.getLong("sol_Codigo"));
				solicitacao.setStatus((rSet.getString("sol_Status")));
				solicitacao.getUsuario().setCodigo((rSet.getLong("tb_Dispositivo_disp_Codigo")));
				solicitacao.getUsuario().setCodigo((rSet.getLong("tb_usuario_usr_Codigo")));
				lista.add(solicitacao);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			FacesUtil.adicionarMSGError(e.getMessage());
		}

		return lista;
	}

	@Override
	public EntidadeDominio buscarPorCodigo(Long codigo) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM db_secureedges.tb_solicitacao");
		sql.append(" where tb_solicitacao.sol_Codigo =?");

		Connection con = Conexao.getConnection();
		Solicitacao solicitacao = new Solicitacao();

		try {
			PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql.toString());
			ResultSet rSet = pstm.executeQuery();

			while (rSet.next()) {

				solicitacao.setCodigo(rSet.getLong("sol_Codigo"));
				solicitacao.setStatus((rSet.getString("sol_Status")));
				solicitacao.getUsuario().setCodigo((rSet.getLong("tb_Dispositivo_disp_Codigo")));
				solicitacao.getUsuario().setCodigo((rSet.getLong("tb_usuario_usr_Codigo")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			FacesUtil.adicionarMSGError(e.getMessage());
		}

		return solicitacao;
	}

	@Override
	public EntidadeDominio consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}
}
