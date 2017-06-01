package br.com.secureedges.core.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.secureedges.core.IDAO;
import br.com.secureedges.core.util.factory.Conexao;
import br.com.secureedges.domain.Dispositivo;
import br.com.secureedges.domain.EntidadeDominio;
import br.com.secureedges.util.FacesUtil;

public class RelatorioDAO implements IDAO {

	public Long Salvar(EntidadeDominio entidade) throws SQLException {

		return null;

	}

	public void Editar(EntidadeDominio entidade) throws SQLException {

	}

	public void Excluir(EntidadeDominio entidade) {

	}

	public List<EntidadeDominio> listar() {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT sol.sol_Codigo,disp.disp_codigo,disp.disp_descricao,sol.sol_data,count(*) from (tb_solicitacao as sol) inner join (tb_dispositivo as disp) "
						+ "on sol.tb_Dispositivo_disp_Codigo = disp.disp_codigo group by(disp.disp_codigo)"
						+ "order by MONTH(sol.sol_data),disp.disp_codigo;");
		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();

		Connection con = Conexao.getConnection();

		try {
			PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql.toString());
			ResultSet rSet = pstm.executeQuery();

			while (rSet.next()) {

				Dispositivo dispositivo = new Dispositivo();
				dispositivo.setCodigo(rSet.getLong("disp_Codigo"));
				dispositivo.setDescricao(rSet.getString("disp_Descricao"));
				dispositivo.getComodo().setCodigo(rSet.getLong("cmdo_Codigo"));
				dispositivo.getTP_Dispositivo().setCodigo(rSet.getLong("tp_disp_Codigo"));
				dispositivo.setInterface_Arduino(rSet.getLong("interface_Arduino"));
				dispositivo.setDisp_status(rSet.getInt("disp_status"));

				lista.add(dispositivo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			FacesUtil.adicionarMSGError(e.getMessage());
		}

		return lista;

	}

	public EntidadeDominio buscarPorCodigo(Long codigo) {

		return null;
	}

	@Override
	public EntidadeDominio consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}

