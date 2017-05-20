/* package br.com.secureedges.core.impl.negocio;

import java.math.BigDecimal;

import br.com.secureedges.core.IStrategy;
import br.com.secureedges.util.FacesUtil;
import br.com.secureedges.domain.EntidadeDominio;
import br.com.secureedges.domain.Comodo;
import br.com.secureedges.domain.Dispositivo;;

public class ValidaDadosObrigatoriosDispositivo implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Dispositivo){
			Dispositivo Dispositivo = (Dispositivo)entidade;
			String descricao = Dispositivo.getDescricao();
			Long codigoForn = Dispositivo.getCodigo();
			Long codigoGen = Dispositivo.getGenero().getCodigo();
			Double peso = Dispositivo.getPeso();
			String plataforma = Dispositivo.getPlataforma();
			BigDecimal preco = Dispositivo.getPreco();
			BigDecimal  quantidade = Dispositivo.getQuantidade();
			String setor = Dispositivo.getSetor();
			
			// realizado esse processo para verificar a quantidade
			
			if(descricao==null || codigoForn==null
			|| codigoGen==null || peso==null
			|| plataforma==null || preco==null
			|| quantidade==null || setor==null){
				FacesUtil.adicionarMSGError("Todos os campos  são obrigatórios e devem ser preenchidos corretamente!");
				return  "erro";
			}
			
			if(descricao.trim().equals("")){
				FacesUtil.adicionarMSGError("Todos os campos são obrigatórios e devem ser preenchidos corretamente!");
				return  "erro";
			}
		
			
		}else{
			FacesUtil.adicionarMSGError("Os Dados devem ser preenchidos corretamente");
			return  "erro";
		}
		
		return null;
	}

}*/