package br.com.secureedges.core.impl.controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.secureedges.core.IDAO;
import br.com.secureedges.core.IFachada;
import br.com.secureedges.core.dao.ComodoDAO;
import br.com.secureedges.core.dao.DispositivoDAO;
import br.com.secureedges.core.dao.SolicitacaoDAO;
import br.com.secureedges.core.dao.Tipo_DispositivoDAO;
import br.com.secureedges.core.dao.UsuarioDAO;
import br.com.secureedges.domain.Comodo;
import br.com.secureedges.domain.Dispositivo;
import br.com.secureedges.domain.EntidadeDominio;
import br.com.secureedges.domain.Resultado;
import br.com.secureedges.domain.Solicitacao;
import br.com.secureedges.domain.Tipo_Dispositivo;
import br.com.secureedges.domain.Usuario;
import br.com.secureedges.util.FacesUtil;
import br.com.secureedges.core.*;

public class Fachada implements IFachada {

	/**
	 * Mapa de DAOS, será indexado pelo nome da entidade O valor é uma instância
	 * do DAO para uma dada entidade;
	 */
	private static Map<String, IDAO> daos;

	/**
	 * Mapa para conter as regras de negócio de todas operações por entidade; O
	 * valor é um mapa que de regras de negócio indexado pela operação
	 */
	private Map<String, Map<String, List<IStrategy>>> rns;

	private Resultado resultado =  new Resultado();

	public Fachada() {
		/* Intânciando o Map de	 DAOS */
		daos = new HashMap<String, IDAO>();
		/* Intânciando o Map de Regras de Negócio */
		rns = new HashMap<String, Map<String, List<IStrategy>>>();

		/* Criando instâncias dos DAOs a serem utilizados */
		ComodoDAO comodoDAO = new ComodoDAO();
		DispositivoDAO dispositivoDAO = new DispositivoDAO();
		SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
		Tipo_DispositivoDAO tipo_DispositivoDAO = new Tipo_DispositivoDAO();
		UsuarioDAO usuarioDAO =  new UsuarioDAO();

		/* Adicionando cada dao no MAP indexando pelo nome da classe */
		daos.put(Comodo.class.getName(), (IDAO) comodoDAO);
		daos.put(Dispositivo.class.getName(), (IDAO) dispositivoDAO);
		daos.put(Solicitacao.class.getName(), (IDAO) solicitacaoDAO);
		daos.put(Tipo_Dispositivo.class.getName(), (IDAO) tipo_DispositivoDAO);
		daos.put(Usuario.class.getName(), (IDAO) usuarioDAO);

		/* Criando instâncias de regras de negócio a serem utilizados */
//		ValidadorDadosObrigatoriosFornecedor vrDadosObrigatoriosFornecedor = new ValidadorDadosObrigatoriosFornecedor();
//		ValidadorCnpj vCnpj = new ValidadorCnpj();
//		ValidadorDadosObrigatoriosVenda dadosObrigatoriosVenda = new ValidadorDadosObrigatoriosVenda();
//		ValidadorCpf validadorCpf = new ValidadorCpf();
//		ValidaDadosObrigatoriosUsuario obrigatoriosUsuario =  new ValidaDadosObrigatoriosUsuario();
//		ValidaDadosObrigatoriosGenero obrigatoriosGenero =  new ValidaDadosObrigatoriosGenero();
//		ValidaDadosObrigatoriosProduto obrigatoriosProduto =  new ValidaDadosObrigatoriosProduto();
//		ValidaQuantidadeProduto quantidadeProduto =  new ValidaQuantidadeProduto();

		/*
		 * Criando uma lista para conter as regras de negócio de fornencedor
		 * quando a operação for Salvar
		 */
//		List<IStrategy> rnsSalvarFornecedor = new ArrayList<IStrategy>();
//		List<IStrategy> rnsSalvarUsuario = new ArrayList<IStrategy>();
//		List<IStrategy> rnsSalvarGenero = new ArrayList<IStrategy>();
//		List<IStrategy> rnsSalvarProduto = new ArrayList<IStrategy>();
//		List<IStrategy> rnsSalvarVenda = new ArrayList<IStrategy>();
		/*
		 * Adicionando as regras a serem utilizadas na operação Salvar do
		 * fornecedor
		 */
//		rnsSalvarFornecedor.add(vrDadosObrigatoriosFornecedor);
//		rnsSalvarFornecedor.add(vCnpj);
		
		/*
		 * Adicionando as regras a serem utilizadas na operação Salvar do
		 * usuario
		 */
		
//		rnsSalvarUsuario.add(validadorCpf);
//		rnsSalvarUsuario.add(obrigatoriosUsuario);
//		
		/*
		 * Adicionando as regras a serem utilizadas na operação Salvar do
		 * Genero
		 */
//		rnsSalvarGenero.add(obrigatoriosGenero);
		
		// regras  produto
//		
//		rnsSalvarProduto.add(obrigatoriosProduto);
//		rnsSalvarProduto.add(quantidadeProduto);	
//		

		
		/*
		 * Adicionando as regras a serem utilizadas na operação Salvar do venda
		 */
//		rnsSalvarVenda.add(dadosObrigatoriosVenda);

		/*
		 * Cria o mapa que poderá conter todas as listas de regras de negócio
		 * específica por operação do fornecedor
		 */
		Map<String, List<IStrategy>> rnsFornecedor = new HashMap<String, List<IStrategy>>();
		Map<String, List<IStrategy>> rnsUsuario = new HashMap<String, List<IStrategy>>();
		Map<String, List<IStrategy>> rnsVenda = new HashMap<String, List<IStrategy>>();
		Map<String, List<IStrategy>> rnsGenero = new HashMap<String, List<IStrategy>>();
		Map<String, List<IStrategy>> rnsProduto = new HashMap<String, List<IStrategy>>();
		/*
		 * Adiciona a listra de regras na operação Salvar no mapa do fornecedor
		 * (lista criada na linha 70)
		 */
//		rnsFornecedor.put("Salvar", rnsSalvarFornecedor);
//		// usa a mesma rns por ser as mesmas regras de negocio
//		rnsFornecedor.put("Editar", rnsSalvarFornecedor);
//		
//		rnsVenda.put("Salvar", rnsSalvarVenda);
//		rnsVenda.put("Editar", rnsSalvarVenda);
//		
//		// rns usuario
//		rnsUsuario.put("Salvar", rnsSalvarUsuario);		
//		rnsUsuario.put("Editar", rnsSalvarUsuario);	
//		List<IStrategy> rnsConsultarUsuario = new ArrayList<IStrategy>();
//		rnsConsultarUsuario.add(validadorCpf);
//		rnsUsuario.put("Consultar", rnsConsultarUsuario);	
//		
//		// rns genero
//		rnsGenero.put("Salvar", rnsSalvarGenero);
//		rnsGenero.put("Editar", rnsSalvarGenero);
//		
//		// rns produto
//		
//		rnsProduto.put("Salvar", rnsSalvarProduto);
//
//		/*
//		 * Adiciona o mapa(criado na linha 79) com as regras indexadas pelas
//		 * operações no mapa geral indexado pelo nome da entidade
//		 */
//		rns.put(Fornecedor.class.getName(), rnsFornecedor);
//		rns.put(Usuario.class.getName(), rnsUsuario);
//		//rns.put(Venda.class.getName(), rnsVenda);
//		rns.put(Genero.class.getName(), rnsGenero);
//		rns.put(Produto.class.getName(),rnsProduto );

	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();
		String msg = executarRegras(entidade, "Salvar");
		System.out.println(entidade.getClass().getName());

		if (msg == null) {
			IDAO dao = daos.get(nmClasse);
			System.out.println("dao" + dao);
			try {
				dao.Salvar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
				FacesUtil.adicionarMSGInfo("Salvo com sucesso");
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");

			}
		} else {
			resultado.setMsg(msg);

		}

		return resultado;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();

		String msg = executarRegras(entidade, "Editar");

		if (msg == null) {
			IDAO dao = daos.get(nmClasse);
			try {
				dao.Editar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);

				FacesUtil.adicionarMSGInfo("Editado com sucesso");
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");

			}
		} else {
			resultado.setMsg(msg);

		}

		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();

