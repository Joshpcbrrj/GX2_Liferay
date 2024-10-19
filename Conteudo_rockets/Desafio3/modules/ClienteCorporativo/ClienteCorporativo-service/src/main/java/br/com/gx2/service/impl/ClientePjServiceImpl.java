package br.com.gx2.service.impl;

import br.com.gx2.model.ClientePj;
import br.com.gx2.service.base.ClientePjServiceBaseImpl;
import br.com.gx2.service.dto.ClientePjDto;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementação do serviço remoto para a entidade ClientePj.
 * Esta classe expõe os métodos do serviço via chamadas remotas.
 * O acesso remoto é seguro, pois é baseado em permissões e regras de segurança.
 *
 * @author Josué B.
 */
@Component(
		property = {
				"json.web.service.context.name=ccorp",
				"json.web.service.context.path=ClientePj"
		},
		service = AopService.class
)
public class ClientePjServiceImpl extends ClientePjServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(ClientePjServiceImpl.class);

	/**
	 * Adiciona um novo cliente PJ.
	 *
	 * @param razaoSocial Razão social do cliente.
	 * @param cnpj CNPJ do cliente.
	 * @param serviceContext Contexto do serviço.
	 * @return Response contendo os dados do cliente criado.
	 */
	public Response addClientePj(String razaoSocial, String cnpj, ServiceContext serviceContext) {
		_log.info("Adicionando um novo Cliente PJ: " + razaoSocial + ", CNPJ: " + cnpj);
		try {
			ClientePj clientePj = clientePjLocalService.addClientePj(razaoSocial, cnpj, serviceContext);
			_log.info("Cliente PJ adicionado com sucesso: ID " + clientePj.getClientePJId());
			return Response.status(Response.Status.CREATED).entity(toDto(clientePj)).build();
		} catch (PortalException e) {
			_log.error("Erro ao adicionar Cliente PJ: " + e.getMessage(), e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Erro ao adicionar Cliente PJ: " + e.getMessage()).build();
		}
	}

	/**
	 * Deleta um cliente PJ pelo seu ID.
	 *
	 * @param clientePJId ID do cliente a ser removido.
	 * @return Response contendo os dados do cliente deletado.
	 */
	public Response deleteClientePjById(long clientePJId) {
		_log.info("Deletando Cliente PJ: ID " + clientePJId);
		try {
			ClientePj clientePj = clientePjLocalService.deleteClientePjById(clientePJId);
			_log.info("Cliente PJ deletado com sucesso: ID " + clientePJId);
			return Response.status(Response.Status.OK).entity(toDto(clientePj)).build();
		} catch (PortalException e) {
			_log.error("Cliente PJ não encontrado: " + e.getMessage(), e);
			return Response.status(Response.Status.NOT_FOUND)
					.entity("Cliente PJ não encontrado: " + e.getMessage()).build();
		} catch (Exception e) {
			_log.error("Erro ao deletar Cliente PJ: " + e.getMessage(), e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Erro ao deletar Cliente PJ: " + e.getMessage()).build();
		}
	}

	/**
	 * Busca um cliente PJ pelo seu ID.
	 *
	 * @param clientePJId ID do cliente a ser buscado.
	 * @return Response com os dados do cliente, ou situação NOT_FOUND se não encontrado.
	 */
	public Response getClientePjById(long clientePJId) {
		_log.info("Buscando Cliente PJ: ID " + clientePJId);
		try {
			ClientePj clientePj = clientePjLocalService.getClientePjById(clientePJId);
			if (clientePj != null) {
				_log.info("Cliente PJ encontrado: ID " + clientePj.getClientePJId());
				return Response.status(Response.Status.OK).entity(toDto(clientePj)).build();
			} else {
				_log.warn("Cliente PJ não encontrado: ID " + clientePJId);
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch (Exception e) {
			_log.warn("Erro ao buscar Cliente PJ: " + e.getMessage(), e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Erro ao buscar Cliente PJ: " + e.getMessage()).build();
		}
	}

	/**
	 * Busca um cliente PJ pelo seu CNPJ.
	 *
	 * @param cnpj CNPJ do cliente a ser buscado.
	 * @return Response com os dados do cliente, ou situação NOT_FOUND se não encontrado.
	 */
	public Response getClientePjByCnpj(String cnpj) {
		_log.info("Buscando Cliente PJ pelo CNPJ: " + cnpj);
		try {
			ClientePj clientePj = clientePjLocalService.getClientePjByCnpj(cnpj);
			if (clientePj != null) {
				_log.info("Cliente PJ encontrado: ID " + clientePj.getClientePJId());
				return Response.status(Response.Status.OK).entity(toDto(clientePj)).build();
			} else {
				_log.warn("Cliente PJ não encontrado: CNPJ " + cnpj);
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch (Exception e) {
			_log.warn("Erro ao buscar Cliente PJ por CNPJ: " + e.getMessage(), e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Erro ao buscar Cliente PJ por CNPJ: " + e.getMessage()).build();
		}
	}

	/**
	 * Recupera todos os clientes PJ cadastrados.
	 *
	 * @return Response contendo a lista de todos os clientes.
	 */
	public Response getAllClientes() {
		try {
			_log.info("Recuperando todos os Clientes PJ");
			ArrayList<ClientePj> clientes = new ArrayList<>(clientePjLocalService.getAllClientes()); // Usando ArrayList
			return Response.status(Response.Status.OK).entity(toDtoList(clientes)).build();
		} catch (Exception e) {
			_log.error("Erro ao recuperar clientes: " + e.getMessage(), e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Erro ao recuperar clientes: " + e.getMessage()).build();
		}
	}

	/**
	 * Atualiza os dados de um cliente PJ existente.
	 *
	 * @param clientePJId ID do cliente a ser atualizado.
	 * @param razaoSocial Nova razão social do cliente.
	 * @param cnpj Novo CNPJ do cliente.
	 * @return Response contendo os dados do cliente atualizado.
	 */
	public Response updateClientePj(long clientePJId, String razaoSocial, String cnpj) {
		_log.info("Atualizando Cliente PJ: ID " + clientePJId);
		try {
			ClientePj clientePj = clientePjLocalService.updateClientePj(clientePJId, razaoSocial, cnpj);
			_log.info("Cliente PJ atualizado com sucesso: ID " + clientePj.getClientePJId());
			return Response.status(Response.Status.OK).entity(toDto(clientePj)).build();
		} catch (PortalException e) {
			_log.error("Erro ao atualizar Cliente PJ: " + e.getMessage(), e);
			return Response.status(Response.Status.NOT_FOUND)
					.entity("Cliente PJ não encontrado: " + e.getMessage()).build();
		} catch (Exception e) {
			_log.error("Erro ao atualizar Cliente PJ: " + e.getMessage(), e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Erro ao atualizar Cliente PJ: " + e.getMessage()).build();
		}
	}

	// Converte um ClientePj para ClientePjDto
	private ClientePjDto toDto(ClientePj clientePj) {
		ClientePjDto dto = new ClientePjDto();
		dto.setClientePJId(clientePj.getClientePJId());
		dto.setRazaoSocial(clientePj.getRazaoSocial());
		dto.setCnpj(clientePj.getCnpj());
		return dto;
	}

	// Converte uma lista de ClientePj para uma lista de ClientePjDto
	private List<ClientePjDto> toDtoList(List<ClientePj> clientes) {
		return clientes.stream()
				.map(this::toDto)
				.collect(Collectors.toList());
	}
}
