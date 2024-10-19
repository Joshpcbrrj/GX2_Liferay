package br.com.gx2.service.impl;

import br.com.gx2.model.Auditoria;
import br.com.gx2.service.base.AuditoriaLocalServiceBaseImpl;
import br.com.gx2.service.dto.AuditoriaDto;
import br.com.gx2.service.validator.AuditoriaValidator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.List;

/**
 * A implementação do serviço local de auditoria.
 * Esta classe fornece métodos para adicionar, deletar e recuperar entradas de auditoria.
 */
@Component(
		property = "model.class.name=br.com.gx2.model.Auditoria",
		service = AopService.class,
		scope = ServiceScope.PROTOTYPE
)
public class AuditoriaLocalServiceImpl extends AuditoriaLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(AuditoriaLocalServiceImpl.class);
	private final AuditoriaValidator auditoriaValidator = new AuditoriaValidator();

	/**
	 * Adiciona uma nova entrada de auditoria ao banco de dados com parâmetros adicionais.
	 *
	 * @param auditoria a auditoria a ser adicionada
	 * @param serviceContext o contexto do serviço
	 * @return a auditoria adicionada
	 * @throws PortalException se ocorrer uma exceção de portal
	 */
	@Override
	public Auditoria addAuditoria(Auditoria auditoria, ServiceContext serviceContext) throws PortalException {
		_log.info("Iniciando a adição de uma nova auditoria.");

		// Validar entrada
		try {
			// Crie uma instância de AuditoriaDto com os dados de Auditoria
			AuditoriaDto auditoriaDto = new AuditoriaDto(
					auditoria.getAuditoriaId(), // Certifique-se de que esse método exista na sua classe Auditoria
					auditoria.getUsuario(),      // Supondo que você tenha um método getUsuario() na classe Auditoria
					auditoria.getAcao(),        // Supondo que você tenha um método getAcao() na classe Auditoria
					auditoria.getDataAcao()     // Supondo que você tenha um método getDataAcao() na classe Auditoria
			);

			// Validação do DTO
			auditoriaValidator.validate(auditoriaDto);
		} catch (Exception e) {
			_log.error("Falha na validação da auditoria: " + e.getMessage(), e);
			throw new PortalException("Erro na validação da auditoria: " + e.getMessage(), e);
		}

		// Marcar como nova para a camada de persistência
		auditoria.setNew(true);

		// Tentar adicionar a auditoria e tratar exceções de persistência
		try {
			Auditoria addedAuditoria = super.addAuditoria(auditoria); // Chamar o método base
			_log.info("Auditoria adicionada com sucesso: " + addedAuditoria.toString());
			return addedAuditoria;
		} catch (Exception e) {
			_log.error("Erro ao adicionar auditoria: " + e.getMessage(), e);
			throw new PortalException("Erro ao adicionar auditoria: " + e.getMessage(), e);
		}
	}


	/**
	 * Deleta a entrada de auditoria com o ID fornecido.
	 *
	 * @param auditoriaId a chave primária da auditoria a ser deletada
	 * @return a auditoria deletada
	 * @throws PortalException se não for encontrada uma auditoria com a chave primária
	 */
	@Override
	public Auditoria deleteAuditoria(long auditoriaId) throws PortalException {
		_log.info("Iniciando a deleção da auditoria com ID: " + auditoriaId);
		Auditoria auditoria = super.deleteAuditoria(auditoriaId);
		_log.info("Auditoria deletada com sucesso: " + auditoria.toString());
		return auditoria;
	}

	/**
	 * Recupera uma lista de entradas de auditoria com base em alguns critérios.
	 *
	 * @param start o limite inferior do intervalo de auditorias
	 * @param end o limite superior do intervalo de auditorias (não inclusivo)
	 * @return a lista de auditorias
	 */
	@Override
	public List<Auditoria> getAuditorias(int start, int end) {
		_log.info("Recuperando auditorias do intervalo " + start + " a " + end);
		return auditoriaPersistence.findAll(start, end);
	}

	/**
	 * Conta o número total de entradas de auditoria.
	 *
	 * @return o total de auditorias
	 */
	@Override
	public long countAuditorias() {
		long count = auditoriaPersistence.countAll();
		_log.info("Total de auditorias: " + count);
		return count;
	}

	/**
	 * Recupera uma entrada de auditoria pelo seu ID.
	 *
	 * @param auditoriaId o ID da auditoria
	 * @return a auditoria encontrada
	 * @throws PortalException se a auditoria não for encontrada
	 */
	public Auditoria getAuditoriaById(long auditoriaId) throws PortalException {
		_log.info("Buscando auditoria com ID: " + auditoriaId);

		// Tenta buscar a auditoria pelo ID
		Auditoria auditoria = auditoriaPersistence.fetchByPrimaryKey(auditoriaId);

		// Verifica se a auditoria foi encontrada
		if (auditoria == null) {
			_log.error("Auditoria não encontrada com ID: " + auditoriaId);
			throw new PortalException("Auditoria não encontrada com ID: " + auditoriaId);
		}

		// Retorna a auditoria encontrada
		return auditoria;
	}

}
