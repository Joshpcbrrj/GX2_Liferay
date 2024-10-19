package br.com.gx2.service.impl;

import br.com.gx2.model.SolicitacaoServico;
import br.com.gx2.service.SolicitacaoServicoLocalService;
import br.com.gx2.service.dto.SolicitacaoServicoDto;
import br.com.gx2.service.enums.PrioridadeEnum;
import br.com.gx2.service.enums.StatusEnum;
import br.com.gx2.service.base.SolicitacaoServicoServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static com.liferay.portal.kernel.service.ServiceContextThreadLocal.getServiceContext;

/**
 * Classe de implementação para o serviço remoto de SolicitacaoServico.
 *
 * @author Josué B. Almeida
 */
@Component(
		property = {
				"json.web.service.context.name=ccorp",
				"json.web.service.context.path=SolicitacaoServico"
		},
		service = AopService.class
)
public class SolicitacaoServicoServiceImpl extends SolicitacaoServicoServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(SolicitacaoServicoServiceImpl.class);

	/**
	 * Converte a entidade SolicitacaoServico em um DTO.
	 *
	 * @param solicitacaoServico A entidade a ser convertida.
	 * @return O DTO correspondente.
	 */
	private SolicitacaoServicoDto toDto(SolicitacaoServico solicitacaoServico) {
		SolicitacaoServicoDto dto = new SolicitacaoServicoDto();
		dto.setSolicitacaoId(solicitacaoServico.getSolicitacaoId());
		dto.setCodigoUnimed(solicitacaoServico.getCodigoUnimed());
		dto.setDescricao(solicitacaoServico.getDescricao());

		// Converte Date para LocalDate
		LocalDate dataSolicitacao = solicitacaoServico.getDataSolicitacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dto.setDataSolicitacao(dataSolicitacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		dto.setStatus(StatusEnum.fromCodigo(solicitacaoServico.getStatus()));
		dto.setPrioridade(PrioridadeEnum.fromCodigo(solicitacaoServico.getPrioridade()));
		dto.setClientePJId(solicitacaoServico.getClientePJId());
		return dto;
	}

	/**
	 * Adiciona uma nova solicitação de serviço.
	 *
	 * @param clientePJId ID do cliente PJ.
	 * @param codigoUnimed Código Unimed da solicitação.
	 * @param descricao Descrição da solicitação.
	 * @param status Status da solicitação.
	 * @param prioridade Prioridade da solicitação.
	 * @return Resposta com o status da criação.
	 * @throws PortalException Se ocorrer um erro ao validar ou criar a solicitação.
	 */
	public Response addSolicitacaoServico(
			long clientePJId, String codigoUnimed, String descricao,
			int status, int prioridade) throws PortalException {

		if (descricao == null || descricao.isEmpty()) {
			_log.error("Descrição não pode ser nula ou vazia.");
			return Response.status(Response.Status.BAD_REQUEST).entity("Descrição não pode ser nula ou vazia.").build();
		}

		_log.info("Iniciando a criação de uma nova solicitação de serviço.");

		SolicitacaoServico solicitacaoServico = solicitacaoServicoLocalService.addSolicitacaoServico(
				clientePJId, codigoUnimed, descricao, status, prioridade, getServiceContext());

		SolicitacaoServicoDto dto = toDto(solicitacaoServico);
		_log.info("Solicitação de serviço criada com sucesso: " + solicitacaoServico);

		return Response.status(Response.Status.CREATED).entity(dto).build();
	}

	/**
	 * Atualiza uma solicitação de serviço existente.
	 *
	 * @param solicitacaoId ID da solicitação a ser atualizada.
	 * @param codigoUnimed Código Unimed da solicitação.
	 * @param descricao Nova descrição da solicitação.
	 * @param status Novo status da solicitação.
	 * @param prioridade Nova prioridade da solicitação.
	 * @return Resposta com o status da atualização.
	 * @throws PortalException Se ocorrer um erro ao validar ou atualizar a solicitação.
	 */
	public Response updateSolicitacaoServico(
			long solicitacaoId, String codigoUnimed, String descricao,
			int status, int prioridade) throws PortalException {

		if (descricao == null || descricao.isEmpty()) {
			_log.error("Descrição não pode ser nula ou vazia.");
			return Response.status(Response.Status.BAD_REQUEST).entity("Descrição não pode ser nula ou vazia.").build();
		}

		_log.info("Iniciando a atualização da solicitação de serviço com ID: " + solicitacaoId);

		try {
			SolicitacaoServico solicitacaoServico = solicitacaoServicoLocalService.updateSolicitacaoServico(
					solicitacaoId, codigoUnimed, descricao, status, prioridade);

			SolicitacaoServicoDto dto = toDto(solicitacaoServico);
			_log.info("Solicitação de serviço atualizada com sucesso: " + solicitacaoServico);

			return Response.status(Response.Status.OK).entity(dto).build();
		} catch (PortalException e) {
			_log.error("Erro ao atualizar a solicitação de serviço: " + e.getMessage());
			throw new PortalException("Erro ao atualizar a solicitação de serviço: " + e.getMessage(), e);
		}
	}

	/**
	 * Obtém uma solicitação de serviço pelo ID.
	 *
	 * @param solicitacaoId ID da solicitação a ser buscada.
	 * @return Resposta com a solicitação encontrada.
	 */
	public Response getSolicitacaoServico(long solicitacaoId) {
		_log.info("Buscando solicitação de serviço com ID: " + solicitacaoId);

		try {
			SolicitacaoServico solicitacaoServico = solicitacaoServicoLocalService.getSolicitacaoServico(solicitacaoId);
			SolicitacaoServicoDto dto = toDto(solicitacaoServico);
			_log.info("Solicitação de serviço encontrada: " + solicitacaoServico);

			return Response.status(Response.Status.OK).entity(dto).build();
		} catch (PortalException e) {
			_log.error("Erro ao buscar a solicitação de serviço: " + e.getMessage());
			return Response.status(Response.Status.NOT_FOUND).entity("Solicitação não encontrada.").build();
		}
	}

	/**
	 * Recupera todas as solicitações de serviço.
	 *
	 * @return Resposta com a lista de solicitações.
	 */
	public Response getAllSolicitacoes() {
		_log.info("Recuperando todas as solicitações de serviço.");

		List<SolicitacaoServico> solicitacoes = solicitacaoServicoLocalService.getAllSolicitacoes();
		List<SolicitacaoServicoDto> solicitacoesDto = solicitacoes.stream().map(this::toDto).collect(Collectors.toList());

		_log.info("Total de solicitações de serviço recuperadas: " + solicitacoesDto.size());
		return Response.status(Response.Status.OK).entity(solicitacoesDto).build();
	}
}
