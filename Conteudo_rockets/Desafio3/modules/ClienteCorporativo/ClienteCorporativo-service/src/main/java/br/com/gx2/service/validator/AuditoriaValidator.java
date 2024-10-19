package br.com.gx2.service.validator;

import br.com.gx2.service.dto.AuditoriaDto;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Validador para AuditoriaDto.
 */
public class AuditoriaValidator {

    private static final Log _log = LogFactoryUtil.getLog(AuditoriaValidator.class);

    public void validate(AuditoriaDto auditoriaDto) {
        _log.info("Iniciando a validação de AuditoriaDto.");

        if (auditoriaDto == null) {
            _log.error("AuditoriaDto não pode ser nulo.");
            throw new IllegalArgumentException("AuditoriaDto não pode ser nulo.");
        }

        // Removido userId
        if (auditoriaDto.getAcao() == null || auditoriaDto.getAcao().isEmpty()) {
            _log.error("Ação não pode ser nula ou vazia.");
            throw new IllegalArgumentException("Ação não pode ser nula ou vazia.");
        }

        if (auditoriaDto.getDataAcao() == null) {
            _log.error("Data de ação não pode ser nula.");
            throw new IllegalArgumentException("Data de ação não pode ser nula.");
        }

        // Adicione uma verificação opcional para o 'usuario', se necessário
        if (auditoriaDto.getUsuario() == null || auditoriaDto.getUsuario().isEmpty()) {
            _log.error("Usuário não pode ser nulo ou vazio.");
            throw new IllegalArgumentException("Usuário não pode ser nulo ou vazio.");
        }

        _log.info("Validação de AuditoriaDto concluída com sucesso.");
    }
}