		String msg = executarRegras(entidade, "Excluir");

		if (msg == null) {
			IDAO dao = daos.get(nmClasse);
			try {
				dao.Excluir(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);

				FacesUtil.adicionarMSGInfo("Excluido com sucesso");
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");

			}
		} else {
			resultado.setMsg(msg);

		}

		return resultado;
	}

	public List<EntidadeDominio> listar(EntidadeDominio entidade) {
		resultado = new Resultado();
		List<EntidadeDominio> lista = null;
		String nmClasse = entidade.getClass().getName();

		IDAO dao = daos.get(nmClasse);
		try {

			lista = (dao.listar());
		} catch (RuntimeException e) {
			e.printStackTrace();
			resultado.setMsg("Não foi possível realizar a listagem!");

		}

		return lista;

	}


	public static EntidadeDominio buscarGenerico(Long codigo, EntidadeDominio entidade) {
		String nmClasse = entidade.getClass().getName();
		IDAO dao = daos.get(nmClasse);
		EntidadeDominio entidadeRetorno = null;
		entidadeRetorno = dao.buscarPorCodigo(codigo);
		return entidadeRetorno;

	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		String nmClasse = entidade.getClass().getName();
		IDAO dao = daos.get(nmClasse);
		Usuario usuario = (Usuario) dao.consultar(entidade);
		String msg = executarRegras(entidade, "Consultar");
		if (msg == null) {
		if(usuario.getCPF() == null){
			resultado.setMsg("Informação válida");
			FacesUtil.adicionarMSGInfo("Informação válida");
			return resultado;
		}
		}
		else
		{
			FacesUtil.adicionarMSGError("Informação inválida");
			resultado.setMsg("Informação invalida");
			return resultado;
		}
		return resultado;
		

	}

	private String executarRegras(EntidadeDominio entidade, String operacao) {
		String nmClasse = entidade.getClass().getName();
		StringBuilder msg = new StringBuilder();

		Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);

		if (regrasOperacao != null) {
			List<IStrategy> regras = regrasOperacao.get(operacao);

			if (regras != null) {
				for (IStrategy s : regras) {
					String m = s.processar(entidade);

					if (m != null) {
						msg.append(m);
						msg.append("\n");
					}
				}
			}

		}

		if (msg.length() > 0)
			return msg.toString();
		else
			return null;
	}


	public Usuario autenticar(String cpf, String senha) {
		UsuarioDAO dao =  new UsuarioDAO();
		
		return dao.autenticar(cpf, senha);
		
	}

}