package br.com.gx2.service.impl;

import br.com.gx2.model.SolicitacaoServico;
import br.com.gx2.service.base.SolicitacaoServicoLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.ArrayList;
import java.util.Date;

/**
 * Implementação da lógica de negócio para a entidade SolicitacaoServico.
 *
 * @author Josué B. Almeida
 */
public class SolicitacaoServicoLocalServiceImpl extends SolicitacaoServicoLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(SolicitacaoServicoLocalServiceImpl.class);

	/**
	 * Cria uma nova solicitação de serviço.
	 *
	 * @param clientePJId O ID do cliente PJ relacionado.
	 * @param codigoUnimed O código Unimed da solicitação.
	 * @param descricao A descrição da solicitação.
	 * @param status A situação da solicitação.
	 * @param prioridade A prioridade da solicitação.
	 * @param serviceContext O contexto do serviço.
	 * @return A solicitação de serviço criada.
	 * @throws PortalException Se ocorrer um erro durante a criação.
	 */
	public SolicitacaoServico addSolicitacaoServico(
			long clientePJId, String codigoUnimed, String descricao,
			int status, int prioridade, ServiceContext serviceContext)
			throws PortalException {

		_log.info("Iniciando a criação de uma nova solicitação de serviço.");

		long solicitacaoId = counterLocalService.increment(SolicitacaoServico.class.getName());
		SolicitacaoServico solicitacaoServico = createSolicitacaoServico(solicitacaoId);

		// Definir os campos
		solicitacaoServico.setClientePJId(clientePJId);
		solicitacaoServico.setCodigoUnimed(codigoUnimed);
		solicitacaoServico.setDescricao(descricao);
		solicitacaoServico.setDataSolicitacao(new Date()); // Data atual na criação
		solicitacaoServico.setStatus(status); // Alterado para "status"
		solicitacaoServico.setPrioridade(prioridade);
		solicitacaoServico.setUuid(serviceContext.getUuid());

		// Persistir a solicitação de serviço manualmente
		solicitacaoServicoPersistence.update(solicitacaoServico);

		_log.info("Solicitação de serviço criada com sucesso: " + solicitacaoServico);

		return solicitacaoServico;
	}

	/**
	 * Atualiza uma solicitação de serviço existente.
	 *
	 * @param solicitacaoId O ID da solicitação de serviço a ser atualizada.
	 * @param codigoUnimed O novo código Unimed da solicitação.
	 * @param descricao A nova descrição da solicitação.
	 * @param status A nova situação da solicitação.
	 * @param prioridade A nova prioridade da solicitação.
	 * @return A solicitação de serviço atualizada.
	 * @throws PortalException Se a solicitação de serviço não for encontrada.
	 */
	public SolicitacaoServico updateSolicitacaoServico(
			long solicitacaoId, String codigoUnimed, String descricao,
			int status, int prioridade) throws PortalException {

		_log.info("Iniciando a atualização da solicitação de serviço com ID: " + solicitacaoId);

		SolicitacaoServico solicitacaoServico = solicitacaoServicoPersistence.findByPrimaryKey(solicitacaoId);

		if (solicitacaoServico == null) {
			_log.error("Solicitação de serviço não encontrada: " + solicitacaoId);
			throw new PortalException("Solicitação de serviço não encontrada.");
		}

		// Definir os novos campos
		solicitacaoServico.setCodigoUnimed(codigoUnimed);
		solicitacaoServico.setDescricao(descricao);
		solicitacaoServico.setStatus(status); // Alterado para "status"
		solicitacaoServico.setPrioridade(prioridade);
		// Não alterar a data de solicitação

		// Persistir a solicitação de serviço manualmente
		solicitacaoServicoPersistence.update(solicitacaoServico);

		_log.info("Solicitação de serviço atualizada com sucesso: " + solicitacaoServico);

		return solicitacaoServico;
	}

	/**
	 * Remove uma solicitação de serviço pelo seu ID.
	 *
	 * @param solicitacaoId O ID da solicitação de serviço a ser removida.
	 * @return A instância da solicitação de serviço que foi removida.
	 * @throws PortalException Se a solicitação de serviço não for encontrada.
	 */
	@Override
	public SolicitacaoServico deleteSolicitacaoServico(long solicitacaoId) throws PortalException {
		_log.info("Removendo a solicitação de serviço com ID: " + solicitacaoId);

		SolicitacaoServico solicitacaoServico = solicitacaoServicoPersistence.findByPrimaryKey(solicitacaoId);

		if (solicitacaoServico == null) {
			_log.error("Solicitação de serviço não encontrada: " + solicitacaoId);
			throw new PortalException("Solicitação de serviço não encontrada.");
		}

		solicitacaoServicoPersistence.remove(solicitacaoId);

		_log.info("Solicitação de serviço removida com sucesso: " + solicitacaoId);

		return solicitacaoServico;
	}

	/**
	 * Busca uma solicitação de serviço pelo seu ID.
	 *
	 * @param solicitacaoId O ID da solicitação de serviço a ser buscada.
	 * @return A solicitação de serviço encontrada.
	 * @throws PortalException Se a solicitação de serviço não for encontrada.
	 */
	public SolicitacaoServico getSolicitacaoServico(long solicitacaoId) throws PortalException {
		_log.info("Buscando solicitação de serviço com ID: " + solicitacaoId);

		SolicitacaoServico solicitacaoServico = solicitacaoServicoPersistence.findByPrimaryKey(solicitacaoId);

		if (solicitacaoServico == null) {
			_log.error("Solicitação de serviço não encontrada: " + solicitacaoId);
			throw new PortalException("Solicitação de serviço não encontrada.");
		}

		return solicitacaoServico;
	}

	/**
	 * Recupera todas as solicitações de serviço.
	 *
	 * @return Lista de solicitações de serviço.
	 */
	public ArrayList<SolicitacaoServico> getAllSolicitacoes() {
		_log.info("Recuperando todas as solicitações de serviço.");

		return new ArrayList<>(solicitacaoServicoPersistence.findAll());
	}
}
