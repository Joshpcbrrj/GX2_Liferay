/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.gx2.service;

import br.com.gx2.model.Auditoria;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Auditoria. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AuditoriaServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AuditoriaService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>br.com.gx2.service.impl.AuditoriaServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the auditoria remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AuditoriaServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adiciona uma nova entrada de auditoria ao banco de dados com parâmetros adicionais.
	 *
	 * @param auditoria a auditoria a ser adicionada
	 * @param serviceContext o contexto do serviço
	 * @return a auditoria adicionada
	 * @throws PortalException se ocorrer uma exceção de portal
	 */
	public Auditoria addAuditoria(
			Auditoria auditoria, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Conta o número total de entradas de auditoria.
	 *
	 * @return o total de auditorias
	 */
	public long countAuditorias();

	/**
	 * Deleta a entrada de auditoria com o ID fornecido.
	 *
	 * @param auditoriaId a chave primária da auditoria a ser deletada
	 * @return a auditoria deletada
	 * @throws PortalException se não for encontrada uma auditoria com a chave primária
	 */
	public Auditoria deleteAuditoria(long auditoriaId) throws PortalException;

	/**
	 * Recupera uma entrada de auditoria pelo seu ID.
	 *
	 * @param auditoriaId o ID da auditoria
	 * @return a auditoria encontrada
	 * @throws PortalException se a auditoria não for encontrada
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Auditoria getAuditoriaById(long auditoriaId) throws PortalException;

	/**
	 * Recupera uma lista de entradas de auditoria com base em alguns critérios.
	 *
	 * @param start o limite inferior do intervalo de auditorias
	 * @param end o limite superior do intervalo de auditorias (não inclusivo)
	 * @return a lista de auditorias
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Auditoria> getAuditorias(int start, int end);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

}