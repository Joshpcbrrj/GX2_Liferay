package br.com.gx2.service.impl;

import br.com.gx2.model.ClientePj;
import br.com.gx2.service.base.ClientePjLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Serviço para gerenciamento de ClientePJ.
 * Implementa funcionalidades para manipular objetos do tipo ClientePj.
 * Atualizado para suportar paginação e melhorar uso de ArrayList<ClientePj>.
 *
 * @author Josué B. Almeida
 */
@Component(
		property = "model.class.name=br.com.gx2.model.ClientePj",
		service = AopService.class
)
public class ClientePjLocalServiceImpl extends ClientePjLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(ClientePjLocalServiceImpl.class);

	/**
	 * Adiciona um novo cliente PJ ao banco de dados.
	 *
	 * @param razaoSocial A razão social do cliente.
	 * @param cnpj O CNPJ do cliente.
	 * @param serviceContext O contexto do serviço, utilizado para informações adicionais.
	 * @return O objeto ClientePj criado.
	 * @throws PortalException Se ocorrer um erro durante o processo de criação.
	 */
	@Override
	public ClientePj addClientePj(String razaoSocial, String cnpj, ServiceContext serviceContext) throws PortalException {
		_log.info("Iniciando processo de criação de Cliente PJ com razão social: " + razaoSocial + " e CNPJ: " + cnpj);

		// Verificar se já existe um cliente com o mesmo CNPJ
		ClientePj existingClientePj = getClientePjByCnpj(cnpj);
		if (existingClientePj != null) {
			_log.error("Já existe um cliente com o CNPJ: " + cnpj);
			throw new PortalException("Já existe um cliente com o CNPJ fornecido.");
		}

		// Criação do objeto ClientePj e definição de um novo ID
		ClientePj clientePj = clientePjPersistence.create(counterLocalService.increment(ClientePj.class.getName()));
		_log.debug("Cliente PJ criado com ID temporário: " + clientePj.getClientePJId());

		// Definindo os atributos do cliente PJ
		clientePj.setRazaoSocial(razaoSocial);
		clientePj.setCnpj(cnpj);

		// Persistir o cliente PJ no banco de dados
		clientePj = clientePjPersistence.update(clientePj);
		_log.info("Cliente PJ criado com sucesso: " + clientePj.getClientePJId());

		return clientePj;
	}

	/**
	 * Deleta um cliente PJ pelo seu ID.
	 *
	 * @param clientePjId O ID do cliente PJ a ser deletado.
	 * @return O objeto ClientePj deletado.
	 * @throws PortalException Se ocorrer um erro durante a deleção ou se o cliente não for encontrado.
	 */
	@Override
	public ClientePj deleteClientePjById(long clientePjId) throws PortalException {
		_log.info("Deletando Cliente PJ com ID: " + clientePjId);

		// Deletar o cliente PJ usando o método de persistência
		ClientePj clientePj = clientePjPersistence.remove(clientePjId);
		_log.info("Cliente PJ deletado com sucesso: " + clientePjId);

		return clientePj;
	}

	/**
	 * Busca um cliente PJ pelo seu ID.
	 *
	 * @param clientePjId O ID do cliente PJ a ser buscado.
	 * @return O objeto ClientePj encontrado ou null se não encontrado.
	 */
	@Override
	public ClientePj getClientePjById(long clientePjId) {
		_log.info("Buscando Cliente PJ com ID: " + clientePjId);

		// Retornar o cliente PJ se encontrado
		ClientePj clientePj = clientePjPersistence.fetchByPrimaryKey(clientePjId);
		if (clientePj != null) {
			_log.info("Cliente PJ encontrado: " + clientePj.getClientePJId());
		} else {
			_log.warn("Cliente PJ com ID: " + clientePjId + " não encontrado.");
		}

		return clientePj;
	}

	/**
	 * Recupera todos os clientes PJ cadastrados.
	 *
	 * @return Lista de todos os clientes PJ.
	 */
	@Override
	public List<ClientePj> getAllClientes() {
		_log.info("Recuperando todos os Clientes PJ cadastrados.");

		// Recuperar todos os clientes PJ do banco de dados
		List<ClientePj> clientePjList = new ArrayList<>(clientePjPersistence.findAll());

		_log.info("Total de Clientes PJ recuperados: " + clientePjList.size());

		return clientePjList;
	}

	/**
	 * Atualiza os dados de um cliente PJ existente.
	 *
	 * @param clientePJId O ID do cliente PJ a ser atualizado.
	 * @param razaoSocial A nova razão social do cliente.
	 * @param cnpj O novo CNPJ do cliente.
	 * @return O objeto ClientePj atualizado.
	 * @throws PortalException Se ocorrer um erro durante a atualização ou se o cliente não for encontrado.
	 */
	@Override
	public ClientePj updateClientePj(long clientePJId, String razaoSocial, String cnpj) throws PortalException {
		_log.info("Atualizando Cliente PJ com ID: " + clientePJId);

		// Recupera o cliente PJ existente
		ClientePj clientePj = getClientePjById(clientePJId);
		if (clientePj == null) {
			_log.error("Cliente PJ com ID: " + clientePJId + " não encontrado para atualização.");
			throw new PortalException("Cliente PJ não encontrado.");
		}

		// Atualiza os campos do cliente PJ
		clientePj.setRazaoSocial(razaoSocial);
		clientePj.setCnpj(cnpj);

		// Persistir as mudanças
		clientePj = clientePjPersistence.update(clientePj);
		_log.info("Cliente PJ atualizado com sucesso: " + clientePj.getClientePJId());

		return clientePj;
	}

	/**
	 * Busca um cliente PJ pelo CNPJ.
	 * Utiliza paginação para garantir que apenas 1 resultado seja retornado.
	 *
	 * @param cnpj O CNPJ do cliente PJ a ser buscado.
	 * @return O objeto ClientePj encontrado ou null se não encontrado.
	 */
	public ClientePj getClientePjByCnpj(String cnpj) {
		_log.info("Buscando Cliente PJ com CNPJ: " + cnpj);

		// Usar uma consulta dinâmica para buscar o cliente PJ pelo CNPJ, limitando a 1 resultado
		DynamicQuery query = dynamicQuery()
				.add(RestrictionsFactoryUtil.eq("cnpj", cnpj));

		// Paginação, garantindo que apenas um resultado seja retornado
		List<ClientePj> clientes = new ArrayList<>(clientePjPersistence.findWithDynamicQuery(query, 0, 1));

		ClientePj clientePj = clientes.isEmpty() ? null : clientes.get(0);

		if (clientePj != null) {
			_log.info("Cliente PJ encontrado: " + clientePj.getClientePJId());
		} else {
			_log.warn("Cliente PJ com CNPJ: " + cnpj + " não encontrado.");
		}

		return clientePj;
	}
}
